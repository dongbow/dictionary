package cn.ifxcode.project.exception;

import lombok.Getter;

/**
 * service exception
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class ServiceException extends RuntimeException {

    @Getter
    private String code;

    public ServiceException(String code, String msg, Exception e) {
        super(msg, e);
        this.code = code;
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
