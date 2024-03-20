package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.*;
import cwr.com.CharchaWithRucha.repository.CategoriesRepository;
import cwr.com.CharchaWithRucha.repository.GuestRepository;
import cwr.com.CharchaWithRucha.repository.SubCategoriesRepository;
import cwr.com.CharchaWithRucha.repository.VideoRepository;
import cwr.com.CharchaWithRucha.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VideoImpl implements VideoService {
    @Autowired
    private SubCategoriesRepository subCategoriesRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public ResponseEntity<List<?>> getAllVideos(){
        List<Video> videos=videoRepository.findAll();
        return ResponseEntity.ok(videos);
    }
    @Override
    public ResponseEntity<?> getVideoById(Integer id){
        Video video=videoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Video Not Found"));
        return ResponseEntity.ok(video);
    }
    @Override
    public ResponseEntity<?> addNewVideo(VideoRequest videoRequest) {
        try {
            System.out.println(videoRequest);
            SubCategories sub=subCategoriesRepository.findById(videoRequest.getSub_category_id()).orElseThrow(()->new NoSuchElementException("No cate gory Found"));
            Guest guest=guestRepository.findById(videoRequest.getGuest_id()).orElseThrow(()->new NoSuchElementException("No cate gory Found"));
            System.out.println(sub);
            Video abc=new Video();
            abc.setVideo_title(videoRequest.getVideo_title());
            abc.setVideo_description(videoRequest.getVideo_description());
            abc.setVideo_url(videoRequest.getVideo_url());
            abc.setSubCategoryId(sub);
            abc.setVideo_short_description(videoRequest.getVideo_short_description());
            abc.setVideo_img(videoRequest.getVideo_img());
            abc.setGuest(guest);
            System.out.println(abc);
            Video video=videoRepository.save(abc);
            return new ResponseEntity<>(video, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(videoRequest);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllVideosWithLocalizedData(String languageId) {
        List<Object[]> videosWithLocalizedData = videoRepository.getAllVideosWithLocalizedData(languageId);
        List<Map<String, Object>> videoList = new ArrayList<>();

        for (Object[] videoData : videosWithLocalizedData) {
            Map<String, Object> videoMap = new HashMap<>();
            videoMap.put("video_id", (Integer) videoData[0]);
            videoMap.put("video_url", (String) videoData[1]);
            videoMap.put("video_title", (String) videoData[2]);
            videoMap.put("video_description", (String) videoData[3]);
            videoMap.put("video_short_description", (String) videoData[4]);
            videoMap.put("video_img", (String) videoData[5]);

            Map<String, Object> subCategoryMap = new HashMap<>();
            subCategoryMap.put("sub_category_id", (Integer) videoData[6]);
            subCategoryMap.put("sub_category_name", (String) videoData[13]);
            subCategoryMap.put("sub_category_details", (String) videoData[14]);

            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("category_id", (Integer) videoData[9]);
            categoryMap.put("category_name", (String) videoData[15]);
            categoryMap.put("category_details", (String) videoData[16]);
            categoryMap.put("category_img", (String) videoData[10]);


            Map<String, Object> guestMap = new HashMap<>();
            guestMap.put("guest_id", (Integer) videoData[7]);
            guestMap.put("guest_img", (String) videoData[8]);
            guestMap.put("guest_name", (String) videoData[11]);
            guestMap.put("guest_information", (String) videoData[12]);

            videoMap.put("subCategoryId", subCategoryMap);
            videoMap.put("guest", guestMap);
            subCategoryMap.put("categoryId", categoryMap);


            videoList.add(videoMap);
        }
        return ResponseEntity.ok(videoList);
    }
    @Override
    public ResponseEntity<?> getVideoByIdAndLanguageId(Integer id, String languageId) {
        List<Object[]> videoData = videoRepository.getVideoByIdAndLanguageId(id, languageId);

        if (videoData.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Object[] videoInfo = videoData.get(0);

        Map<String, Object> videoMap = new HashMap<>();
        videoMap.put("video_id", (Integer) videoInfo[0]);
        videoMap.put("video_url", (String) videoInfo[1]);
        videoMap.put("video_title", (String) videoInfo[2]);
        videoMap.put("video_description", (String) videoInfo[3]);
        videoMap.put("video_short_description", (String) videoInfo[4]);
        videoMap.put("video_img", (String) videoInfo[5]);

        Map<String, Object> subCategoryMap = new HashMap<>();
        subCategoryMap.put("sub_category_id", (Integer) videoInfo[6]);
        subCategoryMap.put("sub_category_name", (String) videoInfo[13]);
        subCategoryMap.put("sub_category_details", (String) videoInfo[14]);

        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("category_id", (Integer) videoInfo[9]);
        categoryMap.put("category_name", (String) videoInfo[15]);
        categoryMap.put("category_details", (String) videoInfo[16]);
        categoryMap.put("category_img", (String) videoInfo[10]);

        Map<String, Object> guestMap = new HashMap<>();
        guestMap.put("guest_id", (Integer) videoInfo[7]);
        guestMap.put("guest_img", (String) videoInfo[8]);
        guestMap.put("guest_name", (String) videoInfo[11]);
        guestMap.put("guest_information", (String) videoInfo[12]);

        videoMap.put("subCategoryId", subCategoryMap);
        videoMap.put("guest", guestMap);
        subCategoryMap.put("categoryId", categoryMap);

        return ResponseEntity.ok(videoMap);
    }

}
