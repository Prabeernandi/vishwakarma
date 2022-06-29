package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRoleName(String roleUser);
}
