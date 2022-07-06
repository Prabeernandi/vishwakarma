package com.burwasolution.vishwakarma.service_impl.impl.dashboard.location;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.dto.response.location.VillageCountDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.domains.entity.location.Village;
import com.burwasolution.vishwakarma.reprository.location.VillageRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.VillageService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class VillageServiceImpl implements VillageService {

    private final VillageRepository villageRepository;
    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    @Autowired
    public VillageServiceImpl(VillageRepository villageRepository, ModelMapper modelMapper, UsersRepository usersRepository) {
        this.villageRepository = villageRepository;
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }


    @Override
    public List<Village> saveData(List<Village> village) {
        return villageRepository.saveAll(village);
    }

    @Override
    public List<Village> findAll() {
        return villageRepository.findAll();
    }

    @Override
    public List<LocationLists> findByBlockCode(String blockId) {
        List<Village> villageList = villageRepository.findByBlockCode(blockId);
        List<LocationLists> locationArray = new ArrayList<>();

        for (Village village : villageList) {
            LocationLists locationLists = LocationLists.builder()
                    .name(village.getName())
                    .displayName(village.getDisplayName())
                    .code(village.getVillageCode())
                    .build();
            locationArray.add(locationLists);
        }
        return locationArray;
    }

    @Override
    public VillageCountDTO getCountsInVillage(String villageId) {
        Village village = villageRepository.findByVillageCode(villageId);
        if (villageId != null) {


            List<Village> villageList = villageRepository.findByBlockCode(villageId);
            List<VillageCountDTO> villageCountDTOList = new ArrayList<>();
            List<Users> getUsersList = new ArrayList<>();
            int temp = 0;

            VillageCountDTO villageCountDTO = new VillageCountDTO();
            List<String> uniqueVillageCode = new ArrayList<>();

            for (Village getVillageCode : villageList) {
                getUsersList = usersRepository.findByVillageCode(getVillageCode.getVillageCode());

                for (Users usersHeadList : getUsersList) {

                    if (!uniqueVillageCode.contains(usersHeadList.getFamilyId())) {
                        uniqueVillageCode.add(usersHeadList.getFamilyId());
                    }

                }

                int size = uniqueVillageCode.size();
                size = size - temp;
                temp = size;
                villageCountDTO = VillageCountDTO.builder()
                        .families(size)
                        .build();
                villageCountDTOList.add(villageCountDTO);

            }
            return villageCountDTO;
        } else {
            throw new NoSuchElementException();
        }
    }


}
