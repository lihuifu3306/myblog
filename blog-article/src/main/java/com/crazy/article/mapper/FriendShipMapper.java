package com.crazy.article.mapper;

import com.crazy.article.entity.FriendShipEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 友情链接 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-23
 */
@Mapper
public interface FriendShipMapper extends BaseMapper<FriendShipEntity> {

    List<FriendShipEntity> listFriendShip(@Param("isAll") Boolean isAll);

}
