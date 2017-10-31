package cn.ifxcode.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring boot
 *
 * @author dongbo
 * @date 2017/10/20
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.ifxcode.project"})
public class DictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }
}
