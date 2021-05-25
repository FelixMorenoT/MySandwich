package com.sandwich.core.app;

import java.util.Collections;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sandwich.core.app.config.DBLoader;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SandwichCoreApplication {


	@Autowired
	private DBLoader devloader;
		
	public static void main(String[] args) {
		SpringApplication.run(SandwichCoreApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(usersApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sandwich.core.app"))
				.build();
	}
	
	private ApiInfo usersApiInfo() {
	        return new ApiInfo("Sandwich Core API", "Api to Handle SANDWICH CORE", "1.0", "", 
	        		new Contact("Felix Moreno, Miguel Rivera, David Acuña, Sebastian Camacho", "", ""), 
	        		"", 
	        		"", 
	        		Collections.emptyList());
	}
	
	@Bean
	InitializingBean saveH2Data() {
		return () ->
		
			devloader.loader()		
		;
	}
}
