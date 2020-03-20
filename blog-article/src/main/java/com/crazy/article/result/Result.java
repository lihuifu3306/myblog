package com.crazy.article.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-20 17:54
 * 统一返回
 */

@ApiModel(value = "统一返回类", description = "统一返回类")
public class Result<T> {

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 状态 成功0，失败-1
     */
    @ApiModelProperty(name = "code", value = "状态码，0成功,-1失败", required = true)
    private Integer code;

    /**
     * 信息说明
     */
    @ApiModelProperty(name = "message", value = "信息说明", required = true)
    private String message;

    /**
     * 返回的数据
     */
    private T data;


    /**
     * 请求成功
     */
    public static <T> Result<T> success(T t) {
        return new Result<>(0, "success", t);
    }

    /**
     * 请求成功
     */
    public static <T> Result<T> success() {
        return success(null);
    }


    /**
     * 请求失败
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(-1, message, null);
    }

    public static <T> Result<T> fail() {
        return new Result<>(-1, "error", null);
    }

    public static <T> Result<T> BindingError(BindingResult res) {
        if (!res.hasErrors()) {
            return Result.success();
        }
        List<ObjectError> list = res.getAllErrors();
        List<String> collect = list.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return Result.fail(collect.toString());
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", date=" + data +
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
