package com.crazy.article.service;

import com.crazy.article.entity.ArticleMessageEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * <p>
 * 留言表 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-21
 */
public interface ArticleMessageService extends IService<ArticleMessageEntity> {


    /**
     * 新增留言
     * @param entity 留言实体
     * @return boolean
     */
    boolean insertArticleMessage(ArticleMessageEntity entity);

    /**
     * 根据文章id查询留言
     * @param articleId 文章id
     * @return entity
     */
    List<ArticleMessageEntity> listMessageByArticleId(Integer articleId);

}
