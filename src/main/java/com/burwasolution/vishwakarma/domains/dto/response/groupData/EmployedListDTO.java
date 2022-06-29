package com.burwasolution.vishwakarma.domains.dto.response.groupData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployedListDTO {

    private String name;
    private EmployedType employedType;
    private String id;
    private long population;


}
