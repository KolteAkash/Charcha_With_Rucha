package cwr.com.CharchaWithRucha.repository;

import cwr.com.CharchaWithRucha.model.I18n;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I18nRepository extends JpaRepository<I18n,Integer> {
}
