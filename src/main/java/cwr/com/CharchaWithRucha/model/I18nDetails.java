package cwr.com.CharchaWithRucha.model;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class I18nDetails {
    private int guest_i18n;
    private String language_id;
    private String label_id;
    private String description;
}
