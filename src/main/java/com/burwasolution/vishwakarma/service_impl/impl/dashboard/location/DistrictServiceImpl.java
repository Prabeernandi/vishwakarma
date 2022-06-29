package com.burwasolution.vishwakarma.service_impl.impl.dashboard.location;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.entity.location.District;
import com.burwasolution.vishwakarma.reprository.location.DistrictRepository;
import com.burwasolution.vishwakarma.reprository.location.StateRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final StateRepository stateRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository, ModelMapper modelMapper
            , UsersRepository usersRepository, StateRepository stateRepository) {
        this.districtRepository = districtRepository;
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
        this.stateRepository = stateRepository;
    }


    @Override
    public List<District> saveData(List<District> district) {
        return districtRepository.saveAll(district);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<LocationLists> findByStateCode(String id) {

        List<District> districtList = districtRepository.findAllByStateCode(id);
        List<LocationLists> locationLists = new ArrayList<>();

        for (District getDistrict : districtList) {

            LocationLists setDistrictList = LocationLists.builder()
                    .name(getDistrict.getName())
                    .displayName(getDistrict.getStateName())
                    .displayName(getDistrict.getDisplayName())
                    .code(getDistrict.getDistrictCode())
                    .build();
            locationLists.add(setDistrictList);
        }


        return locationLists;
    }

//    @Override
//    public List<DistrictCountDTO> getCountsInDistrict(String districtId) {

//        District district = districtRepository.findByDistrictCode(districtId);
//
//        if(district!=null){
//
//            List<Users> getDistrictCode = usersRepository.findByDistrictCode(district.getDistrictCode());
//            ArrayList<String> list = new ArrayList<>();
//            for(Users usersCount : getDistrictCode)
//            {
//                if(!list.contains(usersCount.getFamilyId()))
//                {
//                    list.add(usersCount.getFamilyId());
//
//                }
//
//            }
//            log.error("Family Id "+list.size());
//            return null;
//
//        } else {
//            throw new NoSuchElementException();
//        }
//    }


}
