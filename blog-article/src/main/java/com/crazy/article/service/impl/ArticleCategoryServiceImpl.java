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
    public ArticleCategoryEntity insertArticleCategory(ArticleCategoryEntity entity) {
        entity.setCreateTime(new Date());
        if (this.save(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public ArticleCategoryEntity updateArticleCategory(ArticleCategoryEntity entity) {
        entity.setUpdateTime(new Date());
        if (this.updateById(entity)) {
            return entity;
        }
        return null;
    }

    @Override
  /*  @Caching(
            evict = {
                    @CacheEvict(value = "category", allEntries = true),
                    @CacheEvict(value = "listCategory", allEntries = true)
            }
    )*/
    public boolean deleteCategory(Long id) {
        UpdateWrapper<ArticleCategoryEntity> wrapper = new UpdateWrapper<>();
        wrapper.set("is_delete", 1);
        wrapper.set("delete_time", new Date());
        wrapper.eq("id", id);
        return this.update(wrapper);
    }


    @Override
    public List<Map<String, Object>> listCategory(Integer pageNum, Integer pageSize) {
        return this.baseMapper.listCategory();
    }


    @Override
    public ArticleCategoryEntity queryCategoryByIdAndName(Integer id, String name) {
        QueryWrapper<ArticleCategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.ne("id", id);
        wrapper.eq("name", name);
        return this.getOne(wrapper);
    }

    @Override
    public ArticleCategoryEntity queryCategoryById(String name) {
        QueryWrapper<ArticleCategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return this.getOne(wrapper);
    }
}
