package cn.ifxcode.project.controller.json;

import cn.ifxcode.project.bean.Result;
import cn.ifxcode.project.service.TranslateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * trans api
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Controller
@RequestMapping("/api/trans")
public class TranslateApi {

    @Autowired
    private TranslateService translateService;

    @ResponseBody
    @RequestMapping("/translate")
    public Result translate(String content) {
        if (StringUtils.isBlank(content)) {
            return Result.success(content);
        }
        return Result.success(translateService.translate(content));
    }
}
