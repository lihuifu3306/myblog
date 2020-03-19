package com.crazy.article.controller;


import com.crazy.article.entity.ArticleCommentEntity;
import com.crazy.article.service.ArticleCommentService;
import com.crazy.core.result.JsonResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@Api(value = "评论", tags = "文章评论留言区")
@RestController
@RequestMapping("/articleComment")
public class ArticleCommentController {

    @Autowired
    private ArticleCommentService service;

    @ApiOperation(value = "新增留言", notes = "返回JsonResult")
    @ApiResponses(value = {@ApiResponse(code=0, message = "成功"),@ApiResponse(code=-1, message = "失败")})
    @PostMapping("/insertArticleComment")
    public JsonResult insertArticleComment(@Valid @ApiParam(name = "留言") ArticleCommentEntity articleCommentEntity, BindingResult res) {
        if (res.hasErrors()) {
            return JsonResult.BindingError(res);
        }
        return service.insertArticleComment(articleCommentEntity) ? JsonResult.SUCCESS : JsonResult.FAILURE;
    }

}

