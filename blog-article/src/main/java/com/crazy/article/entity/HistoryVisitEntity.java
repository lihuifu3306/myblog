package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 历史访问量
 * </p>
 *
 * @author lhf
 * @since 2020-03-22
 */
@TableName("history_visit")
public class HistoryVisitEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 某一天
     */
    @TableField("day")
    private String day;

    /**
     * 访问量
     */
    @TableField("count")
    private Integer count;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    public HistoryVisitEntity() {
    }

    public HistoryVisitEntity(String day, Integer count, Date createTime, Date updateTime) {
        this.day = day;
        this.count = count;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "HistoryVisitEntity{" +
        "id=" + id +
        ", day=" + day +
        ", count=" + count +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
