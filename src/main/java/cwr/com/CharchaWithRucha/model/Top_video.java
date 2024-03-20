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
@Table(name="top_video")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Top_video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int top_video_id;
    private int priority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id")
    private Video video;
}
