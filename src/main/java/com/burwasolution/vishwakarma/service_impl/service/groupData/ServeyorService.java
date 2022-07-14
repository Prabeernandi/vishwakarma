package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.dto.users.ImageUploadDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.FamilyMembersDetails;
import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;
import javassist.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ServeyorService {
    FamilyMembersDetails addFamilyMember(IndividualListDTO familyMember) throws NotFoundException;
    List<Employed> getEmployedType();
    List<GovtSchemes> getGovtSchemes();
    IndividualListDTO editFamilyMember(IndividualListDTO familyMember) throws NotFoundException;
    List<FamilyListDTO> getUnVerifiedMemberList(int pageNumber);
    ImageUploadDTO serveyorUploadImage(String idName, String idNo, MultipartFile file) throws IOException;
}
