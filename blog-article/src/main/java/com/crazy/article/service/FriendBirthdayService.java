package com.crazy.article.service;

import com.crazy.article.entity.FriendBirthdayEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhf
 * @since 2020-07-18
 */
public interface FriendBirthdayService extends IService<FriendBirthdayEntity> {

    boolean saveOrUpdateBir(FriendBirthdayEntity entity);

    List<FriendBirthdayEntity> queryBirthday();
}
