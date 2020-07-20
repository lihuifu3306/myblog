package com.crazy.article.controller;


import com.crazy.article.service.MessageService;
import com.crazy.core.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shiyi
 * @since 2020-07-17
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService service;

    @RequestMapping("/queryMessageByCode")
    public JsonResult queryMessageByCode(@RequestParam("code") String code) {
        return JsonResult.success(service.queryMessage(code));
    }

}

