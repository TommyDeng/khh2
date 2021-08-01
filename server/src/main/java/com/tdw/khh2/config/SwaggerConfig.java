package com.tdw.khh2.config;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Log
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DefaultContact = new Contact(
            "Tommy Deng", "https://www.dengqingjun.com", "250575979@qq.com");

    public static final ApiInfo DefaultApiInfo = new ApiInfo(
            "API Title", "API Description", "1.0",
            "#", DefaultContact,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.EMPTY_LIST);

    private static final Set<String> DefaultProducesAndConsumes =
            new HashSet<String>(Arrays.asList("application/json",
                    "application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DefaultApiInfo)
                .enable(true)
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .produces(DefaultProducesAndConsumes)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tdw.khh2"))
                .paths(PathSelectors.any())
                .build();
    }

    // swagger 加入head:Authorization的传值
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        return Arrays.asList(new SecurityReference("JWT",
                new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")}));
    }
}
