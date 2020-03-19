package com.crazy.article.service.impl;

import com.crazy.article.entity.ArticleCommentEntity;
import com.crazy.article.mapper.ArticleCommentMapper;
import com.crazy.article.service.ArticleCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleCommentEntity> implements ArticleCommentService {

    @Override
    public boolean insertArticleComment(ArticleCommentEntity articleCommentEntity) {
        articleCommentEntity.setCreateTime(new Date());
        return this.save(articleCommentEntity);
    }
}
