package cwr.com.CharchaWithRucha.service;

import cwr.com.CharchaWithRucha.model.I18n;
import org.springframework.http.ResponseEntity;

public interface I18nService {
    ResponseEntity<I18n> addI18n(I18n i18n);
}
