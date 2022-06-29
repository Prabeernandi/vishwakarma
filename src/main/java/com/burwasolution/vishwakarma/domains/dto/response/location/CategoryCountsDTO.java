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
public class CategoryCountsDTO {

    private String name;
    private String categoryCode;
    private long families;
    private long employed;
    private long govtSchemesEnrolled;
    private long vMulyankana;

}
