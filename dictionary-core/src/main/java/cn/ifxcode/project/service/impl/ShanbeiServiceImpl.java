package cn.ifxcode.project.service.impl;

import cn.ifxcode.project.dto.ShanbeiDTO;
import cn.ifxcode.project.service.CacheService;
import cn.ifxcode.project.service.DictionaryService;
import cn.ifxcode.project.util.http.HttpUtil;
import cn.ifxcode.project.vo.DictionaryVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.MessageFormat;

/**
 * shanbei service impl
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
@Service
@PropertySource("classpath:shanbei.properties")
public class ShanbeiServiceImpl implements DictionaryService {

    @Value("${shanbei.url}")
    private String shanbeiUrl;
    @Autowired
    private CacheService cacheService;

    @Override
    public DictionaryVO search(String word) {
        DictionaryVO dictionaryVO = null;
        JSONObject jsonObject = cacheService.get(word);
        if (jsonObject != null) {
            return JSON.toJavaObject(jsonObject, DictionaryVO.class);
        }
        try {
            String result = HttpUtil.GET.doGet(MessageFormat.format(shanbeiUrl, word));
            Assert.notNull(result, "查询失败");
            ShanbeiDTO shanbeiDTO = ShanbeiDTO.fromJSON(result);
            dictionaryVO = DictionaryVO.convert(shanbeiDTO);
        } catch (Exception e) {
            log.error("from shanbei get word failed, word: {}", word, e);
        }
        return dictionaryVO;
    }
}
