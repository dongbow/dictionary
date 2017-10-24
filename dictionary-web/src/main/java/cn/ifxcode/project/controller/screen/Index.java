package cn.ifxcode.project.controller.screen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Controller
public class Index {

    @RequestMapping("/index")
    public String toIndex() {
        return "/index";
    }
}
