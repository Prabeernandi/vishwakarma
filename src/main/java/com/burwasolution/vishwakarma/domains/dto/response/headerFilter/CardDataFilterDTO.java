package com.burwasolution.vishwakarma.domains.dto.response.headerFilter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDataFilterDTO {

    private String name;
    private String stateCode;
    private String districtCode;
    private String tehsilCode;
    private String blockCode;
    private String villageCode;
    private String categoryCode;
    private String ageBar;
    private String gender;
    private String counts;
    private String employedCode;
    private String schemeCode;
    private String vMulCode;


}
