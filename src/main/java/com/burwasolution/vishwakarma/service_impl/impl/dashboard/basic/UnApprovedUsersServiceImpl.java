package com.burwasolution.vishwakarma.service_impl.impl.dashboard.basic;

import com.burwasolution.vishwakarma.domains.entity.basic.FamilyMembersDetails;
import com.burwasolution.vishwakarma.reprository.users.UnApprovedUsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.basic.UnApprovedUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnApprovedUsersServiceImpl implements UnApprovedUsersService {

    private final UnApprovedUsersRepository unApprovedUsersRepository;

    @Autowired
    public UnApprovedUsersServiceImpl(UnApprovedUsersRepository unApprovedUsersRepository) {
        this.unApprovedUsersRepository = unApprovedUsersRepository;
    }

    @Override
    public FamilyMembersDetails saveUsers(FamilyMembersDetails users) {
        return unApprovedUsersRepository.save(users);
    }
}
