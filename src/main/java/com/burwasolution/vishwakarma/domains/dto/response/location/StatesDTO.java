package com.burwasolution.vishwakarma.domains.dto.response.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatesDTO {

    private String name;
    private String stateCode;
    private String displayName;
    private long families;
    private long employed;
    private long govtSchemesEnrolled;
    private long vmulyankana;
    private String stateNameEng;
}
