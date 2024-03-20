package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.Language;
import cwr.com.CharchaWithRucha.model.Language_details;
import cwr.com.CharchaWithRucha.repository.LanguageRepository;
import cwr.com.CharchaWithRucha.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public ResponseEntity<?> createLanguage(Language_details languageDetails) {
        try {
            Language language = new Language();
            language.setLanguage_id(languageDetails.getLanguage_id());
            language.setLanguage(languageDetails.getLanguage());

            Language createdLanguage = languageRepository.save(language);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLanguage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }
}
