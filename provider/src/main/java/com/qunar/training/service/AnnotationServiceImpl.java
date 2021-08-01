package com.qunar.training.service;

import com.qunar.training.entity.DemoEntity;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService(version = "1.0.0")
public class AnnotationServiceImpl implements AnnotationService {
    @Override
    public DemoEntity hello(String name) {
        return new DemoEntity("Hello " + name);
    }
}
