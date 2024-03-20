package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.CategorieyResponse;
import cwr.com.CharchaWithRucha.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<?>> getAllCategories() {

        return categoriesService.getAllCategories();
    }


    @PostMapping("/create-categories")
    public ResponseEntity<Categories> createCategories(@RequestBody Categories category) {
        return categoriesService.createCategories(category);
    }

@GetMapping("/{languageId}")
public ResponseEntity<List<CategorieyResponse>> getAllCategoriesi18n(@PathVariable String languageId) {
    return categoriesService.getAllCategoriesi18n(languageId);
}
}