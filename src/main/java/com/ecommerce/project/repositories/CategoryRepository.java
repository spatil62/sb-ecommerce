package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//If we keep cursor on JPA repository we can able to see what inside implemenetation it provides
//features
//without implementation we have access to so many methods we can see it in a CategoryServiceImpl
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
