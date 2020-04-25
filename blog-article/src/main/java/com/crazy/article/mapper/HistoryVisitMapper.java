package com.crazy.article.mapper;

import com.crazy.article.entity.FriendShipEntity;
import com.crazy.article.entity.HistoryVisitEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 历史访问量 Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-03-22
 */
@Mapper
public interface HistoryVisitMapper extends BaseMapper<HistoryVisitEntity> {


}
