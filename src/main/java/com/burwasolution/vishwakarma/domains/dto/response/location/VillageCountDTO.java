package com.burwasolution.vishwakarma.domains.dto.response.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VillageCountDTO {

    private String name;
    private String villageCode;
    private long families;
    private long employed;
    private long govtSchemesEnrolled;
    private long vMulyankana;

}
