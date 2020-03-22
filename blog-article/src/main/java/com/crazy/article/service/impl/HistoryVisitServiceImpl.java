package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crazy.article.entity.HistoryVisitEntity;
import com.crazy.article.mapper.HistoryVisitMapper;
import com.crazy.article.service.HistoryVisitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazy.core.util.StringHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 历史访问量 服务实现类
 * </p>
 *
 * @author lhf
 * @since 2020-03-22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HistoryVisitServiceImpl extends ServiceImpl<HistoryVisitMapper, HistoryVisitEntity> implements HistoryVisitService {

    @Override
    public boolean saveOrUpdateEntity(String key, Integer count) {
        if (!StringHelper.isEmpty(key) && count != null) {
            QueryWrapper<HistoryVisitEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("day", key);
            HistoryVisitEntity one = this.getOne(wrapper);
            if (one == null) {
                return this.save(new HistoryVisitEntity(key, count, new Date(), new Date()));
            } else {
                one.setCount(count);
                one.setUpdateTime(new Date());
                return this.updateById(one);
            }
        }
        return false;
    }

    @Override
    public HistoryVisitEntity queryByDay(String day) {
        if (day != null) {
            QueryWrapper<HistoryVisitEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("day", day);
            return this.getOne(wrapper);
        }
        return null;
    }
}

