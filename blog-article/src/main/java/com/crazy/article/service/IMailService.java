package com.crazy.article.service;

import com.crazy.article.entity.ArticleMessageCommentEntity;

import java.util.Map;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-26 14:02
 */
public interface IMailService {


    /**
     * 要发送给谁
     */
    void toSendWho(ArticleMessageCommentEntity entity);

    /**
     * 文本邮件
     * @param destination 目的地
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String destination, String subject, String content);

    /**
     * html 邮件
     */
    void sendHtmlMail(Map<String, Object> map);

    /**
     * 含附件邮件
     * @param destination 目的地
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    void sendAttachmentMail(String destination, String subject, String content, String filePath);


}
