package com.crazy.article.service;

import com.crazy.article.entity.ArticleCommentEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
public interface ArticleCommentService extends IService<ArticleCommentEntity> {

    /**
     * 新增评论
     * @param articleCommentEntity
     * @return boolean
     */
    boolean insertArticleComment(ArticleCommentEntity articleCommentEntity);

    /**
     * 通过留言id查询评论信息
     * @param messageIds 留言id
     * @return entity
     */
    Map<Long, List<ArticleCommentEntity>> listCommentByMessageId(List<Long> messageIds);

}
