package com.burwasolution.vishwakarma.domains.entity.basic;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "govtSchemes")
public class GovtSchemes extends BaseObject {

    private String name;
    private String schemeCode;
    private String icon;

}
