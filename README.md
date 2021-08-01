# dubbo-project
Dubbo project demo.



这里使用了俩种方式定义Dubbo service.

#### 注解方式:

~~~java
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class AnnotationServiceImpl implements AnnotationService {
    @Override
    public DemoEntity hello(String name) {
        return new DemoEntity("Hello " + name);
    }
}
~~~

~~~java

/**
  * 这一步使用的DubboService注解的方式定义, 需要在启动类上加上包扫描注解, 否则服务启动不会发现注解方式的服务
  */
@DubboComponentScan(basePackages = "com.qunar.training.service")
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
~~~



XML定义方式(类似于Bean定义)

~~~java
import org.springframework.stereotype.Service;

/**
  * 首先定义Bean, 名字默认是CamelCase, 也就是demoSerivceImpl
  */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoEntity sayHello(String name) {
        return new DemoEntity(name);
    }
}
~~~

~~~xml
<!-- 之后在dubbo配置文件中添加引用上一步定义的Bean--> 
<dubbo:service interface="com.qunar.training.service.DemoService"
                 ref="demoServiceImpl"
                 version="1.0"
                 protocol="provider-protocol"
  />
~~~

~~~java
/**
  *	这里记得添加下@ImportResource, 读取xml中配置文件, 解析xml定义的Bean和Dubbo服务
  */
@ImportResource(value = {
        "classpath:applicationContext.xml"
})
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
~~~







