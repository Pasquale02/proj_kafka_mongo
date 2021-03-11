package com.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenApiSwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {
		// paths(PathSelectors.ant("/*")): i path esposti sono quelli che cominciano con "/*"
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/*")).build().apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Users API Title", "Description API for example", "1.0", "Free to use", new springfox.documentation.service.Contact("Pasquale Florio", "http://https://swagger.io/docs/", "aa@bb.com"), "API license", "sito web", Collections.emptyList());
	}

}