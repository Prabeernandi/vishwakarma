package com.burwasolution.vishwakarma.reprository.groupData;

import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDataRepository extends MongoRepository<Users, String> {

    List<Users> findByStateCode(String stateCode);

    List<Users> findByDistrictCode(String districtCode);

    List<Users> findByTehsilCode(String tehsilCode);

    List<Users> findByBlockCode(String blockCode);

    List<Users> findByVillageCode(String villageCode);

    @Query("{'familyId':?0}")
    List<Users> findByFamilyIds(String familyId);

    List<Users> findByStateCodeAndAgeBar(String stateCode, String ageBar);

    List<Users> findByStateCodeAndAgeBarAndGender(String stateCode, String toLowerCase, String toLowerCase1);

    Users findByAadharNo(String aadharNo);

    List<Users> findByStateCodeAndEmployed(String stateCode, String employed);

    Users findByUserId(String userId);

    List<Users> findByStateCodeAndDistrictCode(String stateCode, String districtCode);

    Users findByVoterId(String voterId);

    List<Users> findByCaste(String caste);

    List<Users> findByDistrictCodeAndAgeBarAndGender(String districtCode, String toLowerCase, String toLowerCase1);

    List<Users> findByDistrictCodeAndAgeBar(String districtCode, String toLowerCase);

    List<Users> findByTehsilCodeAndAgeBar(String tehsilCode, String toLowerCase);

    List<Users> findByTehsilCodeAndAgeBarAndGender(String tehsilCode, String toLowerCase, String toLowerCase1);

    List<Users> findByBlockCodeAndAgeBarAndGender(String blockCode, String toLowerCase, String toLowerCase1);

    List<Users> findByBlockCodeAndAgeBar(String blockCode, String toLowerCase);

    List<Users> findByVillageCodeAndAgeBarAndGender(String villageCode, String toLowerCase, String toLowerCase1);

    List<Users> findByVillageCodeAndAgeBar(String villageCode, String toLowerCase);

    List<Users> findByCasteAndAgeBarAndGender(String caste, String toLowerCase, String toLowerCase1);

    List<Users> findByCasteAndAgeBar(String caste, String toLowerCase);
}
