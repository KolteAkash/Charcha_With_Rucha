package cwr.com.CharchaWithRucha.service;

import cwr.com.CharchaWithRucha.model.Language;
import cwr.com.CharchaWithRucha.model.Language_details;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LanguageService {
    ResponseEntity<?> createLanguage(Language_details languageDetails);
    List<Language> getLanguages();
}
