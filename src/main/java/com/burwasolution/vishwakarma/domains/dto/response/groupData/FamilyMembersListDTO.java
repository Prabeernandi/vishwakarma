package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMembersListDTO {

    private String name;
    private String familyId;
    private String aadharNo;
    private String voterId;

}
