package com.crazy.core.result;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lhf
 * @create 2019-02-27
 */
public class JsonResult {
    private int status;
    private String message;
    private Object data;

    public final static JsonResult SUCCESS = new JsonResult(0, "OK");
    public final static JsonResult FAILURE = new JsonResult(-1, "Failure");
    public final static JsonResult NO_JURISDICTION = new JsonResult(-5, "没有权限访问，请登陆!");
    public final static JsonResult NO_LOGIN_JURISDICTION = new JsonResult(-10, "无页面访问权限!");

    public static JsonResult success(Object obj) {
        return new JsonResult(0, "OK", obj);
    }

    public static JsonResult failureMsg(String message) {
        return new JsonResult(-1, message, null);
    }

    public static JsonResult successMsg(String message) {
        return new JsonResult(0, message, null);
    }


    public static JsonResult success(int status, Object obj) {
        return new JsonResult(status, "OK", obj);
    }

    public static JsonResult failure(Object obj) {
        return new JsonResult(-1, "error", obj);
    }

    public static JsonResult BindingError(BindingResult res) {
        if (!res.hasErrors()) {
            return SUCCESS;
        }
        List<ObjectError> list = res.getAllErrors();
        List<String> collect = list.stream().map((l) -> l.getDefaultMessage()).collect(Collectors.toList());
        return JsonResult.failure(collect);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JsonResult that = (JsonResult) o;

        if (status != that.status) {
            return false;
        }
        if (!message.equals(that.message)) {
            return false;
        }
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + message.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public JsonResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public JsonResult() {
    }


}
