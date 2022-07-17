package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByMobileNumber(long mobileNumber);
    Users getUserByUsername(String username);
    Users findUserByUsername(String username);
    Users findByStateCode(String stateCode);
    List<Users> findAllByFamilyId(String list3);
    List<Users> findByVillageCode(String id);
    @Query("{$and:[{voterId:{$ne:null}},{$or:[{voterId:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByVoterIdAndFullName(String idNo);
    Users findUserByVoterId(String idNo);
    Users findUserByVoterIdAndFamilyId(String voterId, String familyId);

    @Query("{'govtSchemeEnrolled':{$ne:null}}")
    List<Users> findAllByGovtSchemeEnrolled();
    List<Users> findAllByStateCode(String stateCode);
    List<Users> findAllByVillageCode(String villageCode);
    List<Users> findAllByBlockCode(String categoryCode);
    List<Users> findAllByVillageCodeAndAgeBar(String villageCode, String ageBar);
    @Query("{'villageCode':{$regex:?0},'ageBar':{$regex:?1},'employedCode':{$regex:?2}}")
    List<Users> findAllByVillageCodeAndAgeBarAndEmployedCode(String villageCode, String ageBar, String employedCode);
    @Query("{employed:{$ne:null}}")
    List<Users> findByEmployed(String employed);
    List<Users> findAllBySchemeCode(String schemeCode);
    @Query("{employed:{$ne:null}}")
    List<Users> findAllByEmployed();
    List<Users> findAllByVillageCodeAndAgeBarAndGender(String villageCode, String ageBar, String gender);

    List<Users> findAllByVillageCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(String villageCode, String ageBar, String gender, String employedCode, String schemeCode);
    List<Users> findAllByTehsilCode(String tehsilCode);
    List<Users> findAllByDistrictCode(String districtCode);
    List<Users> findAllByDistrictCodeAndAgeBar(String districtCode, String ageBar);
    List<Users> findAllByDistrictCodeAndAgeBarAndGender(String districtCode, String ageBar, String gender);
    List<Users> findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCode(String districtCode, String ageBar, String gender, String employedCode);
    List<Users> findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(String districtCode, String ageBar, String gender, String employedCode, String schemeCode);
    List<Users> findAllByTehsilCodeAndAgeBar(String tehsilCode, String ageBar);
    List<Users> findAllByTehsilCodeAndAgeBarAndGender(String tehsilCode, String ageBar, String gender);
    List<Users> findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCode(String tehsilCode,String ageBar, String gender, String employedCode);
    List<Users> findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(String tehsilCode, String ageBar, String gender, String employedCode, String schemeCode);    List<Users> findAllByVillageCodeAndAgeBarAndGenderAndEmployedCode(String villageCode, String ageBar, String gender, String employedCode);
    List<Users> findAllByBlockCodeAndAgeBar(String blockCode, String ageBar);
    List<Users> findAllByBlockCodeAndAgeBarAndGender(String blockCode, String ageBar, String gender);
    List<Users> findAllByBlockCodeAndAgeBarAndGenderAndEmployedCode(String blockCode, String ageBar, String gender, String employedCode);
    List<Users> findAllByBlockCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(String blockCode, String ageBar, String gender, String employedCode, String schemeCode);
    @Query("{$and:[{rationCardNumber:{$ne:null}},{$or:[{rationCardNumber:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByRationCardNumber(String idNo);
    @Query("{$and:[{manrekaRegNo:{$ne:null}},{$or:[{manrekaRegNo:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByManrekaRegNo(String idNo);
    @Query("{$and:[{bhulekhId:{$ne:null}},{$or:[{bhulekhId:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByBhulekhId(String idNo);
    @Query("{$and:[{'profileStatus':'PROFILE_NOT_COMPLETED'}]},limit?0s")
    Page<Users> findAllByProfileStatus(PageRequest of);
}
