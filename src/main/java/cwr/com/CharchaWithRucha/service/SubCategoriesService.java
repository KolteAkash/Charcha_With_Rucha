package cwr.com.CharchaWithRucha.service;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.SubCategories;
import cwr.com.CharchaWithRucha.model.SubcategoryRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubCategoriesService {
    ResponseEntity<List<SubCategories>> getAllSubCategories();
    ResponseEntity<?> createSubCategories(SubcategoryRequest subCategories);
}
