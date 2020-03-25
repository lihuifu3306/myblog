package com.crazy.article.service;

import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 留言评论表 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-25
 */
public interface ArticleMessageCommentService extends IService<ArticleMessageCommentEntity> {

    /**
     * 新增留言评论
     */
    ArticleMessageCommentEntity insertMessageComment(ArticleMessageCommentEntity entity);

    /**
     * 通过文章id查询留言
     */
    List<ArticleMessageCommentEntity> listMessageByArticleId(Long articleId);



}
