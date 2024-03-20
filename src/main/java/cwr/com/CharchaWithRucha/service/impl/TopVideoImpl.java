package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.*;
import cwr.com.CharchaWithRucha.repository.TopVideoRepository;
import cwr.com.CharchaWithRucha.repository.VideoRepository;
import cwr.com.CharchaWithRucha.service.TopVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopVideoImpl implements TopVideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private TopVideoRepository topVideoRepository;

    @Override
    public ResponseEntity<List<?>> getTopPriorityVideo(){
        List<Top_video> videos=topVideoRepository.findAll();
        videos.sort(Comparator.comparingInt(Top_video::getPriority));
        List<Video> videos1= new ArrayList<>();
        for(Top_video video : videos){
            System.out.println(video.getPriority());
            videos1.add(video.getVideo());
        }
        return ResponseEntity.ok(videos1);
    }
    @Override
    public ResponseEntity<?> addVideoPriority(TopVideoRequest topVideoRequest) {
        System.out.println(topVideoRequest.getPriority_id());
        try {
            Video video=videoRepository.findById(topVideoRequest.getVideo_id()).orElseThrow(()->new NoSuchElementException("No cate gory Found"));
            Top_video topVideo=new Top_video();
            topVideo.setPriority(topVideoRequest.getPriority_id());
            System.out.println(topVideoRequest.getPriority_id());
            topVideo.setVideo(video);
            Top_video savedTopVideo=topVideoRepository.save(topVideo);
            return new ResponseEntity<>(savedTopVideo, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(topVideoRequest);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<List<Map<String, Object>>> getTopVideosWithLocalizedData(String languageId) {
        List<Object[]> topVideosWithLocalizedData = topVideoRepository.getTopVideosWithLocalizedData(languageId);
        List<Map<String, Object>> topVideoList = new ArrayList<>();

        for (Object[] videoData : topVideosWithLocalizedData) {
            Map<String, Object> videoMap = new HashMap<>();
            videoMap.put("video_id", (Integer) videoData[2]);
            videoMap.put("video_url", (String) videoData[3]);
            videoMap.put("video_title", (String) videoData[4]);
            videoMap.put("video_description", (String) videoData[5]);
            videoMap.put("video_short_description", (String) videoData[6]);
            videoMap.put("video_img", (String) videoData[7]);

            Map<String, Object> subCategoryMap = new HashMap<>();
            subCategoryMap.put("sub_category_id", (Integer) videoData[8]);
            subCategoryMap.put("sub_category_name", (String) videoData[15]);
            subCategoryMap.put("sub_category_details", (String) videoData[16]);

            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("category_id", (Integer) videoData[11]);
            categoryMap.put("category_name", (String) videoData[17]);
            categoryMap.put("category_details", (String) videoData[18]);
            categoryMap.put("category_img", (String) videoData[12]);

            Map<String, Object> guestMap = new HashMap<>();
            guestMap.put("guest_id", (Integer) videoData[9]);
            guestMap.put("guest_name", (String) videoData[13]);
            guestMap.put("guest_information", (String) videoData[14]);
            guestMap.put("guest_img", (String) videoData[10]);


            videoMap.put("subCategoryId", subCategoryMap);
            videoMap.put("guest", guestMap);
            subCategoryMap.put("categoryId", categoryMap);

            topVideoList.add(videoMap);
        }
        return ResponseEntity.ok(topVideoList);
    }
}
