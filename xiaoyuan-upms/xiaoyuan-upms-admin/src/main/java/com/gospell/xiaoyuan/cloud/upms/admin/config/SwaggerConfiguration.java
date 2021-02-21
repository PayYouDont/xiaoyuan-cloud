package com.gospell.xiaoyuan.cloud.upms.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description: SwaggerConfiguration <br>
 * date: 2021/1/20 14:51 <br>
 * author: pay <br>
 * version: 1.0 <br>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket (DocumentationType.SWAGGER_2)
                .apiInfo (apiInfo ())
                .select ()
                .apis (RequestHandlerSelectors.basePackage ("com.gospell.xiaoyuan.cloud.upms.admin"))
                .paths (PathSelectors.any ())
                .build ();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder ()
                .title ("xiaoyuan-cloud APIs")
                .description ("智慧校园授权管理api接口文档")
                .termsOfServiceUrl ("http://localhost:5999/")
                .contact (new Contact ("pay", null, "peiyd@gospell.com"))
                .version ("1.0")
                .build ();
    }

}
