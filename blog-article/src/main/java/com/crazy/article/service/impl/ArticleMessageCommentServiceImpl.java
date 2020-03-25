package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.crazy.article.mapper.ArticleMessageCommentMapper;
import com.crazy.article.service.ArticleMessageCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public ArticleMessageCommentEntity insertMessageComment(ArticleMessageCommentEntity entity) {
        entity.setCreateTime(new Date());
        if (this.save(entity)) {
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
}
