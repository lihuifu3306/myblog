package com.crazy.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 留言表
 * </p>
 *
 * @author lhf
 * @since 2020-03-21
 */
@TableName("article_message")
@ApiModel(value = "留言", description = "文章留言")
public class ArticleMessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    @ApiModelProperty(name = "articleId", value = "文章id", required = true)
    @TableField("article_id")
    private Long articleId;

    /**
     * 姓名
     */
    @ApiModelProperty(name = "name", value = "姓名", required = true)
    @TableField("name")
    private String name;

    /**
     * url
     */
    @ApiModelProperty(name = "blogUrl", value = "博客链接的url")
    @TableField("blog_url")
    private String blogUrl;

    /**
     * 邮箱
     */
    @ApiModelProperty(name = "email", value = "邮箱", required = true)
    @TableField("email")
    private String email;

    /**
     * 内容
     */
    @ApiModelProperty(name = "content", value = "内容", required = true)
    @TableField("content")
    private String content;

    /**
     * 点赞数
     */
    @TableField("like_count")
    private Integer likeCount;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 评论信息
     */
    @TableField(exist = false)
    private List<ArticleCommentEntity> commentEntityList;


    public List<ArticleCommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<ArticleCommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    @Override
    public String toString() {
        return "ArticleMessageEntity{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", name='" + name + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
