package com.crazy.article.service;

import com.crazy.article.entity.MessageEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * @author shiyi
 * @since 2020-07-17
 */
public interface MessageService extends IService<MessageEntity> {

    List<MessageEntity> queryMessage(String code);
}
