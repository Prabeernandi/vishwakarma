package com.burwasolution.vishwakarma.service_impl.impl.dashboard.location;

import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.dto.response.location.TehsilCountDTO;
import com.burwasolution.vishwakarma.domains.entity.location.Tehsil;
import com.burwasolution.vishwakarma.reprository.location.TehsilRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.TehsilService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class TehsilServiceImpl implements TehsilService {

    private final TehsilRepository tehsilRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TehsilServiceImpl(TehsilRepository tehsilRepository, ModelMapper modelMapper) {
        this.tehsilRepository = tehsilRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Tehsil> saveData(List<Tehsil> tehsil) {
        return tehsilRepository.saveAll(tehsil);
    }

    @Override
    public List<Tehsil> findAll() {
        return tehsilRepository.findAll();
    }

    @Override
    public List<LocationLists> findByDistrictCode(String districtId) {
        List<Tehsil> tehsils = tehsilRepository.findByDistrictCode(districtId);
        List<LocationLists> locationLists = new ArrayList<>();
        for (Tehsil list : tehsils) {
            LocationLists setTehsilList = LocationLists.builder()
                    .name(list.getName())
                    .displayName(list.getDisplayName())
                    .code(list.getTehsilCode())
                    .build();
            locationLists.add(setTehsilList);
        }

        return locationLists;
    }

    @Override
    public TehsilCountDTO getCountsInTehsil(String tehsilId) {
        Tehsil tehsil = tehsilRepository.findByTehsilCode(tehsilId);
        if (tehsil != null) {
            long families, employed, govtSchemesEnrolled, vMulyankana;
            families = employed = govtSchemesEnrolled = vMulyankana = 0;

            if (tehsilId.equals("S01")) {
                families = 34767;
                employed = 12456;
                govtSchemesEnrolled = 3416;
                vMulyankana = 13786;
            } else if (tehsilId.equals("B01")) {
                families = 23768;
                employed = 15987;
                govtSchemesEnrolled = 2544;
                vMulyankana = 18097;

            } else if (tehsilId.equals("R01")) {
                families = 38998;
                employed = 22000;
                govtSchemesEnrolled = 9887;
                vMulyankana = 16776;

            }

            TehsilCountDTO tehsilCountDTO = TehsilCountDTO.builder()
                    .name(tehsil.getName())
                    .tehsilCode(tehsil.getTehsilCode())
                    .families(families)
                    .employed(employed)
                    .govtSchemesEnrolled(govtSchemesEnrolled)
                    .vMulyankana(vMulyankana)
                    .build();
            return tehsilCountDTO;

        } else {
            throw new NoSuchElementException();
        }


    }


}
