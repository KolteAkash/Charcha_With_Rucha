package cwr.com.CharchaWithRucha.model;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryRequest {
    private String sub_category_name;
    private String sub_category_details;
    private int category_id;
}
