package cwr.com.CharchaWithRucha.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Language")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {
    @Id
    @Column(name = "language_id")
    private String language_id;
    @Column(name = "language")
    private String Language;
}
