package cwr.com.CharchaWithRucha.model;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Language_details {
    private String language_id;
    private String language;
}
