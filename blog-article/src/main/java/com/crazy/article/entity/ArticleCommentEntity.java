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
    @ApiModelProperty(name = "articleId", value = "文章的id", required = true)
    @TableField("article_id")
    @NotNull(message = "文章id不能为空")
    private Long articleId;

    /**
     * 发表人的name
     */
    @ApiModelProperty(name = "messageName", value = "发表人的name", required = true)
    @TableField("message_name")
    @NotBlank(message = "发表人的name不能为空")
    private String messageName;


    /**
     * 留言或者评论内容
     */
    @ApiModelProperty(name = "content", value = "留言或者评论内容", required = true)
    @TableField("content")
    @NotBlank(message = "内容不能为空")
    private String content;

    /**
     * 评论人的name
     */
    @ApiModelProperty(name = "articleName", value = "评论人的name", example = "赵四")
    @TableField("comment_name")
    private String commentName;

    /**
     * 点赞数
     */
    @ApiModelProperty(name = "commentLikeCount", value = "点赞数", example = "1002")
    @TableField("comment_like_count")
    private Integer commentLikeCount;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2020-03-19")
    @TableField("create_time")
    private Date createTime;

    /**
     * 评论时间
     */
    @ApiModelProperty(name = "commentTime", value = "评论时间", example = "2020-03-19")
    @TableField("comment_time")
    private Date commentTime;

    @Override
    public String toString() {
        return "ArticleCommentEntity{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", articleId=" + articleId +
                ", messageName='" + messageName + '\'' +
                ", content='" + content + '\'' +
                ", commentName='" + commentName + '\'' +
                ", commentLikeCount=" + commentLikeCount +
                ", createTime=" + createTime +
                ", commentTime=" + commentTime +
                '}';
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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
