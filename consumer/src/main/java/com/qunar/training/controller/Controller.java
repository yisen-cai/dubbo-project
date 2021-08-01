package com.qunar.training.controller;

import com.qunar.training.entity.DemoEntity;
import com.qunar.training.service.AnnotationService;
import com.qunar.training.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /**
     * 这个地方版本号要严格和Provider中一致
     */
    @DubboReference(version = "1.0")
    private DemoService demoService;

    @DubboReference(version = "1.0.0")
    private AnnotationService annotationService;

    @GetMapping("/demo/{name}")
    public DemoEntity createDemo(@PathVariable String name) {
        return demoService.sayHello(name);
    }


    @GetMapping("/annotation/{name}")
    public DemoEntity helloAnnotation(@PathVariable String name) {
        return annotationService.hello(name);
    }
}
