package com.crazy.article.mapper;

import com.crazy.article.entity.ArticleCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@Mapper
public interface ArticleCommentMapper extends BaseMapper<ArticleCommentEntity> {

    /**
     * 通过留言id查询评论信息
     * @param messageIds 留言ids
     * @return entity
     */
    List<ArticleCommentEntity> listCommentByMessageId(@Param("messageIds") List<Long> messageIds);

}
