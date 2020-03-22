package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crazy.article.entity.ArticleCategoryEntity;
import com.crazy.article.mapper.ArticleCategoryMapper;
import com.crazy.article.service.ArticleCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional(rollbackFor = Exception.class)
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategoryEntity> implements ArticleCategoryService {

    @Override
    public boolean insertArticleCategory(ArticleCategoryEntity entity) {
        entity.setCreateTime(new Date());
        return this.save(entity);
    }

    @Override
    public boolean updateArticleCategory(ArticleCategoryEntity entity) {
        entity.setUpdateTime(new Date());
        return this.updateById(entity);
    }

    @Override
    public boolean deleteCategory(Long id) {
        UpdateWrapper<ArticleCategoryEntity> wrapper = new UpdateWrapper<>();
        wrapper.set("is_delete", 1);
        wrapper.set("delete_time", new Date());
        wrapper.eq("id", id);
        return this.update(wrapper);
    }

    @Override
    public List<Map<String, Object>> listCategory() {
        return this.baseMapper.listCategory();
    }

    @Override
    public ArticleCategoryEntity queryCategoryByIdAndName(Integer id, String name) {
        QueryWrapper<ArticleCategoryEntity> wrapper = new QueryWrapper<>();
        if (id != null) {
            wrapper.ne("id", id);
        }
        wrapper.eq("name", name);
        return this.getOne(wrapper);
    }
}
