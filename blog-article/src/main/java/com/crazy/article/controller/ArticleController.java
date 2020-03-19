package com.crazy.article.controller;


import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.service.ArticleService;
import com.crazy.core.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@RestController
@RequestMapping("/article")
@Api(value = "文章", tags = "文章管理")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @ApiOperation(value = "新增文章", notes = "返回JsonResult")
    @PostMapping("/insertArticle")
    public JsonResult insertArticle(@Valid @ApiParam ArticleEntity articleEntity, BindingResult res) {
        if (res.hasErrors()) {
            return JsonResult.BindingError(res);
        }
        return service.insertArticle(articleEntity) ? JsonResult.SUCCESS : JsonResult.FAILURE;
    }

}
