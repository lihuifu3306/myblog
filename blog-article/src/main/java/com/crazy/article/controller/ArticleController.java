package com.crazy.article.controller;

import com.crazy.article.entity.ArticleEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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

    @ApiOperation(value = "新增文章")
    @PostMapping("/insertArticle")
    public Result<Object> insertArticle(@Valid @RequestBody ArticleEntity articleEntity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        return service.insertArticle(articleEntity) ? Result.success() : Result.fail();
    }


    @ApiOperation(value = "修改文章")
    @PostMapping("/updateArticle")
    public Result<Object> updateArticle(@Valid @RequestBody ArticleEntity entity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        entity.setUpdateTime(new Date());
        return service.updateById(entity) ? Result.success() : Result.fail();
    }


    @ApiOperation(value = "根据分类id获取文章")
    @GetMapping("/listArticleByCategory")
    @ApiImplicitParam(name = "categoryId", value = "分类的id", paramType = "query", dataType = "int", required = true)
    public Result<Object> listArticleByCategory(@RequestParam("categoryId") Integer categoryId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleEntity> list = service.listArticleByCategory(categoryId);
        PageInfo<ArticleEntity> info = new PageInfo<>(list);
        return Result.success(info);
    }

    @ApiOperation(value = "根据文章id获取文章信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章id", paramType = "path", dataType = "int", required = true),
            @ApiImplicitParam(name = "queryMessage", value = "是否查询文章的留言信息", paramType = "path", dataType = "boolean", required = true)
    })
    @GetMapping("/getArticleById/{id}/{queryMessage}")
    public Result<ArticleEntity> getArticleById(@PathVariable Integer id, @PathVariable boolean queryMessage) {
        ArticleEntity entity = service.getArticleById(id, queryMessage);
        return Result.success(entity);
    }

}
