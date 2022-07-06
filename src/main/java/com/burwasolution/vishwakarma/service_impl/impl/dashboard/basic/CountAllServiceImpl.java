package com.burwasolution.vishwakarma.service_impl.impl.dashboard.basic;

import com.burwasolution.vishwakarma.reprository.users.CountAllRepository;
import com.burwasolution.vishwakarma.service_impl.service.basic.CountAllService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountAllServiceImpl implements CountAllService {

    private final CountAllRepository countAllRepository;


    @Autowired
    public CountAllServiceImpl(CountAllRepository countAllRepository) {
        this.countAllRepository = countAllRepository;
    }


}
