package com.cmdi.sottle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("任务调度接口").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.cmdi.sottle.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Quartz 任务调度框架")
                .description("任务调度模块接口")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0")
                .build();
    }

}

