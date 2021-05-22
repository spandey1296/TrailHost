package com.trail.musicalhost.config;

import org.springframework.context.annotation.Configuration;
        import springfox.documentation.builders.RequestHandlerSelectors;
        import springfox.documentation.service.ApiInfo;
        import springfox.documentation.spi.DocumentationType;
        import springfox.documentation.spring.web.plugins.Docket;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;
        import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class MusicConfig {

    public Docket authorAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trail.musicalhost.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    };

    private ApiInfo metaData() {
        ApiInfo info = new ApiInfo(
                "MUSIC HOST APPICATION",
                "API for hosting music application ",
                "1.0.0",
                "https://musichost.com/terms",
                "Group-7 Dynamic Developer",
                "Licensed Under Github Education",
                "https://musichost.com"
        );
        return info;
    }
}