package com.crazy.article.controller;


import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleService;
import com.crazy.core.result.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public Result<Object> insertArticle(@Valid @ApiParam ArticleEntity articleEntity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        return service.insertArticle(articleEntity) ? Result.success() : Result.fail();
    }


    @ApiOperation(value = "根据分类id获取文章")
    @GetMapping("/listArticleByCategory/{categoryId}")
    @ApiImplicitParam(name = "categoryId", value = "分类的id", paramType = "path", dataType = "int", required = true)
    public Result<List<ArticleEntity>> listArticleByCategory(@PathVariable Integer categoryId) {
        List<ArticleEntity> list = service.listArticleByCategory(categoryId);
        return Result.success(list);
    }

    @ApiOperation(value = "根据文章id获取文章信息")
    @GetMapping("/getArticleById/{id}")
    public Result<ArticleEntity> getArticleById(@PathVariable String id) {
        ArticleEntity entity = service.getById(id);
        return Result.success(entity);
    }

}
