package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@TableName("article_comment")
public class ArticleCommentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父评论id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 发表人的name
     */
    @TableField("article_name")
    private String articleName;

    /**
     * 评论人的name
     */
    @TableField("comment_name")
    private String commentName;

    /**
     * 点赞数
     */
    @TableField("comment_like_count")
    private Integer commentLikeCount;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 评论时间
     */
    @TableField("comment_time")
    private Date commentTime;


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

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public Integer getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Integer commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "ArticleCommentEntity{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", articleName=" + articleName +
        ", commentName=" + commentName +
        ", commentLikeCount=" + commentLikeCount +
        ", createTime=" + createTime +
        ", commentTime=" + commentTime +
        "}";
    }
}
