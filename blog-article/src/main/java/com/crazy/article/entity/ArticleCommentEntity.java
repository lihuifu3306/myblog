package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@ApiModel(value = "评论", description = "留言评论")
@TableName("article_comment")
public class ArticleCommentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父评论id
     */
    @ApiModelProperty(name = "parentId", value = "父级id,是顶级评论则为0", required = true)
    @TableField("parent_id")
    @NotNull(message = "父id不能为空")
    private Long parentId;

    /**
     * 文章id
     */
    @ApiModelProperty(name = "messageId", value = "留言id", required = true)
    @TableField("message_id")
    @NotNull(message = "留言id不能为空")
    private Long messageId;

    /**
     * 发表人的name
     */
    @ApiModelProperty(name = "commentName", value = "评论人的name", required = true)
    @TableField("comment_name")
    @NotBlank(message = "姓名不能为空")
    private String commentName;


    /**
     * 留言或者评论内容
     */
    @ApiModelProperty(name = "content", value = "留言或者评论内容", required = true)
    @TableField("content")
    @NotBlank(message = "内容不能为空")
    private String content;

    /**
     * email
     */
    @ApiModelProperty(name = "email", value = "邮箱", required = true)
    @TableField("email")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 点赞数
     */
    @ApiModelProperty(name = "likeCount", value = "点赞数", example = "1002")
    @TableField("like_count")
    private Integer likeCount;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2020-03-19")
    @TableField("create_time")
    private Date createTime;

    @Override
    public String toString() {
        return "ArticleCommentEntity{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", messageId=" + messageId +
                ", commentName='" + commentName + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", likeCount=" + likeCount +
                ", createTime=" + createTime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String blogUrl) {
        this.email = blogUrl;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
