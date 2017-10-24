package cn.ifxcode.project.util;

import cn.ifxcode.project.constants.CommonConstants;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * ip util
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class IPUtil {

    private static final String X_Real_IP = "X-Real-IP";
    private static final String X_FORWARDED_FOR = "X-Forwarded-For";
    private static final String UNKNOWN = "unknown";

    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader(X_Real_IP);
        if (!StringUtils.isBlank(ip) && !UNKNOWN.equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader(X_FORWARDED_FOR);
        if (!StringUtils.isBlank(ip) && !UNKNOWN.equalsIgnoreCase(ip)) {
            int index = ip.indexOf(CommonConstants.COMMA);
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

}
