package cn.ifxcode.project.util.trace;

import cn.ifxcode.project.util.http.HttpMethod;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * trace log
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
public class TraceUtil {

    public static void log(String uri, String refer, String ip) {
        log.info("request uri: {}, refer: {}, ip: {}", uri, refer, ip);
    }

    public static void log(HttpMethod httpMethod, String uri) {
        log(httpMethod, uri, null);
    }

    public static void log(HttpMethod httpMethod, String uri, Object param) {
        log.info("exec http, method: {}, uri: {}, param: {}", httpMethod.getMethod(), uri, JSON.toJSON(param));
    }

}
