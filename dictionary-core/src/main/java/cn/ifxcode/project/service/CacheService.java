package cn.ifxcode.project.service;

import cn.ifxcode.project.vo.DictionaryVO;
import com.alibaba.fastjson.JSONObject;

/**
 * redis service
 *
 * @author dongbo
 * @date 2017/10/20
 */
public interface CacheService {

    void save(DictionaryVO dictionaryVO);

    JSONObject get(String word);

}
