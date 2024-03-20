package cwr.com.CharchaWithRucha.service;

import cwr.com.CharchaWithRucha.model.TopVideoRequest;
import cwr.com.CharchaWithRucha.model.VideoRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TopVideoService {
    ResponseEntity<List<?>> getTopPriorityVideo();
    ResponseEntity<?> addVideoPriority(TopVideoRequest topVideoRequest);
    ResponseEntity<List<Map<String, Object>>> getTopVideosWithLocalizedData(String languageId);
}
