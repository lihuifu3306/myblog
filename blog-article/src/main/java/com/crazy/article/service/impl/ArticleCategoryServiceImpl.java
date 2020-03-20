package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.ArticleCategoryEntity;
import com.crazy.article.mapper.ArticleCategoryMapper;
import com.crazy.article.service.ArticleCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-20
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategoryEntity> implements ArticleCategoryService {

    @Override
    public boolean insertArticleCategory(ArticleCategoryEntity entity) {
        entity.setCreateTime(new Date());
        return this.save(entity);
    }

    @Override
    public List<Map<String, Object>> listCategory() {
        return this.baseMapper.listCategory();
    }
}
