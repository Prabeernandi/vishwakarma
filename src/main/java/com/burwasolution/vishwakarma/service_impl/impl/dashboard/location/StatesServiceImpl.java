package com.burwasolution.vishwakarma.service_impl.impl.dashboard.location;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.dto.response.location.StatesDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.domains.entity.location.States;
import com.burwasolution.vishwakarma.reprository.location.StateRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.StateService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StatesServiceImpl implements StateService {

    private final StateRepository stateRepository;
    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    @Autowired
    public StatesServiceImpl(StateRepository stateRepository, ModelMapper modelMapper, UsersRepository usersRepository) {
        this.stateRepository = stateRepository;
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<StatesDTO> getCountsInState(String stateId) {

        List<StatesDTO> stateDetails = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> familyList = new ArrayList<>();
        ArrayList<String> employedList = new ArrayList<>();
        List<Users> getStateCode = usersRepository.findByStateCode(stateId);
        for (Users user : getStateCode) {
            if (!list.contains(user.getDistrictCode())) {
                list.add(user.getDistrictCode());

            }
            if (!familyList.contains(user.getFamilyId())) {
                familyList.add(user.getFamilyId());
            }

        }
        StatesDTO stateDetailsList = StatesDTO.builder()
                .name("Haridwar")
                .stateCode("" + list.toString().replaceAll("(^\\[|\\]$)", ""))
                .families(familyList.size())
                .build();
        stateDetails.add(stateDetailsList);

        return stateDetails;

    }

    @Override
    public List<States> saveData(List<States> states) {
        return stateRepository.saveAll(states);
    }

    @Override
    public List<LocationLists> findAll() {
        List<States> statesList = stateRepository.findAll();
        List<LocationLists> statesResponseList = new ArrayList<>();


        for (States states : statesList) {
            LocationLists statesDTO = LocationLists.builder()
                    .name(states.getName())
                    .displayName(states.getDisplayName())
                    .code(states.getStateCode())
                    .build();
            statesResponseList.add(statesDTO);
        }

        return statesResponseList;
    }


}