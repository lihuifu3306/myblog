package com.crazy.article.service;

import com.crazy.article.entity.ArticleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
public interface ArticleService extends IService<ArticleEntity> {

    boolean insertArticle(ArticleEntity entity);

}
