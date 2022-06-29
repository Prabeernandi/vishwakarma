package com.burwasolution.vishwakarma.domains.dto.response;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountAll extends BaseObject {

    private long totalUsers;
}
