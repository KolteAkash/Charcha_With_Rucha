package cwr.com.CharchaWithRucha.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategorieyResponse {
    private int category_id;
    private String category_name;
    private String category_details;
    private String category_img;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategories")
    private List<SubCategoryDetail> subCategories;
}
