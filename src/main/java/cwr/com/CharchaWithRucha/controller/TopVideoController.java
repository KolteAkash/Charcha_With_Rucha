package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.TopVideoRequest;
import cwr.com.CharchaWithRucha.model.VideoRequest;
import cwr.com.CharchaWithRucha.service.TopVideoService;
import cwr.com.CharchaWithRucha.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/top-videos")
public class TopVideoController {
    @Autowired
    private TopVideoService topVideoService;

    @GetMapping
    public ResponseEntity<List<?>> getTopPriorityVideo() {
        return topVideoService.getTopPriorityVideo();
    }


    @PostMapping("/add-priority")
    public ResponseEntity<?> addVideoPriority(@RequestBody TopVideoRequest topVideoRequest) {
        return topVideoService.addVideoPriority(topVideoRequest);
    }
    @GetMapping("/{languageId}")
    public ResponseEntity<List<Map<String, Object>>> getTopVideosWithLocalizedData(@PathVariable String languageId) {
        ResponseEntity<List<Map<String, Object>>> localizedDataResponse = topVideoService.getTopVideosWithLocalizedData(languageId);

        if (localizedDataResponse.getStatusCode().is2xxSuccessful()) {
            List<Map<String, Object>> localizedData = localizedDataResponse.getBody();
            return ResponseEntity.ok(localizedData);
        } else {
            return ResponseEntity.status(localizedDataResponse.getStatusCode()).body(localizedDataResponse.getBody());
        }
    }
}

