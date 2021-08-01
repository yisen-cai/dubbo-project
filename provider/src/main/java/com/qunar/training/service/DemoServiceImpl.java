package com.qunar.training.service;

import com.qunar.training.entity.DemoEntity;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 *
 * @author YISHEN CAI
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoEntity sayHello(String name) {
        return new DemoEntity(name);
    }
}
