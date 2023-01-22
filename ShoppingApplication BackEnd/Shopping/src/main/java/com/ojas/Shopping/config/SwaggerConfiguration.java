package com.ojas.Shopping.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/*    public ApiInfo(String title,
                   String description,
                   String version,
                   String termsOfServiceUrl,
                   Contact contact, //String name, String url, String email
                   String licenseName,
                   String licenseUrl
                   Collection vendorExtensions)*/
/*
ApiOperation
ApiParam
ApiModel
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/product/*"))
                .apis(RequestHandlerSelectors.basePackage("com.ojas"))
                .build()
                .apiInfo(apiDetails());

    }

    public ApiInfo apiDetails() {
        return new ApiInfo(
                "ShoppingApplication",
                "This is an application which can be used to add it to you cart and book the product",
                "1.0",
                "free to use",
                new Contact("Vijay Mohan Reddy","https://github.com/PrinceVijayy/ShoppingApplication","kondavijayy123@gmail.com"),
                "Api Licence",
                "Licence Url",
                Collections.emptyList()
        );
    }

}
