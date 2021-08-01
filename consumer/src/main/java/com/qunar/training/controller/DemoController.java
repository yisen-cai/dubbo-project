package com.qunar.training.controller;

import com.qunar.training.entity.DemoEntity;
import com.qunar.training.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @DubboReference(check = false)
    private DemoService demoService;

    @GetMapping("/demo/{name}")
    public DemoEntity createDemo(@PathVariable String name) {
        return demoService.sayHello(name);
    }

}
