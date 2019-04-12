package com.ytq.test.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * yuantongqin
 * 2019/3/25
 */
@Configuration
public class FileUploadConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory configFactory = new MultipartConfigFactory();
        // 单个文件最大
        configFactory.setMaxFileSize(10*1024*1024);
        // 设置总上传数据总大小
        configFactory.setMaxRequestSize(40*1024*1024);
       return configFactory.createMultipartConfig();
    }
}
