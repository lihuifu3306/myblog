package com.crazy.article.controller;

import com.crazy.article.entity.ArticleCommentEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.ArticleCommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@ApiIgnore
@Api(value = "评论", tags = "已弃用")
@RestController
@RequestMapping("/articleComment")
public class ArticleCommentController {

    @Autowired
    private ArticleCommentService service;

    @ApiOperation(value = "新增留言", notes = "返回JsonResult")
    @ApiResponses(value = {@ApiResponse(code=0, message = "成功"),@ApiResponse(code=-1, message = "失败")})
    @PostMapping("/insertArticleComment")
    public Result<Object> insertArticleComment(@Valid @RequestBody ArticleCommentEntity articleCommentEntity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        return service.insertArticleComment(articleCommentEntity) ? Result.success() : Result.fail();
    }

}

