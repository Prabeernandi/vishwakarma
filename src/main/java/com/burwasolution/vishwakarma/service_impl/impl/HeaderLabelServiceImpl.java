package com.burwasolution.vishwakarma.service_impl.impl;

import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Age;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.Gender;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.reprository.generalDetails.HeaderLabelDetailsRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.general.HeaderLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class HeaderLabelServiceImpl implements HeaderLabelService {

    private final HeaderLabelDetailsRepository labelDetailsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public HeaderLabelServiceImpl(HeaderLabelDetailsRepository labelDetailsRepository, UsersRepository usersRepository) {
        this.labelDetailsRepository = labelDetailsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    @Bean
    public List<Age> saveDetails(List<Age> details) {
        return labelDetailsRepository.saveAll(details);
    }

    @Override
    public List<Age> getAgeFilter() {

        HashSet<Object> getAgeBar = new HashSet<>();
        List<Users> users = usersRepository.findAll();
        List<Age> list = new ArrayList<>();

        for (Users usersList : users) {

            getAgeBar.add(usersList.getAgeBar());
            log.error("Age Bar " + getAgeBar);


        }
        String[] list2 = getAgeBar.parallelStream().toArray(String[]::new);

        for (String ageList : list2) {
            Age age = Age.builder()
                    .age(ageList)
                    .build();
            list.add(age);
        }


        return list;
    }

    @Override
    public List<Gender> getGenderFilter() {
        HashSet<Object> getGender = new HashSet<>();
        List<Users> users = usersRepository.findAll();
        List<Gender> list = new ArrayList<>();

        for (Users usersList : users) {

            getGender.add(usersList.getGender());
//            log.error("Age Bar " + getGender);


        }
        String[] list2 = getGender.parallelStream().toArray(String[]::new);

        for (String genderList : list2) {
            Gender gender = Gender.builder()
                    .gender(genderList)
                    .build();
            list.add(gender);
        }


        return list;
    }
}
