package cn.ifxcode.project.bean;

import lombok.Data;

/**
 * common return result
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Data
public class Result<T> {
    private String code;
    private boolean success =false;
    private String msg;
    private T data = null;

    public Result() {
    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result();
        r.setData(data);
        r.setSuccess(true);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }

    public static <T> Result<T> fail(String code, String msg) {
        Result<T> r = new Result();
        r.setSuccess(false);
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }
}
