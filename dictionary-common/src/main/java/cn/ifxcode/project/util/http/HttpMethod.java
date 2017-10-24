package cn.ifxcode.project.util.http;

import lombok.Getter;

/**
 * Http method
 *
 * @author dongbo
 * @date 2017/10/20
 */
public enum HttpMethod {
    GET("get"), POST("post");

    @Getter
    private String method;

    HttpMethod(String method) {
        this.method = method;
    }
}
