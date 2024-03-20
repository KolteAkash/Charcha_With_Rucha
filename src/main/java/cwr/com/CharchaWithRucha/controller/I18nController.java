package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.I18n;
import cwr.com.CharchaWithRucha.service.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/i18n")
public class I18nController {
    @Autowired
    private I18nService i18nservice;
    @PostMapping("/i18n")
    public ResponseEntity<I18n> addI18n(@RequestBody I18n i18n) {
        return i18nservice.addI18n(i18n);
    }

}
