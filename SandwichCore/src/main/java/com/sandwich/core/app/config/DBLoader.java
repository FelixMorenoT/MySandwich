package com.sandwich.core.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sandwich.core.app.model.Carrier;
import com.sandwich.core.app.model.Client;
import com.sandwich.core.app.model.Detail;
import com.sandwich.core.app.model.Ingredient;
import com.sandwich.core.app.model.PaymentMethod;
import com.sandwich.core.app.model.Product;
import com.sandwich.core.app.repository.CarrierRepository;
import com.sandwich.core.app.repository.ClientRepository;
import com.sandwich.core.app.repository.DetailsRepository;
import com.sandwich.core.app.repository.IngredientRepository;
import com.sandwich.core.app.repository.PaymentMethodRepository;
import com.sandwich.core.app.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DBLoader {

	@Autowired
	private ProductRepository localProductRepo;
	
	@Autowired
	private CarrierRepository localCarrierRepo;
	
	@Autowired
	private PaymentMethodRepository localPaymentMethodRepo;
	
	@Autowired
	private IngredientRepository localIngredientRepo;
	
	@Autowired
	private DetailsRepository localDetailsRepo;
	
	@Autowired
	private ClientRepository localClienteRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public void loader() {
		log.info("RELOAD");
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
				.productDis(10)
				.productStatus(true)
				.productImg("https://static7.depositphotos.com/1004373/776/i/950/depositphotos_7760758-stock-photo-sandwich-with-bacon-and-vegetables.jpg")
				.build()); 
		
		localProductRepo.save(Product.builder() 
				.productName("Sandiwich Carne")
				.productDescription("Sandiwich Carne con vegetales")
				.productPrice(9500.0)
				.productCode((long)10002)
				.productDis(10)
				.productStatus(true)
				.productImg("https://static7.depositphotos.com/1004373/776/i/950/depositphotos_7760758-stock-photo-sandwich-with-bacon-and-vegetables.jpg")
				.build());
		
		localProductRepo.save(Product.builder()
				.productName("Sandiwich Del Mar")
				.productDescription("Sandwich Frutos del Mar")
				.productPrice(10500.0)
				.productCode((long)10003)
				.productDis(10)
				.productStatus(true)
				.productImg("https://static7.depositphotos.com/1004373/776/i/950/depositphotos_7760758-stock-photo-sandwich-with-bacon-and-vegetables.jpg")
				.build());	
		
		localCarrierRepo.save(Carrier.builder()
				.idCarrier((long) 1000)
				.carrierName("Carrier 1")
				.carrierNit("11111")
				.carrierPhoneNumber("314400500")
				.build());
		
		localCarrierRepo.save(Carrier.builder()
				.idCarrier((long) 2000)
				.carrierName("Carrier 2")
				.carrierNit("22222")
				.carrierPhoneNumber("314400500")
				.build());
		
		localCarrierRepo.save(Carrier.builder()
				.idCarrier((long) 3000)
				.carrierName("Carrier 3")
				.carrierNit("333333")
				.carrierPhoneNumber("314400500")
				.build());
		
		localPaymentMethodRepo.save(PaymentMethod.builder()
				.idPaymentMethod((long) 1000)
				.name("Payment Method 1")
				.build());
		
		localPaymentMethodRepo.save(PaymentMethod.builder()
				.idPaymentMethod((long) 2000)
				.name("Payment Method 2")
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

		//Inclusion Cliente
		localClienteRepo.save(Client.builder()
				.clientAddress("Calle 99 #15-20")
				.clientFullName("Susano Patricio Rodriguez")
				.clientMail("dev@sandwich.com")
				.clientStatus(true)
				.rol("ADMIN")
				.clientUserName("dev")
				.clientPassword(passwordEncoder.encode("dev"))
				.clientPhoneNumber("3192504099")
				.build());
	}
}
