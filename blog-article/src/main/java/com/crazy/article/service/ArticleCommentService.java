package com.crazy.article.service;

import com.crazy.article.entity.ArticleCommentEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
public interface ArticleCommentService extends IService<ArticleCommentEntity> {

    boolean insertArticleComment(ArticleCommentEntity articleCommentEntity);

}
