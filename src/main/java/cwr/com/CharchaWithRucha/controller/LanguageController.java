package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.Language;
import cwr.com.CharchaWithRucha.model.Language_details;
import cwr.com.CharchaWithRucha.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @PostMapping("/create-language")
    public ResponseEntity<?> createLanguage(@RequestBody Language_details languageDetails) {
        try {
            ResponseEntity<?> response = languageService.createLanguage(languageDetails);
            return response;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-languages")
    public ResponseEntity<List<Language>> getLanguages() {
        try {
            List<Language> languages = languageService.getLanguages();
            return ResponseEntity.ok(languages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
