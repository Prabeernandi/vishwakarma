package com.burwasolution.vishwakarma.domains.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Validation {

    private String employedCode;
    private String stateCode;
    private String districtCode;
    private String tehsilCode;
    private String blockCode;
    private String villageCode;
    private String categoryCode;
    private long completedRecords;
    private long validationPending;
    private long approvalPending;
    private long approved;
}
