package com.sandwich.core.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandwich.core.app.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	@Query(value = "SELECT I.ID ,I.CODE_INGREDIENT, I.NAME_INGREDIENT  FROM PRODUCTS P LEFT JOIN DETAILS D ON P.PRODUCT_CODE = D.PRODUCT_CODE INNER JOIN INGREDIENTS  I ON D.INGREDIENT_CODE = I.CODE_INGREDIENT WHERE P.PRODUCT_CODE=:productCode", 
			nativeQuery = true)
	List<Ingredient> listIngredientsByProductCode(@Param("productCode") long productCode);
	
	@Query(value = "SELECT I FROM Ingredient I WHERE I.codeIngredient=:ingredientCode")
	Ingredient findByIngredientCode(@Param("ingredientCode") long ingredientCode);
}
