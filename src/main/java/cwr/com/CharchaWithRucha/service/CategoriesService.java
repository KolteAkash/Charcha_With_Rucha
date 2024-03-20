package cwr.com.CharchaWithRucha.service;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.CategorieyResponse;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriesService {
    ResponseEntity<List<?>> getAllCategories();
    ResponseEntity<Categories> createCategories(Categories category);
	ResponseEntity<List<CategorieyResponse>> getAllCategoriesi18n(String languageId);
}
