package cwr.com.CharchaWithRucha.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="I18n")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class I18n {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int i18n_id;
    private String language_id;
    private String label_id;
    private String description;
}
