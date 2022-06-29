package com.burwasolution.vishwakarma.service_impl.impl.dashboard.basic;

import com.burwasolution.vishwakarma.domains.entity.basic.Role;
import com.burwasolution.vishwakarma.reprository.users.RoleRepository;
import com.burwasolution.vishwakarma.service_impl.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
