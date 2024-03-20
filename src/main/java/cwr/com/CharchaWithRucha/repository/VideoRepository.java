package cwr.com.CharchaWithRucha.repository;

import cwr.com.CharchaWithRucha.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Query("SELECT v.video_id, v.video_url, vt.description as video_title, vd.description as video_description, vsd.description as video_short_description, v.video_img, " +
            "v.subCategoryId.sub_category_id, v.guest.guest_id, v.guest.guest_img, v.subCategoryId.categoryId.category_id, v.subCategoryId.categoryId.category_img, " +
            "gn.description as guest_name, gi.description as guest_information, " +
            "sn.description as sub_category_name, sd.description as sub_category_details, " +
            "cn.description as category_name, cd.description as category_details " +
            "FROM Video v " +
            "JOIN I18n vd ON v.video_description = vd.label_id AND vd.language_id = :languageId " +
            "JOIN I18n vt ON v.video_title = vt.label_id AND vt.language_id = :languageId " +
            "JOIN I18n vsd ON v.video_short_description = vsd.label_id AND vsd.language_id = :languageId " +
            "JOIN Guest g ON v.guest.guest_id = g.guest_id " +
            "JOIN I18n gn ON g.guest_name = gn.label_id AND gn.language_id = :languageId " +
            "JOIN I18n gi ON g.guest_information = gi.label_id AND gi.language_id = :languageId " +
            "JOIN SubCategories s ON v.subCategoryId.sub_category_id = s.sub_category_id " +
            "JOIN I18n sn ON s.sub_category_name = sn.label_id AND sn.language_id = :languageId " +
            "JOIN I18n sd ON s.sub_category_details = sd.label_id AND sd.language_id = :languageId " +
            "JOIN Categories c ON s.categoryId.category_id = c.category_id " +
            "JOIN I18n cn ON c.category_name = cn.label_id AND cn.language_id = :languageId " +
            "JOIN I18n cd ON c.category_details = cd.label_id AND cd.language_id = :languageId")
    List<Object[]> getAllVideosWithLocalizedData(@Param("languageId") String languageId);
    
    
    @Query("SELECT v.video_id, v.video_url, vt.description as video_title, vd.description as video_description, vsd.description as video_short_description, v.video_img, " +
            "v.subCategoryId.sub_category_id, v.guest.guest_id, v.guest.guest_img, v.subCategoryId.categoryId.category_id, v.subCategoryId.categoryId.category_img, " +
            "gn.description as guest_name, gi.description as guest_information, " +
            "sn.description as sub_category_name, sd.description as sub_category_details, " +
            "cn.description as category_name, cd.description as category_details " +
            "FROM Video v " +
            "JOIN I18n vd ON v.video_description = vd.label_id AND vd.language_id = :languageId " +
            "JOIN I18n vt ON v.video_title = vt.label_id AND vt.language_id = :languageId " +
            "JOIN I18n vsd ON v.video_short_description = vsd.label_id AND vsd.language_id = :languageId " +
            "JOIN Guest g ON v.guest.guest_id = g.guest_id " +
            "JOIN I18n gn ON g.guest_name = gn.label_id AND gn.language_id = :languageId " +
            "JOIN I18n gi ON g.guest_information = gi.label_id AND gi.language_id = :languageId " +
            "JOIN SubCategories s ON v.subCategoryId.sub_category_id = s.sub_category_id " +
            "JOIN I18n sn ON s.sub_category_name = sn.label_id AND sn.language_id = :languageId " +
            "JOIN I18n sd ON s.sub_category_details = sd.label_id AND sd.language_id = :languageId " +
            "JOIN Categories c ON s.categoryId.category_id = c.category_id " +
            "JOIN I18n cn ON c.category_name = cn.label_id AND cn.language_id = :languageId " +
            "JOIN I18n cd ON c.category_details = cd.label_id AND cd.language_id = :languageId " +
            "WHERE v.video_id = :videoId")
     List<Object[]> getVideoByIdAndLanguageId(@Param("videoId") Integer videoId, @Param("languageId") String languageId);
 }