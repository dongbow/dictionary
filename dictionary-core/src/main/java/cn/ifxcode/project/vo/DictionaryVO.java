package cn.ifxcode.project.vo;

import cn.ifxcode.project.dto.ShanbeiDTO;
import lombok.Data;

/**
 * Created by wangdongbo on 2017/10/19.
 */
@Data
public class DictionaryVO {

    public static DictionaryVO convert(ShanbeiDTO shanbeiDTO) {
        return new DictionaryVO();
    }
}
