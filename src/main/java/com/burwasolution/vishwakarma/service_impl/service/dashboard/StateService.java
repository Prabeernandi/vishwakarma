package com.burwasolution.vishwakarma.service_impl.service.dashboard;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.dto.response.location.StatesDTO;
import com.burwasolution.vishwakarma.domains.entity.location.States;

import java.util.List;

public interface StateService {
    List<States> saveData(List<States> states);

    List<LocationLists> findAll();

    List<StatesDTO> getCountsInState(String stateId);
}
