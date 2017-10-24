package cn.ifxcode.project.constants.enumtype;

import com.google.common.base.Objects;
import lombok.Getter;

/**
 * Baidu http status code
 *
 * @author dongbo
 * @date 2017/10/20
 */
public enum BaiduEnum {
    SUCCESS(52000, "成功"),
    TIMEOUT(52001, "请求超时"),
    SYSTEM_ERROR(52002, "系统错误"),
    NOT_AUTH(52003, "未授权"),
    PARAM_ERROR(54000, "参数错误"),
    SIGN_ERROR(54001, "签名错误"),
    FREQUENCY_LIMITATION(54003, "访问频率受限"),
    NOT_SUFFICIENT_FUNDS(54004, "账户余额不足"),
    REQUEST_FREQUENTLY(54005, "请求频繁，3s后重试"),
    IP_ILLEGAL(58000, "非法IP"),
    LANG_NOT_SUPPORT(58001, "语言不支持");

    @Getter
    private Integer code;
    @Getter
    private String desc;

    BaiduEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescMapping(Integer code) {
        for (BaiduEnum baiduEnum : BaiduEnum.values()) {
            if (Objects.equal(code, baiduEnum.getCode())) {
                return baiduEnum.getDesc();
            }
        }
        throw new IllegalArgumentException("illegal code");
    }
}
