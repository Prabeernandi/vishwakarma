package com.burwasolution.vishwakarma.domains.dto.response.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationLists {

    private String name;
    private String displayName;
    private String code;
}
