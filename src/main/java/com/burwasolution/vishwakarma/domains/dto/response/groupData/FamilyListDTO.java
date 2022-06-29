package com.burwasolution.vishwakarma.domains.dto.response.groupData;

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
public class FamilyListDTO {

    private String name;
    private String userId;
    private String familyId;
    private int members;
    private String stateCode;
    private String districtCode;
    private String tehsilCode;
    private String blockCode;
    private String villageCode;
    private String category;
    private String aadharNo;

}
