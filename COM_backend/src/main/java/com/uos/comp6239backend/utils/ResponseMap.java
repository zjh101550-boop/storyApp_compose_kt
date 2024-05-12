package com.uos.comp6239backend.utils;

/**
 * @title: ResponseMap
 * @Author Hym
 * @Date: 2024-03-15 21:26
 * @Description:
 * @Version 1.0
 */

import java.io.Serializable;

/**
 * 返回数据
 */
public class ResponseMap<T> {

    public static <T> ResponseMap.ResultData<T> notFound() {
        return notFound("资源未找到！");
    }

    public static <T> ResponseMap.ResultData<T> notFound(String msg) {
        return new ResultData<>(ResultCode.SOURCE_NOT_FOUND_ERROR, "fail", msg);
    }

    public static <T> ResponseMap.ResultData<T> error() {
        return error(ResultCode.SYSTEM_ERROR, "未知异常，请联系管理员");
    }

    public static <T> ResponseMap.ResultData<T> error(String msg) {
        return error(ResultCode.SYSTEM_ERROR, msg);
    }

    public static <T> ResponseMap.ResultData<T> error(int code, String msg) {
        return new ResultData<>(code, "fail", msg);
    }

    public static <T> ResponseMap.ResultData<T> toLogError() {
        return toLogError("请先登录！");
    }

    public static <T> ResponseMap.ResultData<T> toLogError(String msg) {
        return new ResultData<>(ResultCode.IDENTITY_AUTHENTICATION_ERROR, "toLogIN", msg);
    }

    public static <T> ResponseMap.ResultData<T> jurisdictionError() {
        return new ResultData<>(ResultCode.PERMISSION_DENIED_ERROR, "fail", "权限不足！");
    }

    public static <T> ResponseMap.ResultData<T> ok(String msg) {
        return new ResultData<>(ResultCode.SUCCESS, "ok", msg);
    }

    public static <T> ResponseMap.ResultData<T> fail(String msg) {
        return new ResultData<>(ResultCode.PARAM_ERROR, "fail", msg);
    }

    public static <T> ResponseMap.ResultData<T> ok(T data) {
        return new ResultData<>(ResultCode.SUCCESS, "ok", "请求成功", data);
    }

    public static <T> ResponseMap.ResultData<T> okWithData(T data) {
        return ok(data);
    }

    public static <T> ResponseMap.ResultData<T> ok() {
        return new ResultData<>(ResultCode.SUCCESS, "ok", "请求成功！");
    }

    public static class ResultData<T> implements Serializable {
        private static final long serialVersionUID = -2467879912967236962L;
        private int code;
        private String sym;
        private String msg;
        private T data;

        public ResultData() {
        }

        ResultData(int code, String sym, String msg) {
            this.code = code;
            this.sym = sym;
            this.msg = msg;
        }

        ResultData(int code, String sym, String msg, T data) {
            this.code = code;
            this.sym = sym;
            this.msg = msg;
            this.data = data;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getSym() {
            return sym;
        }

        public void setSym(String sym) {
            this.sym = sym;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isError() {
            return !this.sym.equals("ok");
        }
    }

    public static class ResultCode {
        //系统错误
        public final static int SYSTEM_ERROR = 5001;
        //参数错误
        public final static int PARAM_ERROR = 4001;
        //身份认证错误
        public final static int IDENTITY_AUTHENTICATION_ERROR = 4031;
        //权限被拒绝错误
        public final static int PERMISSION_DENIED_ERROR = 4032;
        //资源未找到错误
        public final static int SOURCE_NOT_FOUND_ERROR = 4041;
        //请求（操作）成功
        public final static int SUCCESS = 2000;
    }

}
