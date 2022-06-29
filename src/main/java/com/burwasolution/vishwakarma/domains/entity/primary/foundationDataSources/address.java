package com.burwasolution.vishwakarma.domains.entity.primary.foundationDataSources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class address {

    private String village;
    private String block;
    private String district;
    private String state;
}
