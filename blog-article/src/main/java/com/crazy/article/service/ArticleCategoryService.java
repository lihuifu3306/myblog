package com.crazy.article.service;

import com.crazy.article.entity.ArticleCategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-20
 */
public interface ArticleCategoryService extends IService<ArticleCategoryEntity> {

    /**
     * 新增文章分类
     * @param entity 文章分类
     * @return boolean
     */
    boolean insertArticleCategory(ArticleCategoryEntity entity);

    /**
     * 获取文章分类
     * @return list
     */
    List<Map<String, Object>> listCategory();

}
