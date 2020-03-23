package com.crazy.article.service;

import com.crazy.article.entity.FriendShipEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 友情链接 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-23
 */
public interface FriendShipService extends IService<FriendShipEntity> {

    /**
     * 新增友情链接
     * @return entity
     */
    FriendShipEntity insertFriendShipEntity(FriendShipEntity entity);

    /**
     * 修改友情链接
     * @return entity
     */
    FriendShipEntity updateFriendShipEntity(FriendShipEntity entity);

    /**
     * 根据id删除友情链接
     */
    boolean deleteById(Integer id);

    List<FriendShipEntity> listFriendShip();

    /**
     * 通过url查询链接
     * @param url url
     * @return entity
     */
    FriendShipEntity queryFriendByUrl(String url);

    /**
     * 通过id和url查询链接
     * @param id 主键
     * @param url url
     */
    FriendShipEntity queryFriendByIdAndUrl(Integer id, String url);

}
