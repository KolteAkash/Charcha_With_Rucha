package cwr.com.CharchaWithRucha.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDetail {
    private int sub_category_id;
    private String sub_category_name;
    private String sub_category_details;
    private String sub_category_img;
}
