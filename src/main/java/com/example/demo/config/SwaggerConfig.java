package com.example.demo.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(excludeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {InMemorySwaggerResourcesProvider.class})})
public class SwaggerConfig {
    @Value("${swagger.host:N}")
    private String swaggerHost;

    @Value("${swagger.debug:N}")
    private String swaggerDebug;

    @Value("${swagger.enable:true}")
    private Boolean enabled;

    public static final String AUTHORIZATION = "Authorization";

    @Bean
    public Docket createRestApi() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add((new ResponseMessageBuilder()).code(200000).message("").build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        if (StringUtils.isNotBlank(this.swaggerHost) && !"N".equals(this.swaggerHost) &&
                "N".equals(this.swaggerDebug))
            docket = docket.host(this.swaggerHost);
        return docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList).enable(this.enabled.booleanValue());
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder())
                .title("ANSON")
                .description("微服务API文档")
                .version("0.0.1")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        ApiKey apiKey = new ApiKey("Authorization", "token", "header");
        return Collections.singletonList(apiKey);
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^.*$"))
                .build());
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }
}
