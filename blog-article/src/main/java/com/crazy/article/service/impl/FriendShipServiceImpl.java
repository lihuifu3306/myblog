package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crazy.article.entity.FriendShipEntity;
import com.crazy.article.mapper.FriendShipMapper;
import com.crazy.article.service.FriendShipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 友情链接 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FriendShipServiceImpl extends ServiceImpl<FriendShipMapper, FriendShipEntity> implements FriendShipService {

    @Override
    public FriendShipEntity insertFriendShipEntity(FriendShipEntity entity) {
        entity.setCreateTime(new Date());
        if (this.save(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public FriendShipEntity updateFriendShipEntity(FriendShipEntity entity) {
        entity.setUpdateTime(new Date());
        if (this.updateById(entity)) {
            return entity;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        UpdateWrapper<FriendShipEntity> wrapper = new UpdateWrapper<>();
        wrapper.set("is_delete", 1);
        wrapper.eq("id", id);
        return this.update(wrapper);
    }

    @Override
    public List<FriendShipEntity> listFriendShip() {
        return this.list();
    }

    @Override
    public FriendShipEntity queryFriendByUrl(String url) {
        QueryWrapper<FriendShipEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("friend_url", url);
        return this.getOne(wrapper);
    }

    @Override
    public FriendShipEntity queryFriendByIdAndUrl(Integer id, String url) {
        QueryWrapper<FriendShipEntity> wrapper = new QueryWrapper<>();
        wrapper.ne("id", id);
        wrapper.eq("friend_url", url);
        return this.getOne(wrapper);
    }
}
