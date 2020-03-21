package com.crazy.article.service;

import com.crazy.article.entity.ArticleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
public interface ArticleService extends IService<ArticleEntity> {

    /**
     * 新增文章
     * @param entity  文章
     * @return  boolean
     */
    boolean insertArticle(ArticleEntity entity);

    /**
     * 通过分类id获取文章
     * @param categoryId 分类id
     * @return ArticleEntity
     */
    List<ArticleEntity> listArticleByCategory(Integer categoryId);

    /**
     * 根据文章id获取文章
     * @param id
     * @param queryMessage 是否查询留言和评论 true查询，false不查询
     * @return
     */
    ArticleEntity getArticleById(Integer id, boolean queryMessage);

}
