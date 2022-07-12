package com.burwasolution.vishwakarma.domains.dto.response.location;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictCountDTO {

    private String name;
    private String stateName;
    private String stateCode;
    private long families;
    private long employed;
    private long govtSchemesEnrolled;
    private long vmulyankana;
    private String districtCode;
    private List<TableDataFilter> tableDataFilterList = new ArrayList<>();

}
