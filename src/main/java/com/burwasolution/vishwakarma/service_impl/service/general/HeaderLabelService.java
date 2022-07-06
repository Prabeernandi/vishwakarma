package com.burwasolution.vishwakarma.service_impl.service.general;

import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Age;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Gender;
import com.burwasolution.vishwakarma.domains.entity.basic.Employed;
import com.burwasolution.vishwakarma.domains.entity.basic.GovtSchemes;

import java.util.List;

public interface HeaderLabelService {

    List<Age> saveDetails(List<Age> details);
    List<Age> getAgeFilter();
    List<Gender> getGenderFilter();
    List<Employed> getHeaderEmployed();
    List<GovtSchemes> getHeaderGovtSchemesFilter();
}
