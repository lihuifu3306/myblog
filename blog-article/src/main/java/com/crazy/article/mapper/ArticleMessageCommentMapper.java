package com.crazy.article.mapper;

import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 留言评论表 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-25
 */
@Mapper
public interface ArticleMessageCommentMapper extends BaseMapper<ArticleMessageCommentEntity> {

}
