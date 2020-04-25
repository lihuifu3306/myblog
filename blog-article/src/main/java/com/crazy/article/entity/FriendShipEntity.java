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
 * 友情链接
 * </p>
 *
 * @author lhf
 * @since 2020-03-23
 */
@ApiModel(value = "友情链接", description = "友情链接")
@TableName("friend_ship")
public class FriendShipEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 友情链接name
     */
    @ApiModelProperty(name = "name", value = "姓名", required = true)
    @NotBlank(message = "姓名不能为空")
    @TableField("name")
    private String name;

    /**
     * 友情链接url
     */
    @ApiModelProperty(name = "friendUrl", value = "友情链接url", required = true)
    @NotBlank(message = "链接不能为空")
    @TableField("friend_url")
    private String friendUrl;

    /**
     * 类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 删除时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 0正常，1删除
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 删除时间
     */
    @TableField("delete_time")
    private Date deleteTime;

    public FriendShipEntity() {
    }

    public FriendShipEntity(String name, String friendUrl, Integer type, String description, Date createTime, Date updateTime) {
        this.name = name;
        this.friendUrl = friendUrl;
        this.type = type;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getFriendUrl() {
        return friendUrl;
    }

    public void setFriendUrl(String friendUrl) {
        this.friendUrl = friendUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "FriendShipEntity{" +
        "id=" + id +
        ", name=" + name +
        ", friendUrl=" + friendUrl +
        ", type=" + type +
        ", description=" + description +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", deleteTime=" + deleteTime +
        "}";
    }
}
