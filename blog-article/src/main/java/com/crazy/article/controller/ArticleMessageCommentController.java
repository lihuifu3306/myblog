package com.crazy.article.controller;


import com.crazy.article.entity.ArticleMessageCommentEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleMessageCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 留言评论表 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-25
 */
@Api(value = "留言评论表")
@RestController
@RequestMapping("/articleMessage")
public class ArticleMessageCommentController {

    @Autowired
    private ArticleMessageCommentService service;

    @ApiOperation(value = "新增留言、评论")
    @PostMapping("/insertMessage")
    public Result<Object> insertMessage(@Valid @RequestBody ArticleMessageCommentEntity entity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        return service.insertMessageComment(entity) != null ? Result.success() : Result.fail();
    }

}

