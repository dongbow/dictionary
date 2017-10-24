package cn.ifxcode.project.controller.json;

import cn.ifxcode.project.bean.Result;
import cn.ifxcode.project.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * dict api
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Controller
@RequestMapping("/api/dict")
public class DictionaryApi {

    @Autowired
    private DictionaryService DictionaryService;

    @ResponseBody
    @RequestMapping("/search/?{word}")
    public Result dictionary(@PathVariable(value = "word") String word) {
        if (StringUtils.isBlank(word)) {
            return Result.success(word);
        }
        return Result.success(DictionaryService.search(word));
    }
}
