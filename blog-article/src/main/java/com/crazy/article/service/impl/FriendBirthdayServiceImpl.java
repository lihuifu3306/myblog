package com.crazy.article.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.FriendBirthdayEntity;
import com.crazy.article.mapper.FriendBirthdayMapper;
import com.crazy.article.service.FriendBirthdayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazy.article.service.IMailService;
import com.crazy.core.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-07-18
 */
@Service
public class FriendBirthdayServiceImpl extends ServiceImpl<FriendBirthdayMapper, FriendBirthdayEntity> implements FriendBirthdayService {

    public static final String BIRTHDAY_LIST = "birthdayList";



    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public boolean saveOrUpdateBir(FriendBirthdayEntity entity) {
        if (entity.getId() == 0) {
            entity.setCreateTime(new Date());
        }
        redisTemplate.delete(BIRTHDAY_LIST);
        if (this.saveOrUpdate(entity)) {
            List<FriendBirthdayEntity> entities = listBirthday();
            if (entities != null && entities.size() > 0) {
                redisTemplate.opsForValue().set(BIRTHDAY_LIST, JSON.toJSON(entities).toString());
            }
        }

        return false;
    }

    /*
        1. 从redis获取好友列表。
        2. 如果日期和当前时间是否小于7天
        3. 小于7天，给发邮件给失忆
     */

    @Override
    public List<FriendBirthdayEntity> queryBirthday() {
        String list = redisTemplate.opsForValue().get(BIRTHDAY_LIST);
        if (list == null) {
            List<FriendBirthdayEntity> entities = listBirthday();
            if (entities != null && entities.size() > 0) {
                redisTemplate.opsForValue().set(BIRTHDAY_LIST, JSON.toJSON(entities).toString());
                return entities;
            }
        } else {
            return JSON.parseArray(list, FriendBirthdayEntity.class);
        }
        return null;
    }

    private List<FriendBirthdayEntity> listBirthday() {
        QueryWrapper<FriendBirthdayEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("is_friendly", 0);
        return this.list(wrapper);
    }


}
