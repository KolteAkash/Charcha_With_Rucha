package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.SubCategories;
import cwr.com.CharchaWithRucha.model.SubcategoryRequest;
import cwr.com.CharchaWithRucha.repository.CategoriesRepository;
import cwr.com.CharchaWithRucha.repository.SubCategoriesRepository;
import cwr.com.CharchaWithRucha.service.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubCategoriesImpl implements SubCategoriesService {

    @Autowired
    private SubCategoriesRepository subCategoriesRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public ResponseEntity<List<SubCategories>> getAllSubCategories(){
        List<SubCategories> subCategories = subCategoriesRepository.findAll();
        return new ResponseEntity<>(subCategories, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> createSubCategories(SubcategoryRequest subCategories){
        try {
            Categories categories=categoriesRepository.findById(subCategories.getCategory_id()).orElseThrow(()->new NoSuchElementException("No cate gory Found"));
            SubCategories sub=new SubCategories();
            sub.setSub_category_name(subCategories.getSub_category_name());
            sub.setSub_category_details(subCategories.getSub_category_details());
            sub.setCategoryId(categories);
            SubCategories savedSub=subCategoriesRepository.save(sub);
            return new ResponseEntity<>(savedSub, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(subCategories);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
