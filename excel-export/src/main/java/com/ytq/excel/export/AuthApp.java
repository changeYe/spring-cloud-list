package com.ytq.excel.export;

import com.kunchi.ic.m4c.ffc.api.SaleOutExecuteForFFCApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
@SpringBootApplication
//@EnableFeignClients
public class AuthApp implements CommandLineRunner {

    @Autowired
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AuthApp.class, args);
       }

//       @Autowired
//       private RestTemplate restTemplate;
    @Override
    public void run(String... args) throws Exception {
//        restTemplate.getMessageConverters().add(new MyMappingJackson2HttpMessageConverter());
        System.out.println("aa");
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MyMappingJackson2HttpMessageConverter());
        return restTemplate;
    }
//
    @Bean
    public SaleOutExecuteForFFCApi saleOutExecuteForFFCApi(){
        return new SaleOutExecuteForFFCApi();
    }
}
