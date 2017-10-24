package cn.ifxcode.project.service.impl;

import cn.ifxcode.project.service.DictionaryService;
import cn.ifxcode.project.vo.DictionaryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * youdao service impl
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
@Service
@PropertySource("classpath:youdao.properties")
public class YoudaoServiceImpl implements DictionaryService {

    @Override
    public DictionaryVO search(String word) {
        return null;
    }
}
