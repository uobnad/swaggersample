package com.swagger.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("microservice").select().paths(paths()).build()
				.apiInfo(apiInfo());
	}

	private Predicate<String> paths() {

		// 仕様書生成対象のURLパスを指定する
		return Predicates.or(Predicates.containsPattern("/*"));
	}

	private ApiInfo apiInfo() {
		
		ApiInfo apiInfo = new ApiInfo(
				"HogeHoge System Web API", // title
				"HogeHoge System の Web API 仕様書", // description
				"0.0.1", // version
				"", // terms of service url
				new Contact("name", "", ""), // created by
				"HogeHoge Co. Ltd", // license
				"",
				new ArrayList<VendorExtension>()); // license url
		return apiInfo;
	}

}
