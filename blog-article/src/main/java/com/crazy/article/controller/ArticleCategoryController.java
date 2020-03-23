package com.crazy.article.controller;

import com.crazy.article.entity.ArticleCategoryEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-20
 */
@Api(value = "文章分类", tags = "文章分类")
@RestController
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

    @Autowired
    private ArticleCategoryService service;

    @ApiOperation(value = "新增文章分类")
    @PostMapping("/insertArticleCategory")
    public Result<Object> insertArticleCategory(@Valid @RequestBody ArticleCategoryEntity entity,  BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        if (service.queryCategoryById(entity.getName()) != null) {
            return Result.fail("分类名已存在");
        }
        return service.insertArticleCategory(entity) != null ? Result.success() : Result.fail();
    }


    @ApiOperation(value = "修改文章分类")
    @PostMapping("/updateArticleCategory")
    public Result<Object> updateArticleCategory(@Valid @RequestBody ArticleCategoryEntity entity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        if (service.queryCategoryByIdAndName(entity.getId(), entity.getName()) != null) {
            return Result.fail("分类名已存在");
        }
        return service.updateArticleCategory(entity) != null ? Result.success() : Result.fail();
    }

    @ApiOperation(value = "获取文章分类")
    @GetMapping("/listCategory")
    public Result<Object> listCategory(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> map = service.listCategory(pageNum, pageSize);
        PageInfo<Map<String, Object>> info = new PageInfo<>(map);
        return Result.success(info);
    }


    @ApiOperation(value = "删除文章分类")
    @DeleteMapping("/deleteCategory/{id}")
    public Result<Object> deleteCategory(@PathVariable Long id) {
        return service.deleteCategory(id)? Result.success() : Result.fail();
    }
}

