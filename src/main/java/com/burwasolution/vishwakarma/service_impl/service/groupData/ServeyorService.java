package com.burwasolution.vishwakarma.service_impl.service.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualListDTO;
import javassist.NotFoundException;

public interface ServeyorService {
    IndividualListDTO addFamilyMember(IndividualListDTO familyMember, boolean doLink) throws NotFoundException;
}
