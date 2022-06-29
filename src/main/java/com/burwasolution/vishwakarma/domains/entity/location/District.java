package com.burwasolution.vishwakarma.domains.entity.location;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "district")
public class District extends BaseObject {

    private String name;
    private String stateName;
    private String districtCode;
    private String displayName;
    private String stateCode;

}
