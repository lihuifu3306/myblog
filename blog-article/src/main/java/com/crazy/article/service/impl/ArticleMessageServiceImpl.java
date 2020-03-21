package com.crazy.article.service.impl;

import com.crazy.article.entity.ArticleMessageEntity;
import com.crazy.article.mapper.ArticleMessageMapper;
import com.crazy.article.service.ArticleMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 留言表 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-21
 */
@Service
public class ArticleMessageServiceImpl extends ServiceImpl<ArticleMessageMapper, ArticleMessageEntity> implements ArticleMessageService {

    @Override
    public boolean insertArticleMessage(ArticleMessageEntity entity) {
        entity.setCreateTime(new Date());
        return  this.save(entity);
    }

    @Override
    public List<ArticleMessageEntity> listMessageByArticleId(Integer articleId) {
        return this.baseMapper.listMessageByArticleId(articleId);
    }
}
