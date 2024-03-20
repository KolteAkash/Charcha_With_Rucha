package cwr.com.CharchaWithRucha.service;

import cwr.com.CharchaWithRucha.model.SubCategories;
import cwr.com.CharchaWithRucha.model.SubcategoryRequest;
import cwr.com.CharchaWithRucha.model.VideoRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface VideoService {
    ResponseEntity<List<?>> getAllVideos();
    ResponseEntity<?> getVideoById(Integer id);
    ResponseEntity<?> addNewVideo(VideoRequest videoRequest);
    ResponseEntity<List<Map<String, Object>>> getAllVideosWithLocalizedData(String languageId);
	ResponseEntity<?> getVideoByIdAndLanguageId(Integer id, String languageId);
}
