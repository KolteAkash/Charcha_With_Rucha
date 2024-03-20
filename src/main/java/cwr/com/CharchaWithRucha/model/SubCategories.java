package cwr.com.CharchaWithRucha.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="sub_categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sub_category_id;
    @Column(unique = true)
    private String sub_category_name;
    private String sub_category_details;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categoryId;
    private String subcategory_img;
}
