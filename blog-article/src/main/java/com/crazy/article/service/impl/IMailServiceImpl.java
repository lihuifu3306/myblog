package com.crazy.article.service.impl;

import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.crazy.article.result.util.Constant;
import com.crazy.article.service.ArticleMessageCommentService;
import com.crazy.article.service.ArticleService;
import com.crazy.article.service.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-26 14:10
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Async
public class IMailServiceImpl implements IMailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMessageCommentService messageService;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void toSendWho(ArticleMessageCommentEntity entity) {
        ArticleEntity article = articleService.getArticleById(entity.getArticleId(), false);
        HashMap<String, Object> map = new HashMap<>();
        if (article != null) {
            map.put("subject", "来自失丶忆博客的通知");
            map.put("commentName", entity.getName());
            map.put("articleTitle", article.getTitle());
            map.put("content", entity.getContent());
            if (entity.getParentId() != 0) {
                ArticleMessageCommentEntity commentEntity = messageService.getById(entity.getParentId());
                map.put("to", entity.getEmail());
                map.put("targetName", commentEntity.getName());
                sendHtmlMail(map);
            }
            map.put("to", from);
            map.put("targetName", "失丶忆");
            sendHtmlMail(map);
        }
    }

    /**
     * @param destination 目的地
     * @param subject 主题
     * @param content 内容
     */

    @Override
    public void sendSimpleMail(String destination, String subject, String content) {
        System.out.println("destination = " + destination);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(destination);
        message.setSubject(subject);
        message.setText(content);
        logger.info("发件人：" + from + "--收件人：" + destination + "--发件内容:" + content);
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMail(Map<String, Object> map) {
        //获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            String to = (String) map.get("to");
            messageHelper.setTo(to);
            messageHelper.setSubject((String) map.get("subject"));
            Context context = new Context();
            context.setVariables(map);
            String content = templateEngine.process("shiyiblog@qq.com".equals(to) ? Constant.MY_TEMPLATE : Constant.MS_TEMPLATE, context);
            messageHelper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }
    }

    @Override
    public void sendAttachmentMail(String destination, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(destination);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            //日志信息
            logger.info("发件人：" + from + "--收件人：" + destination + "--发件内容:" + content + "--附件" + fileName);
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }
    }
}
