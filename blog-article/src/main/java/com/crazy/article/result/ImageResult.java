package com.crazy.article.result;

import io.swagger.annotations.ApiModel;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-24 20:13
 */
@ApiModel(value = "图片返回结果")
public class ImageResult {

    private Integer code;
    private String message;
    private String url;


    public static ImageResult success(String url) {
        return new ImageResult(1, "success", url);

    }

    public static ImageResult fail(String message) {
        return new ImageResult(0, message, null);
    }

    public static ImageResult fail() {
        return new ImageResult(0, "失败", null);
    }

    public ImageResult() {
    }

    @Override
    public String toString() {
        return "ImageResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageResult(Integer code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }
}
