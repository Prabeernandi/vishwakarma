package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchemesEnrolledDTO {

    private String schemeName;
    private String schemeId;
    private String population;
}
