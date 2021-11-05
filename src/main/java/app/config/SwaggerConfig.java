package app.config;

import java.util.Collections;

import com.fasterxml.jackson.core.util.VersionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${artifact.version}")
    private String artifactVersion;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("app.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "SpringBoot Challenge, task manager Coopeuch",
                "Task manager with Crud functionality",
                artifactVersion,
                "https://github.com/Sevalas/spring-challenge",
                new Contact("Sevalas", "https://github.com/Sevalas", "se.valas@outlook.com"),
                "README",
                "https://github.com/Sevalas/spring-challenge/blob/master/README.md",
                Collections.emptyList()
        );
    }

}