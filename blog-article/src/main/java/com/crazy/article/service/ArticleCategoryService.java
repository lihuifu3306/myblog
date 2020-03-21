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
     * 修改文章分类
     * @param entity 文章分离
     * @return boolean
     */
    boolean updateArticleCategory(ArticleCategoryEntity entity);

    /**
     * 删除文章分类
     * @param id 分类id
     * @return boolean
     */
    boolean deleteCategory(Long id);

    /**
     * 获取文章分类
     * @return list
     */
    List<Map<String, Object>> listCategory();

    /**
     * 根据id和name查询分类
     * @param id
     * @param name
     * @return
     */
    ArticleCategoryEntity queryCategoryByIdAndName(Integer id, String name);

}
