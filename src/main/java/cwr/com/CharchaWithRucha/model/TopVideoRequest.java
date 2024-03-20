package cwr.com.CharchaWithRucha.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopVideoRequest {
    private int video_id;
    private int priority_id;
}
