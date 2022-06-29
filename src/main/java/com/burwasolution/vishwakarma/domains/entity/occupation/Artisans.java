package com.burwasolution.vishwakarma.domains.entity.occupation;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "artisans")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Artisans extends BaseObject {

    private String pehchanCardNO;
    private String artisansName;
    private String fatherSpouseName;
    private String category;
    private String voterId;

}
