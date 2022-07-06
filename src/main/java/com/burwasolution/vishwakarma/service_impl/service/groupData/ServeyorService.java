package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;
import com.burwasolution.vishwakarma.domains.entity.basic.UnApprovedUsers;
import javassist.NotFoundException;

import java.util.List;

public interface ServeyorService {
    UnApprovedUsers addFamilyMember(IndividualListDTO familyMember, boolean doLink) throws NotFoundException;

    List<Employed> getEmployedType();
    List<GovtSchemes> getGovtSchemes();
    UnApprovedUsers editFamilyMember(IndividualListDTO familyMember, String id) throws NotFoundException;
}
