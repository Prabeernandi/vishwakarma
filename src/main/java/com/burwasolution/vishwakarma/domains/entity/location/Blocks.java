package com.burwasolution.vishwakarma.domains.entity.location;

import com.burwasolution.vishwakarma.domains.entity.basic.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "block")
public class Blocks extends BaseObject {

    private String name;
    private String blockCode;
    private String displayName;
    private String tehsilCode;
}
