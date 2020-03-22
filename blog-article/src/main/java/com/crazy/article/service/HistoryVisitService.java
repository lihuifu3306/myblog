package com.crazy.article.service;

import com.crazy.article.entity.HistoryVisitEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 历史访问量 服务类
 * </p>
 *
 * @author lhf
 * @since 2020-03-22
 */
public interface HistoryVisitService extends IService<HistoryVisitEntity> {


    /**
     * 新增或者修改
     * @return boolean
     */
    boolean saveOrUpdateEntity(String key, Integer count);

    /**
     * 通过日期查询访问量
     * @param day 日期
     * @return entity
     */
    HistoryVisitEntity queryByDay(String day);

}
