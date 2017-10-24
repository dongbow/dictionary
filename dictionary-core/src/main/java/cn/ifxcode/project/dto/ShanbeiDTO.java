package cn.ifxcode.project.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * shanbei return object
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Data
public class ShanbeiDTO {

    public static ShanbeiDTO fromJSON(String json) {
        return JSON.toJavaObject(JSON.parseObject(json), ShanbeiDTO.class);
    }
}
