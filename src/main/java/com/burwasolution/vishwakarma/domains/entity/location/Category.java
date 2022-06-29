package com.burwasolution.vishwakarma.domains.entity.location;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "category")
public class Category extends BaseObject {

    private String name;
    private String categoryCode;
    private String displayName;
    private String villageCode;

}
