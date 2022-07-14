package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.FamilyMembersDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnApprovedUsersRepository extends MongoRepository<FamilyMembersDetails, String> {
    FamilyMembersDetails findByVoterId(String voterId);
}
