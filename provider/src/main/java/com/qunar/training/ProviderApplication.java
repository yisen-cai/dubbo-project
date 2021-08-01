package com.qunar.training;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * Spring boot入口文件, 上面添加扫描Dubbo的包注解和解析Bean的配置文件
 *
 * @author YISHEN CAI
 */
@ImportResource(value = {
        "classpath:applicationContext.xml"
})
@DubboComponentScan(basePackages = "com.qunar.training.service")
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
