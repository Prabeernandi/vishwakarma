package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployedDetailsDTO {

    private String name;
    private String userId;
    private String familyId;
    private String aadharNo;
}
