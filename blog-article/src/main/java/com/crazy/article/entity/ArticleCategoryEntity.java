package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 文章分类
 * </p>
 *
 * @author lhf
 * @since 2020-03-20
 */
@ApiModel(value = "文章分类", description = "文章分类")
@TableName("article_category")
public class ArticleCategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章分类
     */
    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名
     */
    @ApiModelProperty(name = "name", value = "分类名", required = true)
    @TableField("name")
    @NotBlank(message = "分类名不能为空")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", value = "描述")
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(name = "updateTime", value = "修改时间")
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty(name = "isDelete", value = "是否删除")
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 删除时间
     */
    @ApiModelProperty(name = "deleteTime", value = "修改时间")
    @TableField("delete_time")
    private Date deleteTime;

    /**
     * 文章数量
     */
    @TableField(exist = false)
    @ApiModelProperty(name = "count", value = "文章数量")
    private Integer count;


    @Override
    public String toString() {
        return "ArticleCategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", deleteTime=" + deleteTime +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}
