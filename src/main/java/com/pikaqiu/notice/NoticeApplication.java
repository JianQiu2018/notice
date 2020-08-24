package com.pikaqiu.notice;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@Import(SpringCloudSecondaryConfiguration.class)
@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})// 使用文件存储时, 不需要配置mongodb,编译红线提示不影响运行
public class NoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }

}
