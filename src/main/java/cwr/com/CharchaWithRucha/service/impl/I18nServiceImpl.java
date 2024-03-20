package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.I18n;
import cwr.com.CharchaWithRucha.repository.I18nRepository;
import cwr.com.CharchaWithRucha.repository.VideoRepository;
import cwr.com.CharchaWithRucha.service.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class I18nServiceImpl implements I18nService {
    private final I18nRepository i18nRepository;
    private final VideoRepository videoRepository;

    @Autowired
    public I18nServiceImpl(I18nRepository i18nRepository, VideoRepository videoRepository) {
        this.i18nRepository = i18nRepository;
        this.videoRepository = videoRepository;
    }
    @Override
    public ResponseEntity<I18n> addI18n(I18n i18n) {
        try {
            I18n savedI18n = i18nRepository.save(i18n);
            return new ResponseEntity<>(savedI18n, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(i18n);
        }
    }

}

