package com.burwasolution.vishwakarma.domains.entity.location;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "states")
public class States extends BaseObject {

    private String name;
    private String stateCode;
    private String displayName;
    private String stateNameEng;

}
