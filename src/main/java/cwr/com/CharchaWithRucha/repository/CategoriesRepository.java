package cwr.com.CharchaWithRucha.repository;

import cwr.com.CharchaWithRucha.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

    @Query("SELECT c.category_id, cn.description as category_name, cd.description as category_details, c.category_img, " +
           "s.sub_category_id, sn.description as sub_category_name, sd.description as sub_category_details, s.subcategory_img " +
           "FROM Categories c " +
           "JOIN SubCategories s ON c.category_id = s.categoryId.category_id " +
           "JOIN I18n cn ON c.category_name = cn.label_id AND cn.language_id = :languageId " +
           "JOIN I18n cd ON c.category_details = cd.label_id AND cd.language_id = :languageId " +
           "JOIN I18n sn ON s.sub_category_name = sn.label_id AND sn.language_id = :languageId " +
           "JOIN I18n sd ON s.sub_category_details = sd.label_id AND sd.language_id = :languageId")
    List<Object[]> getAllCategoriesWithSubCategoriesAndI18n(@Param("languageId") String languageId);
}
