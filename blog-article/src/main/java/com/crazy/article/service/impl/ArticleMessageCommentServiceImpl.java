package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.crazy.article.entity.FriendShipEntity;
import com.crazy.article.mapper.ArticleMessageCommentMapper;
import com.crazy.article.service.ArticleMessageCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazy.article.service.FriendShipService;
import com.crazy.article.service.IMailService;
import com.crazy.core.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 留言评论表 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleMessageCommentServiceImpl extends ServiceImpl<ArticleMessageCommentMapper, ArticleMessageCommentEntity> implements ArticleMessageCommentService {


    /**
     * 邮件service
     */
    @Autowired
    private IMailService mailService;

    /**
     * 友情链接
     */
    @Autowired
    private FriendShipService friendShipService;

    @Override
    public ArticleMessageCommentEntity insertMessageComment(ArticleMessageCommentEntity entity) {
        entity.setCreateTime(new Date());
        if (this.save(entity)) {
            mailService.toSendWho(entity);
            insertFriendShip(entity);
            return entity;
        }
        return null;
    }

    @Override
    public List<ArticleMessageCommentEntity> listMessageByArticleId(Long articleId) {
        QueryWrapper<ArticleMessageCommentEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", articleId);
        return this.list(wrapper);
    }

    private void insertFriendShip(ArticleMessageCommentEntity entity) {
        if (entity.getBlogUrl() != null) {
            FriendShipEntity shipEntity = new FriendShipEntity("", entity.getBlogUrl(), Constant.FRIEND_SHIP, entity.getName(), new Date(), new Date());
            friendShipService.insertFriendShipEntity(shipEntity);
        }
    }
}
