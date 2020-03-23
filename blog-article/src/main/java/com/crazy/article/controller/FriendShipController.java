package com.crazy.article.controller;


import com.crazy.article.entity.FriendShipEntity;
import com.crazy.article.result.Result;
import com.crazy.article.service.FriendShipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 友情链接 前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-03-23
 */

@Api(value = "友情链接",tags = "友情链接")
@RestController
@RequestMapping("/friendShipEntity")
public class FriendShipController {


    @Autowired
    private FriendShipService service;

    @ApiOperation(value = "新增友情链接")
    @PostMapping("/insertFriendShip")
    public Result<Object> insertFriendShip(@Valid @RequestBody FriendShipEntity entity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        FriendShipEntity shipEntity = service.queryFriendByUrl(entity.getFriendUrl());
        if (shipEntity != null) {
            return Result.fail("链接已存在");
        }
        return service.insertFriendShipEntity(entity) != null ? Result.success() : Result.success();
    }

    @ApiOperation(value = "修改友情链接")
    @PostMapping("/updateFriendShip")
    public Result<Object> updateFriendShip(@Valid @RequestBody FriendShipEntity entity, BindingResult res) {
        if (res.hasErrors()) {
            return Result.BindingError(res);
        }
        FriendShipEntity shipEntity = service.queryFriendByIdAndUrl(entity.getId(), entity.getFriendUrl());
        if (shipEntity != null) {
            return Result.fail("链接已存在");
        }
        return service.updateFriendShipEntity(entity) != null ? Result.success() : Result.fail();
    }

    @ApiOperation(value = "根据id删除友情链接")
    @DeleteMapping("/deleteById/{id}")
    public Result<Object> deleteById(@PathVariable Integer id) {
        return service.deleteById(id) ? Result.success() : Result.fail();
    }

    @ApiOperation(value = "查询友情链接")
    @GetMapping("/listFriendShip")
    public Result<List<FriendShipEntity>> listFriendShip() {
        List<FriendShipEntity> list = service.list();
        return Result.success(list);
    }


}

