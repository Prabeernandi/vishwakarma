package com.burwasolution.vishwakarma.domains.entity.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "imageUpload")
public class ImageUpload extends BaseObject {

    private String fileName;
    private String url;
    private String fileSize;
    private String fileType;
    private String familyId;
    private String fileCategory;
    private String idName;
    private String idNo;
    private String uploadPath;
}
