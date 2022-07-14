package com.burwasolution.vishwakarma.domains.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageUploadDTO {
    private String fileName;
    private String url;
    private String fileSize;
    private String fileType;
    private String familyId;
    private String idName;
}
