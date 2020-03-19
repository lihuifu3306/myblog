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
 * 文章
 * </p>
 *
 * @author lhf
 * @since 2020-03-19
 */
@ApiModel(value = "文章", description = "用于文章管理")
@TableName("article")
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(name = "id", value = "文章id，修改的时候必填", required = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章标题
     */
    @ApiModelProperty(name = "title", value = "文章标题", required = true)
    @NotBlank(message = "文章标题不能为空")
    @TableField("title")
    private String title;

    /**
     * 文章内容
     */
    @ApiModelProperty(name = "articleContent", value = "文章内容", required = true)
    @NotBlank(message = "文章内容不能为空")
    @TableField("article_content")
    private String articleContent;

    /**
     * 文章类型id
     */
    @ApiModelProperty(name = "categoryId", value = "文章类型", required = true)
    @NotNull(message = "文章类型不能为空")
    @TableField("category_id")
    private Integer categoryId;

    /**
     * 文章访问量
     */
    @TableField("page_view")
    private Integer pageView;

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

    /**
     * 是否删除
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 删除时间
     */
    @TableField("delete_time")
    private Date deleteTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
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
        return "ArticleEntity{" +
        "id=" + id +
        ", title=" + title +
        ", articleContent=" + articleContent +
        ", categoryId=" + categoryId +
        ", pageView=" + pageView +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", deleteTime=" + deleteTime +
        "}";
    }
}
