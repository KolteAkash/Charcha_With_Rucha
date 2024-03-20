package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.SubCategories;
import cwr.com.CharchaWithRucha.model.SubcategoryRequest;
import cwr.com.CharchaWithRucha.service.CategoriesService;
import cwr.com.CharchaWithRucha.service.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
@CrossOrigin
public class SubCategoriesController {
    @Autowired
    private SubCategoriesService subCategoriesService;

    @GetMapping
    public ResponseEntity<List<SubCategories>> getAllSubCategories() {

        return subCategoriesService.getAllSubCategories();
    }


    @PostMapping("/create-subcategories")
    public ResponseEntity<?> createSubCategories(@RequestBody SubcategoryRequest subCategories) {
        return subCategoriesService.createSubCategories(subCategories);
    }
}
