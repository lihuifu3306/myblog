package com.crazy.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-19 15:25
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crazy.article"))//扫描com路径下的api文档
                .paths(PathSelectors.any())//路径判断
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("myblog")//标题
                .description("myblog开发文档")
//                .termsOfServiceUrl("http://baidu.com")//（不可见）条款地址
                .version("1.0.0")//版本号
                .build();
    }
}