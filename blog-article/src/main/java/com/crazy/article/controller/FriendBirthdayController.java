package com.crazy.article.controller;


import com.crazy.article.entity.FriendBirthdayEntity;
import com.crazy.article.service.FriendBirthdayService;
import com.crazy.article.service.FriendShipService;
import com.crazy.article.task.BirthdayTask;
import com.crazy.core.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhf
 * @since 2020-07-18
 */
@RestController
@RequestMapping("/birthday")
public class FriendBirthdayController {


    @Autowired
    private FriendBirthdayService service;

    @Autowired
    private BirthdayTask task;

    @RequestMapping("/saveOrUpdate")
    public JsonResult saveOrUpdate(@Valid @RequestBody FriendBirthdayEntity entity) {
        return service.saveOrUpdateBir(entity) ? JsonResult.SUCCESS : JsonResult.FAILURE;
    }


    @RequestMapping("/queryBirthday")
    public JsonResult queryBirthday() {
        List<FriendBirthdayEntity> entities = service.queryBirthday();
        task.task();
        return JsonResult.success(entities);
    }

}

