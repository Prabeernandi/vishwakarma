package com.burwasolution.vishwakarma.reprository.users;

import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByMobileNumber(long mobileNumber);
    Users getUserByUsername(String username);
    Users findUserByUsername(String username);
    Users findByStateCode(String stateCode);
    @Query("{'familyId':?0}")
    Stream<Users> findAllByFamilyIds(String list3);
    @Query("{'familyId':?0}")
    List<Users> findAllByFamilyId(String list3);
    List<Users> findByVillageCode(String id);
    @Query("{$and:[{'verificationStatus':'VERIFICATION_PENDING'},{'profileStatus':'PROFILE_NOT_COMPLETED'},{voterId:{$ne:null}},{$or:[{voterId:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
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
    @Query("{$and:[{'verificationStatus':'VERIFICATION_PENDING'},{'profileStatus':'PROFILE_NOT_COMPLETED'},{rationCardNumber:{$ne:null}},{$or:[{rationCardNumber:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByRationCardNumber(String idNo);
    @Query("{$and:[{'verificationStatus':'VERIFICATION_PENDING'},{'profileStatus':'PROFILE_NOT_COMPLETED'},{manrekaRegNo:{$ne:null}},{$or:[{manrekaRegNo:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByManrekaRegNo(String idNo);
    @Query("{$and:[{bhulekhId:{$ne:null}},{$or:[{bhulekhId:{$regex:?0}},{fullName:{$regex:?0}}]}]}")
    List<Users> findByBhulekhId(String idNo);
    @Query("{$and:[{'verificationStatus':'VERIFICATION_PENDING'},{'profileStatus':'PROFILE_NOT_COMPLETED'},{'verificationStatus':'VERIFICATION_PENDING'},{'profileStatus':'PROFILE_NOT_COMPLETED'}]},limit?0")
    Page<Users> findAllByProfileStatus(PageRequest of);
    List<Users> findAllByStateCodeAndAgeBar(String stateCode, String ageBar);
    List<Users> findAllByStateCodeAndAgeBarAndGender(String stateCode, String ageBar, String gender);
    List<Users> findAllByStateCodeAndAgeBarAndGenderAndEmployedCode(String stateCode, String ageBar, String gender, String employedCode);
    List<Users> findAllByStateCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(String stateCode, String ageBar, String gender, String employedCode, String schemeCode);
    Users findAllByEmployedCode(String list3);
    List<Users> findAllByFamilyIdAndVerificationStatus(String familyId, String verifyPending);
    @Query("{$or:[{villageCode:?0},{ageBar:?1},{gender:?02}]}")
    List<Users> findAllBy(String villageCode, String ageBar,String gender);
    List<Users> findAllByVerificationStatusAndProfileStatus(String approvedByAdmins, String profileCompleted);
    List<Users> findAllByVerificationStatus(String approvedByAdmins);
    Stream<Users> findAllBySchemeCodeNot(boolean equals);
    List<Users> findAllByVillageCodeAndGenderAndEmployedCode(String villageCode, String gender, String employedCode);
    List<Users> findAllByVillageCodeAndGenderAndSchemeCode(String villageCode, String gender, String schemeCode);
    List<Users> findAllByVillageCodeAndSchemeCodeAndEmployedCode(String villageCode, String schemeCode, String employedCode);

    List<Users> findAllByVillageCodeAndGender(String villageCode, String gender);

    List<Users> findAllByVillageCodeAndSchemeCode(String villageCode, String schemeCode);

    List<Users> findAllByVillageCodeAndEmployedCode(String villageCode, String employedCode);

    List<Users> findAllByVillageCodeAndAgeBarAndSchemeCode(String villageCode, String ageBar, String schemeCode);

    List<Users> findAllByBlockCodeAndEmployedCode(String blockCode, String employedCode);

    List<Users> findAllByBlockCodeAndSchemeCode(String blockCode, String schemeCode);

    List<Users> findAllByBlockCodeAndGender(String blockCode, String gender);

    List<Users> findAllByBlockCodeAndSchemeCodeAndEmployedCode(String blockCode, String schemeCode, String employedCode);

    List<Users> findAllByBlockCodeAndGenderAndSchemeCode(String blockCode, String gender, String schemeCode);

    List<Users> findAllByBlockCodeAndGenderAndEmployedCode(String blockCode, String gender, String employedCode);

    List<Users> findAllByBlockCodeAndAgeBarAndEmployedCode(String blockCode, String ageBar, String employedCode);

    List<Users> findAllByBlockCodeAndAgeBarAndSchemeCode(String blockCode, String ageBar, String schemeCode);

    List<Users> findAllByTehsilCodeAndEmployedCode(String tehsilCode, String employedCode);

    List<Users> findAllByTehsilCodeAndSchemeCode(String tehsilCode, String schemeCode);

    List<Users> findAllByTehsilCodeAndGender(String tehsilCode, String gender);

    List<Users> findAllByTehsilCodeAndSchemeCodeAndEmployedCode(String tehsilCode, String schemeCode, String employedCode);

    List<Users> findAllByTehsilCodeAndGenderAndSchemeCode(String tehsilCode, String gender, String schemeCode);

    List<Users> findAllByTehsilCodeAndGenderAndEmployedCode(String tehsilCode, String gender, String employedCode);

    List<Users> findAllByTehsilCodeAndAgeBarAndEmployedCode(String tehsilCode, String ageBar, String employedCode);

    List<Users> findAllByTehsilCodeAndAgeBarAndSchemeCode(String tehsilCode, String ageBar, String schemeCode);

    List<Users> findAllByDistrictCodeAndAgeBarAndEmployedCode(String districtCode, String ageBar, String employedCode);

    List<Users> findAllByDistrictCodeAndGenderAndSchemeCode(String districtCode, String gender, String schemeCode);

    List<Users> findAllByDistrictCodeAndSchemeCodeAndEmployedCode(String districtCode, String schemeCode, String employedCode);

    List<Users> findAllByDistrictCodeAndAgeBarAndSchemeCode(String districtCode, String ageBar, String schemeCode);

    List<Users> findAllByDistrictCodeAndGenderAndEmployedCode(String districtCode, String gender, String employedCode);

    List<Users> findAllByDistrictCodeAndGender(String districtCode, String gender);

    List<Users> findAllByDistrictCodeAndSchemeCode(String districtCode, String schemeCode);

    List<Users> findAllByDistrictCodeAndEmployedCode(String districtCode, String employedCode);

    List<Users> findAllByStateCodeAndAgeBarAndEmployedCode(String stateCode, String ageBar, String employedCode);

    List<Users> findAllByStateCodeAndSchemeCodeAndEmployedCode(String stateCode, String schemeCode, String employedCode);

    List<Users> findAllByStateCodeAndAgeBarAndSchemeCode(String stateCode, String ageBar, String schemeCode);

    List<Users> findAllByStateCodeAndGenderAndSchemeCode(String stateCode, String gender, String schemeCode);

    List<Users> findAllByStateCodeAndGenderAndEmployedCode(String stateCode, String gender, String employedCode);

    List<Users> findAllByStateCodeAndGender(String stateCode, String gender);

    List<Users> findAllByStateCodeAndSchemeCode(String stateCode, String schemeCode);

    List<Users> findAllByStateCodeAndEmployedCode(String stateCode, String employedCode);
}
