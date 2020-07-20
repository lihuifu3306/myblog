package com.crazy.article.mapper;

import com.crazy.article.entity.MessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lhf
 * @since 2020-07-17
 */
@Mapper
public interface MessageMapper extends BaseMapper<MessageEntity> {

}
