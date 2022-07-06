package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.UnApprovedUsers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnApprovedUsersRepository extends MongoRepository<UnApprovedUsers, String> {
    UnApprovedUsers findByVoterId(String voterId);
}
