package com.cmdi.sottle.utils;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
public class ApiResp<T> implements Serializable {


    @ApiModelProperty(value = "状态，0-成功，1-失败")
    private int code;

    @ApiModelProperty(value = "信息")
    private String msg;

    @ApiModelProperty(value = "数据体")
    private T data;

    public ApiResp(int i, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data=data;
    }


    // 默认Build构造方法,用于初始化默认参数


    public static ApiResp.ApiRespBuilder builder() {
        return new ApiResp.ApiRespBuilder();
    }

    public static class ApiRespBuilder<T> {
        private int code;
        private String msg;
        private T data;


        ApiRespBuilder() {}

        public ApiResp.ApiRespBuilder code(int code) {
            this.code = code;
            return this;
        }

        public ApiResp.ApiRespBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ApiResp.ApiRespBuilder msg(T data) {
            this.data = data;
            return this;
        }

        public ApiResp build() {
            return new ApiResp(this.code, this.msg,this.data);
        }

        public String toString() {
            return "ApiResp.ApiRespBuilder(code=" + this.code + ", msg=" + this.msg + ")";
        }
    }

    /**
     * 失败，不带错误信息
     */
    public static ApiResp<Object> error(String msg)
    {
        return new ApiResp<>(1, msg,null);
    }

    /**
     * 失败，不带错误信息
     */
    public static ApiResp<Object> error() {

        return new ApiResp<>(1, null,null);
    }

    /**
     * 成功，不带返回数据
     */
    public static ApiResp<Object> success(String msg) {

        return new ApiResp<>(0, msg,null);
    }

    /**
     * 成功，不带返回数据
     */
    public static ApiResp<Object> success() {

        return new ApiResp<>(0, "请求成功",null);
    }
}


