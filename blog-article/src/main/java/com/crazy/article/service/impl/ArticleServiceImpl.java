package com.crazy.article.service.impl;

import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.mapper.ArticleMapper;
import com.crazy.article.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Override
    public boolean insertArticle(ArticleEntity entity) {
        entity.setCreateTime(new Date());
        return this.save(entity);
    }
}
