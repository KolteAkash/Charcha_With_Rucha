package cwr.com.CharchaWithRucha.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="video")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int video_id;
    @Column(unique = true)
    private String video_url;
    private String video_title;
    private String video_description;
    private String video_short_description;
    private String video_img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private SubCategories subCategoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private Guest guest;
}
