package com.sandwich.core.app;

import java.util.Collections;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sandwich.core.app.model.Detail;
import com.sandwich.core.app.model.Ingredient;
import com.sandwich.core.app.model.Product;
import com.sandwich.core.app.repository.DetailsRepository;
import com.sandwich.core.app.repository.IngredientRepository;
import com.sandwich.core.app.repository.ProductRepository;

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
	private ProductRepository localProductRepo;
	
	@Autowired
	private IngredientRepository localIngredientRepo;
	
	@Autowired
	private DetailsRepository localDetailsRepo;
		
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
		return () ->{	

			localIngredientRepo.save(Ingredient.builder().codeIngredient((long) 100).nameIngredient("Lechuga").build());
			localIngredientRepo.save(Ingredient.builder().codeIngredient((long) 101).nameIngredient("Tomate").build());
			localIngredientRepo.save(Ingredient.builder().codeIngredient((long) 102).nameIngredient("Cebolla").build());
			localIngredientRepo.save(Ingredient.builder().codeIngredient((long) 103).nameIngredient("Pollo").build());  
			localIngredientRepo.save(Ingredient.builder().codeIngredient((long) 104).nameIngredient("Salsa Tomate").build());
			localIngredientRepo.save(Ingredient.builder().codeIngredient((long) 105).nameIngredient("Salsa Mayonesa").build());

			localProductRepo.save(Product.builder()
					.productName("Sandiwich Pollo")
					.productDescription("Sandwich Milanesa de Pollo con vegetales")
					.productPrice(8500.0) 
					.productCode((long)10001)
					.productStatus(true)
					.build());
			
			localProductRepo.save(Product.builder() 
					.productName("Sandiwich Carne")
					.productDescription("Sandiwich Carne con vegetales")
					.productPrice(9500.0)
					.productCode((long)10002)
					.productStatus(true)
					.build());
			
			localProductRepo.save(Product.builder()
					.productName("Sandiwich Del Mar")
					.productDescription("Sandwich Frutos del Mar")
					.productPrice(10500.0)
					.productCode((long)10003)
					.productStatus(true)
					.build());	
			
			//Intermedio
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10001)
					.ingredientCode((long)100)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10001)
					.ingredientCode((long)101)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10001)
					.ingredientCode((long)102)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10001)
					.ingredientCode((long)103)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10001)
					.ingredientCode((long)104)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10001)
					.ingredientCode((long)105)
					.build());
			
			
			//intermedio
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10002)
					.ingredientCode((long)100)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10002)
					.ingredientCode((long)101)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10002)
					.ingredientCode((long)102)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10002)
					.ingredientCode((long)103)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10002)
					.ingredientCode((long)104)
					.build());
			
			localDetailsRepo.save(Detail.builder()
					.productCode((long)10002)
					.ingredientCode((long)105)
					.build());
			
						
		};
	}
}
