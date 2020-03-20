package com.crazy.article.controller;


import com.crazy.article.entity.ArticleCategoryEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleCategoryService;
import com.crazy.core.result.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/articleCategoryEntity")
public class ArticleCategoryController {

    @Autowired
    private ArticleCategoryService service;

    @ApiOperation(value = "新增文章分类")
    @PostMapping("/insertArticleCategory")
    public Result<Object> insertArticleCategory(@Valid ArticleCategoryEntity entity,  BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        return service.insertArticleCategory(entity) ? Result.success() : Result.fail();
    }

    @ApiOperation(value = "获取文章分类")
    @GetMapping("/listCategory")
    public Result<Object> listCategory(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> map = service.listCategory();
        PageInfo<Map<String, Object>> info = new PageInfo<>(map);
        return Result.success(info);
    }


}

