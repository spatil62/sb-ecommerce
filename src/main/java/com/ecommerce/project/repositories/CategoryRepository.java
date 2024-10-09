package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

//If we keep cursor on JPA repository we can able to see what inside implemenetation it provides
//features
//without implementation we have access to so many methods we can see it in a CategoryServiceImpl
//This is not created by us it just we clicked categoryserviceimpl file and its auto generated
//findby indicate this is query method and spring data jpa should find it by certain criteria



public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);
}
