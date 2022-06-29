package com.burwasolution.vishwakarma.service_impl.service.general;

import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Age;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Gender;

import java.util.List;

public interface HeaderLabelService {

    List<Age> saveDetails(List<Age> details);

    List<Age> getAgeFilter();

    List<Gender> getGenderFilter();
}
