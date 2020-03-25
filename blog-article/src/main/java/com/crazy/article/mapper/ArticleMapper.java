package com.crazy.article.mapper;

import com.crazy.article.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    /**
     * 增加文章访问量
     * @return boolean
     */
    boolean addArticlePageView(Long id);

}
