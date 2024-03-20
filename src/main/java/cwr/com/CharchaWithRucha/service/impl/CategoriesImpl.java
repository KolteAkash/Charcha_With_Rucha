package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.SubCategories;
import cwr.com.CharchaWithRucha.model.CategorieyResponse;
import cwr.com.CharchaWithRucha.model.SubCategoryDetail;
import cwr.com.CharchaWithRucha.repository.CategoriesRepository;
import cwr.com.CharchaWithRucha.repository.SubCategoriesRepository;
import cwr.com.CharchaWithRucha.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private SubCategoriesRepository subCategoriesRepository;

    
    @Override
    public ResponseEntity<List<CategorieyResponse>> getAllCategoriesi18n(String languageId) {
        List<Object[]> categoriesWithSubCategoriesAndI18n = categoriesRepository.getAllCategoriesWithSubCategoriesAndI18n(languageId);

        List<CategorieyResponse> responseList = new ArrayList<>();
        for (Object[] row : categoriesWithSubCategoriesAndI18n) {
            CategorieyResponse categoryResponse = new CategorieyResponse();

            categoryResponse.setCategory_id((int) row[0]);
            categoryResponse.setCategory_name((String) row[1]);
            categoryResponse.setCategory_details((String) row[2]);
            categoryResponse.setCategory_img((String) row[3]);

            SubCategoryDetail subCategoryDetail = new SubCategoryDetail();
            subCategoryDetail.setSub_category_id((int) row[4]);
            subCategoryDetail.setSub_category_name((String) row[5]);
            subCategoryDetail.setSub_category_details((String) row[6]);
            subCategoryDetail.setSub_category_img((String) row[7]);

            List<SubCategoryDetail> subCategories = new ArrayList<>();
            subCategories.add(subCategoryDetail);
            categoryResponse.setSubCategories(subCategories);

            responseList.add(categoryResponse);
        }

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    
    
    
    @Override
    public ResponseEntity<List<?>> getAllCategories(){
        List<SubCategories> subCategories = subCategoriesRepository.findAll();
        List<Categories> categories = categoriesRepository.findAll();
        List<CategorieyResponse> responseList = new ArrayList<>();
        for (Categories category : categories) {
            CategorieyResponse eachCategoryResponse=new CategorieyResponse();

            List<SubCategoryDetail> subCategoryDetailsForMultiple=new ArrayList<>();
            for(SubCategories subCategories1: subCategories){
                if(category.getCategory_id()==subCategories1.getCategoryId().getCategory_id()){
                    eachCategoryResponse.setCategory_id(subCategories1.getCategoryId().getCategory_id());
                    eachCategoryResponse.setCategory_name(subCategories1.getCategoryId().getCategory_name());
                    eachCategoryResponse.setCategory_details(subCategories1.getCategoryId().getCategory_details());
                    eachCategoryResponse.setCategory_img(subCategories1.getCategoryId().getCategory_img());
                    SubCategoryDetail subCategoryDetail=new SubCategoryDetail();
                    subCategoryDetail.setSub_category_id(subCategories1.getSub_category_id());
                    subCategoryDetail.setSub_category_name(subCategories1.getSub_category_name());
                    subCategoryDetail.setSub_category_details(subCategories1.getSub_category_details());
                    subCategoryDetail.setSub_category_img(subCategories1.getSubcategory_img());
                    subCategoryDetailsForMultiple.add(subCategoryDetail);
                    eachCategoryResponse.setSubCategories(subCategoryDetailsForMultiple);

                }
            }
            responseList.add(eachCategoryResponse);

            System.out.println(responseList);

        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Categories> createCategories(Categories category){
        try {
            Categories createdCategory = categoriesRepository.save(category);
            return new ResponseEntity<>(createdCategory, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(category);
        }
    }

}
