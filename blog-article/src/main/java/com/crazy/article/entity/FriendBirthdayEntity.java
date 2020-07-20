package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhf
 * @since 2020-07-18
 */
@TableName("friend_birthday")
public class FriendBirthdayEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Length(min = 0, max = 10,message = "姓名长度不能超过10")
    @TableField("name")
    private String name;

    /**
     * 备注
     */
    @TableField("comment")
    private String comment;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @TableField("email")
    private String email;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 生日
     */
    @NotBlank(message = "生日不能为空")
    @TableField("birthday")
    private Date birthday;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 0友好，1不友好
     */
    @TableField("is_friendly")
    private Integer isFriendly;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsFriendly() {
        return isFriendly;
    }

    public void setIsFriendly(Integer isFriendly) {
        this.isFriendly = isFriendly;
    }

    @Override
    public String toString() {
        return "FriendBirthdayEntity{" +
        "id=" + id +
        ", name=" + name +
        ", comment=" + comment +
        ", email=" + email +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", createTime=" + createTime +
        ", isFriendly=" + isFriendly +
        "}";
    }
}
