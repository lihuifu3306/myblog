package com.crazy.article.controller;

import com.crazy.article.entity.ArticleMessageEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleMessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * <p>
 * 留言表 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-21
 */
@Api(value = "留言", tags = "文章留言")
@RestController
@RequestMapping("/articleMessage")
public class ArticleMessageController {

    @Autowired
    private ArticleMessageService service;

    @ApiOperation(value = "新增留言", notes = "新增文章留言")
    @PostMapping("/insertArticleMessage")
    public Result<Object> insertArticleMessage(@Valid  @RequestBody ArticleMessageEntity entity) {
        return service.insertArticleMessage(entity) ? Result.success() : Result.fail();
    }
}

