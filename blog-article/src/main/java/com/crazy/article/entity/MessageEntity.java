package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhf
 * @since 2020-07-17
 */
@TableName("message")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 默认为0留言，1为回复
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 编码
     */
    @TableField("code")
    private String code;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    @TableField(exist = false)
    private List<MessageEntity> childMsg;

    public List<MessageEntity> getChildMsg() {
        return childMsg;
    }

    public void setChildMsg(List<MessageEntity> childMsg) {
        this.childMsg = childMsg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", code=" + code +
        ", name=" + name +
        ", content=" + content +
        "}";
    }
}
