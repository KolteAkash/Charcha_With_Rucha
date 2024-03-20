package cwr.com.CharchaWithRucha.repository;

import cwr.com.CharchaWithRucha.model.SubCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoriesRepository extends JpaRepository<SubCategories, Integer> {
	
}
