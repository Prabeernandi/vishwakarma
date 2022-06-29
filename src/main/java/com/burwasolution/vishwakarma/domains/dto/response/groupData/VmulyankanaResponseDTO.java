package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VmulyankanaResponseDTO {

    private String vMulyankaScore;
    private String familyName;
    private String familyId;
    private int familyCounts;
}
