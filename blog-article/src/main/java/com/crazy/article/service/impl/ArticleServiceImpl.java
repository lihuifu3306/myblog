package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.mapper.ArticleMapper;
import com.crazy.article.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleService {

    @Override
    public boolean insertArticle(ArticleEntity entity) {
        entity.setCreateTime(new Date());
        return this.save(entity);
    }

    @Override
    public List<ArticleEntity> listArticleByCategory(Integer categoryId) {
        if (categoryId == null || categoryId == 0) {
            return null;
        }
        QueryWrapper<ArticleEntity> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "create_time").eq("category_id", categoryId).orderByAsc("create_time");
        return this.list(wrapper);
    }
}
