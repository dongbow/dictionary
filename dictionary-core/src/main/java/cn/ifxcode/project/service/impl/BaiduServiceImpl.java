package cn.ifxcode.project.service.impl;

import cn.ifxcode.project.service.TranslateService;
import cn.ifxcode.project.vo.TranslateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * baidu translate servies impl
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
@Service
@PropertySource("classpath:baidu.properties")
public class BaiduServiceImpl implements TranslateService {

    @Override
    public TranslateVO translate(String content) {
        return null;
    }
}
