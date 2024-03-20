package cwr.com.CharchaWithRucha.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest {
    private String video_url;
    private String video_title;
    private String video_description;
    private String video_short_description;
    private String video_img;
    private int sub_category_id;
    private int guest_id;
}
