package com.qunar.training;

import com.qunar.training.entity.GenderEnum;
import com.qunar.training.entity.User;
import com.qunar.training.mapper.UserMapper;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Spring boot入口文件, 上面添加扫描Dubbo的包注解和解析Bean的配置文件
 *
 * @author YISHEN CAI
 */
@ImportResource(value = {
        "classpath:application-context.xml"
})
@DubboComponentScan(basePackages = "com.qunar.training.service")
@SpringBootApplication
@MapperScan(basePackages = "com.qunar.training.mapper", annotationClass = Repository.class)
public class ProviderApplication {

    private static Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(UserMapper userMapper) {
//        List<User> users = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            boolean active = random.nextInt() % 2 == 0;
//            boolean deleted = random.nextInt() % 3 == 0;
//            users.add(new User("https://staff-test.oss-cn-beijing.aliyuncs.com/avatar/avatar.png",
//                    "User" + i,
//                    "Nickname" + i,
//                    GenderEnum.MALE,
//                    new Date(System.currentTimeMillis()),
//                    "Comment" + i,
//                    new Timestamp(System.currentTimeMillis()),
//                    new Timestamp(System.currentTimeMillis()),
//                    active,
//                    deleted));
//        }
//        users.forEach(userMapper::insertUser);
//        userMapper.findAll().forEach(System.out::println);
        return args -> {
            logger.info("Hello, Spring!");
        };
    }
}
