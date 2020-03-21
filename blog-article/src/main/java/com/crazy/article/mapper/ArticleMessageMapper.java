package com.crazy.article.mapper;

import com.crazy.article.entity.ArticleMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 留言表 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-21
 */
@Mapper
public interface ArticleMessageMapper extends BaseMapper<ArticleMessageEntity> {

    /**
     * 根据文章id查询留言信息
     * @param articleId 文章id
     * @return entity
     */
    List<ArticleMessageEntity> listMessageByArticleId(@Param("articleId") Integer articleId);

}
