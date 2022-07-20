package com.burwasolution.vishwakarma.domains.dto.users;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GovtSchemesDTO extends BaseObject {

    private String name;
    private String schemeCode;
    private String icon;
    private String imgUrl;
}
