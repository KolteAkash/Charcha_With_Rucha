package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.SubCategories;
import cwr.com.CharchaWithRucha.model.SubcategoryRequest;
import cwr.com.CharchaWithRucha.model.VideoRequest;
import cwr.com.CharchaWithRucha.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<?>> getAllVideos() {
        System.out.println("a");
        return videoService.getAllVideos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVideoById(@PathVariable Integer id) {
        return videoService.getVideoById(id);
    }

    @PostMapping("/add-new-video")
    public ResponseEntity<?> addNewVideo(@RequestBody VideoRequest videoRequest) {
        return videoService.addNewVideo(videoRequest);
    }
    @GetMapping("/{id}/localized/{languageId}")
    public ResponseEntity<?> getVideoByIdAndLanguageId(@PathVariable Integer id, @PathVariable String languageId) {
        return videoService.getVideoByIdAndLanguageId(id, languageId);
    }
    @GetMapping("/localized/{languageId}")
    public ResponseEntity<List<Map<String, Object>>> getAllVideosWithLocalizedData(@PathVariable(required = false) String languageId) {

        if (languageId == null || languageId.isEmpty()) {
            languageId = "en"; // Default language is English (en)
        }

        ResponseEntity<List<Map<String, Object>>> localizedDataResponse = videoService.getAllVideosWithLocalizedData(languageId);

        if (localizedDataResponse.getStatusCode().equals(HttpStatus.OK)) {
            List<Map<String, Object>> localizedData = localizedDataResponse.getBody();
            return ResponseEntity.ok(localizedData);
        } else {
            return ResponseEntity.status(localizedDataResponse.getStatusCode()).body(localizedDataResponse.getBody());
        }
    }
}
