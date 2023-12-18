package org.dromara.common.core.core.domain;

import org.dromara.common.core.constant.HttpStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author Lion Li
 */
@Data
@NoArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;

    /**
     * 失败
     */
    public static final int FAIL = 500;

    /*
     * 消息状态码
     */
    private int code;

    /*
     * 消息内容
     */
    private String msg;

    /*
     * 数据对象
     */
    private T data;

    public static <T> R<T> ok() {
        return restResult(SUCCESS, "操作成功", null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(SUCCESS, "操作成功", data);
    }

    public static <T> R<T> ok(String msg) {
        return restResult(SUCCESS, msg, null);
    }

    public static <T> R<T> ok(String msg, T data) {
        return restResult(SUCCESS, msg, data);
    }

    public static <T> R<T> fail() {
        return restResult(FAIL, "操作失败", null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(FAIL, msg, null);
    }

    public static <T> R<T> fail(T data) {
        return restResult(FAIL, "操作失败", data);
    }

    public static <T> R<T> fail(String msg, T data) {
        return restResult(FAIL, msg, data);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(code, msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> R<T> warn(String msg) {
        return restResult(HttpStatus.WARN, msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> R<T> warn(String msg, T data) {
        return restResult(HttpStatus.WARN, msg, data);
    }

    private static <T> R<T> restResult(int code, String msg, T data) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> Boolean isError(R<T> ret) {
        return !isSuccess(ret);
    }

    public static <T> Boolean isSuccess(R<T> ret) {
        return R.SUCCESS == ret.getCode();
    }
}
