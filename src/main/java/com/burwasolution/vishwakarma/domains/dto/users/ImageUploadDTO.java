package com.burwasolution.vishwakarma.domains.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageUploadDTO {
    private String id;
    private String voterId;
    private String rationId;
    private String manregaId;
    private String bhulekhId;
    private String aadharId;
    private String panCardId;
    private String fileName;
    private String url;
    private String fileSize;
    private String fileType;
    private String familyId;
    private String idName;
}
