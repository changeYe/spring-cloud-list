package com.ytq.security.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yuantongqin
 * description:
 * 2020/3/30
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ytq.security.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

        // securitySchemes 配置全局参数规则
        // securityContexts 通过正则表达式匹配符合条件api，需要全局参数或不需要这些参数
        // 在swagger 页面可以添加参数进行访问
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("security api")
                .description("所有的api")
                .contact(new Contact("ytq","","133599"))
                .version("1.0").build();
    }

    protected List<ApiKey> securitySchemes(){
        // 添加全局参数
        List<ApiKey> apiKeys = Lists.newArrayList();
        apiKeys.add(new ApiKey("Authorization","Authorization","header"));
        return apiKeys;
    }

    protected List<SecurityContext> securityContexts(){
        //设置需要登录认证的路径
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(getContextByPath("/brand/.*"));
        securityContexts.add(getContextByPath("/product/.*"));
        securityContexts.add(getContextByPath("/productCategory/.*"));
        return securityContexts;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    protected List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        return Lists.newArrayList(new SecurityReference("Authorization",
                                                        new AuthorizationScope[]{authorizationScope}));
    }

}
