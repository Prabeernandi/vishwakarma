package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByMobileNumber(long mobileNumber);
    Users getUserByUsername(String username);
    Users findUserByUsername(String username);
    List<Users> findByDistrictCode(String districtCode);
    List<Users> findByStateCode(String stateCode);
    List<Users> findByFamilyId(String replaceAll);
    long countByFamilyId(String familyId);
    List<Users> findAllByFamilyId(String list3);
    List<Users> findByVillageCode(String id);
    List<Users> findByBlockCode(String id);
    List<Users> findAllByAgeBar(String list3);
    List<Users> findByVoterId(String idNo);
    List<Users> findByBhulekhId(String idNo);
    List<Users> findByManrekaRegNo(String idNo);

    List<Users> findByRationCardNumber(String idNo);
}
