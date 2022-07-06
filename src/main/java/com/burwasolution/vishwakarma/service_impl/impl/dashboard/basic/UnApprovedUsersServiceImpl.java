package com.burwasolution.vishwakarma.service_impl.impl.dashboard.basic;

import com.burwasolution.vishwakarma.domains.entity.basic.UnApprovedUsers;
import com.burwasolution.vishwakarma.reprository.users.UnApprovedUsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.basic.UnApprovedUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnApprovedUsersServiceImpl implements UnApprovedUsersService {

    private UnApprovedUsersRepository unApprovedUsersRepository;

    @Autowired
    public UnApprovedUsersServiceImpl(UnApprovedUsersRepository unApprovedUsersRepository) {
        this.unApprovedUsersRepository = unApprovedUsersRepository;
    }

    @Override
    public UnApprovedUsers saveUsers(UnApprovedUsers users) {
        return unApprovedUsersRepository.save(users);
    }
}
