package com.burwasolution.vishwakarma.domains.entity.headerFilter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDataFilter {

    private String name;
    private String stateCode;
    private String districtCode;
    private String tehsilCode;
    private String blockCode;
    private String villageCode;
    private String categoryCode;
    private String ageBar;
    private String gender;
    private String employedCode;
    private String schemeCode;
    private String vMulCode;
    private long families;
    private long employed;
    private long govtSchemesEnrolled;
    private long vMulScore;

}
