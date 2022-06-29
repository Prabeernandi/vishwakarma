package com.burwasolution.vishwakarma.domains.entity.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseObject {

    private String description;
    private String roleName;
    private String username;


}
