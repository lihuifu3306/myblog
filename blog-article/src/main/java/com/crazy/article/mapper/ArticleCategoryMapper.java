package com.crazy.article.mapper;

import com.crazy.article.entity.ArticleCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-20
 */
@Mapper
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategoryEntity> {


    /**
     * 获取分类信息并统计
     * @return list
     */
    List<Map<String, Object>> listCategory();

}
