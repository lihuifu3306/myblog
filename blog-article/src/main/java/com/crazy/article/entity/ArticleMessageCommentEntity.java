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
 * 留言评论表
 * </p>
 *
 * @author lhf
 * @since 2020-03-25
 */
@ApiModel(value = "留言评论实体")
@TableName("article_message_comment")
public class ArticleMessageCommentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "留言id，修改时不能为空")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    @NotNull(message = "文章id，不能为空")
    @ApiModelProperty(value = "文章id", required = true)
    @TableField("article_id")
    private Long articleId;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "评论的父级id不能为空，顶级0", required = true)
    @NotNull(message = "评论的父级id不能为空")
    @TableField("parent_id")
    private Long parentId;

    /**
     * 评论人的name
     */
    @ApiModelProperty(value = "评论人的姓名不能为空", required = true)
    @NotBlank(message = "评论人的姓名不能为空")
    @TableField("name")
    private String name;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容不能为空", required = true)
    @NotBlank(message = "内容不能为空")
    @TableField("content")
    private String content;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "邮箱不能为空", required = true)
    @NotBlank(message = "邮箱不能为空")
    @TableField("email")
    private String email;

    /**
     * 链接
     */
    @ApiModelProperty(value = "网站的url")
    @TableField("blog_url")
    private String blogUrl;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    @Override
    public String toString() {
        return "ArticleMessageCommentEntity{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
