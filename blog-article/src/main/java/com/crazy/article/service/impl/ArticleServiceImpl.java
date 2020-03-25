package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.ArticleCommentEntity;
import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.crazy.article.entity.ArticleMessageEntity;
import com.crazy.article.mapper.ArticleMapper;
import com.crazy.article.service.ArticleCommentService;
import com.crazy.article.service.ArticleMessageCommentService;
import com.crazy.article.service.ArticleMessageService;
import com.crazy.article.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private ArticleMessageCommentService messageCommentService;

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

    @Override
    public ArticleEntity getArticleById(Long id, boolean queryMessage) {
        if (this.baseMapper.addArticlePageView(id)) {
            ArticleEntity entity = this.getById(id);
            if (queryMessage) {
                List<ArticleMessageCommentEntity> entities = messageCommentService.listMessageByArticleId(id);
                entity.setMessageEntities(entities);
                return entity;
            }
            /*if (queryMessage) {
                List<ArticleMessageEntity> entities = messageService.listMessageByArticleId(id);
                if (entities != null && entities.size() > 0) {
                    List<Long> list = entities.stream().map(ArticleMessageEntity::getId).collect(Collectors.toList());
                    Map<Long, List<ArticleCommentEntity>> map = commentService.listCommentByMessageId(list);
                    if (map != null && map.size() > 0) {
                        entities.forEach(x -> x.setCommentEntityList(map.get(x.getId())));
                    }
                    entity.setMessageEntities(entities);
                }
            }
            return entity*/;
         }
        return null;
    }
}
