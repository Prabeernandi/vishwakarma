package com.burwasolution.vishwakarma.domains.dto.response.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Counts {

    private String families;
    private long familyCounts;
    private String employed;
    private long employedCounts;
    private String govtSchemesEnrolled;
    private long govtSchemesEnrolledCounts;
    private String vMulkayana;
    private long vMulkayanaCounts;
}
