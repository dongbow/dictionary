package cn.ifxcode.project.service.impl;

import cn.ifxcode.project.service.CacheService;
import cn.ifxcode.project.vo.DictionaryVO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * redis servies impl
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
@Service
@PropertySource("classpath:redis.properties")
public class CacheServiceImpl implements CacheService {

    @Override
    public void save(DictionaryVO dictionaryVO) {

    }

    @Override
    public JSONObject get(String word) {
        return null;
    }
}
