package com.burwasolution.vishwakarma.service_impl.impl.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.*;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.reprository.groupData.GroupDataRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.groupData.GroupDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class GroupDataServiceImpl implements GroupDataService {

    private final GroupDataRepository groupDataRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public GroupDataServiceImpl(GroupDataRepository groupDataRepository, UsersRepository usersRepository) {
        this.groupDataRepository = groupDataRepository;
        this.usersRepository = usersRepository;
    }

    private List<FamilyListDTO> getFamilyList(List<Users> locationCriteria) {
        List<FamilyListDTO> familyList = new ArrayList<>();


        ArrayList<String> list = new ArrayList<>();
        List<Users> getHeadList = new ArrayList<>();
        for (Users usersHeadList : locationCriteria) {
            if (!list.contains(usersHeadList.getFamilyId())) {
                list.add(usersHeadList.getFamilyId());//

            }
        }
        log.error("Family Id " + list.size());
        FamilyListDTO familyListDTO = new FamilyListDTO();
        String[] list2 = list.parallelStream().toArray(String[]::new);
        log.error("Family Id " + list2.length);
//            String[] list2 = {"744201", "744061", "74406/11", "74406/21", "74406/31", "744071", "74407/11", "74407/21", "74407/31", "74407/51", "744081", "74408/11", "74408/21", "744091", "744101", "744111", "74411/11", "74411/21", "74411क1", "744121", "744131", "744141", "744151", "744161", "74416/11", "744171", "744181", "74418/11", "74418/21", "74418/31", "74419/11", "744211", "744221", "744231", "744241", "744251", "744261", "744271", "744281", "744291", "744301", "744311", "74431/11", "74431/21", "744321", "74432/11", "74432/21", "74432/31", "74432/41", "744331", "744341", "74434/11", "74434/21", "744351", "74435/11", "74435/21", "74435/31", "74४३५/३1", "744361", "744371", "74437/11", "74437/21", "74437/31", "74437/41", "744381", "74438/11", "74438/21", "74438/31", "744391", "744401", "74440/11", "74440/21", "744411", "744421", "744431", "74443/11", "74443/21", "744441", "74444/11", "74444/21", "744451", "74445/11", "744461", "74446/11", "744471", "74447/11", "74447/21", "744481", "744491", "744501", "744511", "744521", "744531", "744541", "744561", "744571", "744581", "744591", "744601", "74460/11", "744611", "744621", "744631", "744641", "744661", "744671", "744681", "74468/11", "744691", "74469/11", "744701", "744711", "74471क1", "744721", "74472/11", "74472/21", "744731", "74473क1", "744741", "744751", "744761", "74476/11", "74476/21", "744771", "74477/11", "74477/21", "74477/31", "74477/41", "744781", "744791", "744801", "74480/11", "74480/21", "74480/31", "744811", "744821", "744831", "744841", "744851", "74485/11", "74485/21", "74485/31", "744861", "744871", "744881", "744891", "74489/11", "74489/21", "74489/31", "74489/41", "74489/51", "744901", "74490/11", "74490/21", "74490/31", "744911", "744921", "744931", "744941", "744951", "744961", "744981", "744991", "74499/11", "745001", "745011", "745021", "74502/11", "74502/21", "745031", "745041", "74504/11", "74504/21", "745051", "745061", "74506क1", "74392", "741162", "742662", "742842", "742902", "743092", "743312", "743322", "743332", "743342", "74334/12", "743352", "743362", "743372", "743382", "743392", "743402", "743412", "74341/12", "743422", "743432", "743442", "743462", "743472", "743482", "743492", "743502", "74350/12", "743512", "743522", "743532", "74353/12", "743562", "743572", "743592", "743602", "743612", "743622", "743632", "74363/12", "74363/22", "74363/32", "74३६३/३2", "743642", "743652", "743662", "743672", "743682", "743692", "743702", "743712", "743722", "74372/12", "743732", "743742", "743762", "743772", "743782", "743792", "743802", "74380/12", "743812", "74381/!2", "743822", "74382/12", "743832", "743842", "743852", "74385/12", "743862", "743872", "743882", "743892", "743902", "74390/12", "743912", "743922", "743932", "743972", "743982", "743992", "744002", "744012", "744022", "744032", "74403/12", "744042", "744052", "74405/12", "743621", "743421", "743331", "743911", "743371", "743681", "74405/11", "743081", "743851", "743311", "743881", "743701", "743321", "743671", "743721", "743661", "74363/31", "7551", "75521", "752381", "75321/11", "753251", "75325/11", "753611", "754691", "75469/11", "75463/31", "755011", "755021", "755071", "755081", "755091", "755101", "75510/11", "755111", "755121", "755131", "755141", "755151", "755161", "755171", "75517/11", "755181", "755191", "755201", "755211", "755221", "755231", "755241", "755251", "75525/11", "75525/21", "75525/31", "755261", "755271", "755281", "755291", "755301", "755311", "755321", "755331", "75533/11", "75533/21", "755341", "75534/11", "755351", "755361", "755371", "75537/21", "755381", "755391", "755401", "755411", "755421", "755431", "755441", "755451", "75545/11", "755461", "755471", "75547/11", "75547/21", "75547/31", "755481", "755491", "755501", "755511", "755521", "755531", "755551", "755561", "75556/11", "75556/21", "75556/31", "755571", "755581", "755591", "755601", "755611", "755621", "755631", "755641", "755651", "755661", "755671", "755681", "755691", "755701", "755711", "755721", "75572/11", "75572/21", "755731", "75573/11", "75573/21", "755741", "755751", "75575/11", "755761", "75576/11", "755771", "755791", "75579/11", "755801", "75580/11", "75580/21"};
        for (String list3 : list2) {
            getHeadList = usersRepository.findAllByFamilyId(list3);

            for (Users setHeadList : getHeadList) {

                familyListDTO = FamilyListDTO.builder()
                        .name(setHeadList.getFullName() + " Family")
                        .familyId(setHeadList.getFamilyId())
                        .members(setHeadList.getFamilyId().length())
                        .stateCode(setHeadList.getStateCode())
                        .districtCode(setHeadList.getDistrictCode())
                        .build();


            }
            familyList.add(familyListDTO);
        }


        return familyList;


    }

    @Override
    public List<FamilyListDTO> findFamilyList(Users users) {
        List<Users> usersList = new ArrayList<>();
        String ageBar = null;
        String gender = null;

        if (users.getStateCode() != null) {

            if (users.getGender() != null) {
                usersList = groupDataRepository.findByStateCodeAndAgeBarAndGender(users.getStateCode(), users.getAgeBar().toLowerCase(), users.getGender().toString().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByStateCodeAndAgeBar(users.getStateCode(), users.getAgeBar().toLowerCase());
            } else {

                usersList = groupDataRepository.findByStateCode(users.getStateCode());
            }
            return getFamilyList(usersList);


        } else if (users.getDistrictCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByDistrictCodeAndAgeBarAndGender(users.getDistrictCode(), users.getAgeBar().toLowerCase(), users.getGender().toString().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByDistrictCodeAndAgeBar(users.getDistrictCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByDistrictCode(users.getDistrictCode());
            }
            return getFamilyList(usersList);
        } else if (users.getTehsilCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByTehsilCodeAndAgeBarAndGender(users.getTehsilCode(), users.getAgeBar().toLowerCase(), users.getGender().toString().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByTehsilCodeAndAgeBar(users.getTehsilCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByTehsilCode(users.getTehsilCode());
            }
            return getFamilyList(usersList);
        } else if (users.getBlockCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByBlockCodeAndAgeBarAndGender(users.getBlockCode(), users.getAgeBar().toLowerCase(), users.getGender().toString().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByBlockCodeAndAgeBar(users.getBlockCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByBlockCode(users.getBlockCode());
            }
            return getFamilyList(usersList);
        } else if (users.getVillageCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByVillageCodeAndAgeBarAndGender(users.getVillageCode(), users.getAgeBar().toLowerCase(), users.getGender().toString().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByVillageCodeAndAgeBar(users.getVillageCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByVillageCode(users.getVillageCode());
            }
            return getFamilyList(usersList);
        } else if (users.getCaste() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByCasteAndAgeBarAndGender(users.getCaste(), users.getAgeBar().toLowerCase(), users.getGender().toString().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByCasteAndAgeBar(users.getCaste(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByCaste(users.getCaste());
            }
            return getFamilyList(usersList);
        } else {
            throw new NoSuchElementException();
        }

    }


    @Override
    public List<IndividualMemberDTO> getFamilyMemberDetails(Users users) {
        List<Users> usersList = groupDataRepository.findAll();
        List<IndividualMemberDTO> familyMemberList = new ArrayList<>();
//        String aadharMg = null;
//        for (Users usersData : usersList) {
//            if (usersData.getAadharNo() == null) {
//                aadharMg = "Not Available";
//            } else {
//                aadharMg = usersData.getAadharNo();
//            }
        int userId = (int) (Math.random() * (1000000 - 100000)) + 100000;
        for (Users usersListDetails : usersList) {

            IndividualMemberDTO individualList = IndividualMemberDTO.builder()
                    .name(usersListDetails.getFullName())
                    .userId("" + userId)
                    .familyId(usersListDetails.getFamilyId())
                    .aadharNo(usersListDetails.getAadharNo())
                    .address(usersListDetails.getAddress())
                    .dateOfBirth("Not Available")
                    .employed(usersListDetails.getEmployed())
                    .stateName(usersListDetails.getStateName())
                    .districtName(usersListDetails.getDistrictName())
                    .tehsilName(usersListDetails.getTehsilName())
                    .villageName(usersListDetails.getVillageName())
                    .voterResidence(usersListDetails.getHouseNumber())
                    .income("Not Available")
                    .age(usersListDetails.getAge())
                    .vmulyankana("Not Available")
                    .hasRashanCard(usersListDetails.isHasRashanCard())
                    .hasPradhanMantriAwaasYojna(usersListDetails.isHasPradhanMantriAwaasYojna())
                    .isPMKisaanEnabled(usersListDetails.isPMKisaanEnabled())
                    .isManrekaEnabled(usersListDetails.isManrekaEnabled())
                    .voterId(usersListDetails.getVoterId())
                    .panCardNo("Not Available")
                    .epf_nps("Not Available")
                    .gramPanchayat("Not Available")
                    .mobileNumber("Not Available")
                    .build();
            familyMemberList.add(individualList);


        }
        return familyMemberList;
//        }

    }

    @Override
    public IndividualMemberDTO getIndividualDetails(Users users) {

        users = groupDataRepository.findByVoterId(users.getVoterId());
        int userId = (int) (Math.random() * (1000000 - 100000)) + 100000;
        if (users != null) {
            IndividualMemberDTO individualList = IndividualMemberDTO.builder()
                    .name(users.getFullName())
                    .userId("" + userId)
                    .familyId(users.getFamilyId())
                    .aadharNo(users.getAadharNo())
                    .address(users.getAddress())
                    .dateOfBirth("Not Available")
                    .employed(users.getEmployed())
                    .income("Not Available")
                    .vmulyankana("Not Available")
                    .hasRashanCard(users.isHasRashanCard())
                    .hasPradhanMantriAwaasYojna(users.isHasPradhanMantriAwaasYojna())
                    .isPMKisaanEnabled(users.isPMKisaanEnabled())
                    .isManrekaEnabled(users.isManrekaEnabled())
                    .voterId(users.getVoterId())
                    .panCardNo("Not Available")
                    .epf_nps("Not Available")
                    .gramPanchayat("Not Available")
                    .mobileNumber("Not Available")
                    .build();
            return individualList;
        } else {
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<EmployedListDTO> getEmployedList(Users users) {
        List<EmployedListDTO> employedListDTOS = new ArrayList<>();

        EmployedListDTO employedList_1 = EmployedListDTO.builder()
                .name("Doctor")
                .employedType(EmployedType.builder()
                        .type1("Govt.")
                        .type2("Pvt.")
                        .build())
                .id("23456")
                .population(345667)
                .build();

        EmployedListDTO employedList_2 = EmployedListDTO.builder()
                .name("Police")
                .employedType(EmployedType.builder()
                        .type1("Govt.")
                        .build())
                .id("23457")
                .population(345623)
                .build();

        EmployedListDTO employedList_3 = EmployedListDTO.builder()
                .name("Plumber")
                .employedType(EmployedType.builder()
                        .type1("Govt.")
                        .type2("Pvt.")
                        .build())
                .id("23458")
                .population(345689)
                .build();

        EmployedListDTO employedList_4 = EmployedListDTO.builder()
                .name("Engineer")
                .employedType(EmployedType.builder()
                        .type1("Govt.")
                        .type2("Pvt.")
                        .build())
                .id("23459")
                .population(345696)
                .build();

        EmployedListDTO employedList_5 = EmployedListDTO.builder()
                .name("Teacher")
                .employedType(EmployedType.builder()
                        .type1("Govt.")
                        .type2("Pvt.")
                        .build())
                .id("23434")
                .population(345644)
                .build();

        if (users.getStateCode() != null) {
            employedListDTOS.add(employedList_1);
            employedListDTOS.add(employedList_2);
            employedListDTOS.add(employedList_3);
            employedListDTOS.add(employedList_4);
            employedListDTOS.add(employedList_5);
        } else if (users.getDistrictCode() != null) {

            employedListDTOS.add(employedList_2);
            employedListDTOS.add(employedList_3);
            employedListDTOS.add(employedList_4);
            employedListDTOS.add(employedList_5);
        } else if (users.getTehsilCode() != null) {
            employedListDTOS.add(employedList_3);
            employedListDTOS.add(employedList_4);
            employedListDTOS.add(employedList_5);
        } else if (users.getBlockCode() != null) {

            employedListDTOS.add(employedList_3);
            employedListDTOS.add(employedList_4);
            employedListDTOS.add(employedList_5);
        } else if (users.getVillageCode() != null) {
            employedListDTOS.add(employedList_4);
            employedListDTOS.add(employedList_5);
        } else if (users.getCaste() != null) {
            employedListDTOS.add(employedList_5);
        }
        return employedListDTOS;
    }

    @Override
    public List<EmployedDetailsDTO> getListBySpecificEmployed(Users users) {
        List<Users> usersList = new ArrayList<>();
        List<EmployedDetailsDTO> individualMemberList = new ArrayList<>();
        int userId = (int) (Math.random() * (1000000 - 100000)) + 100000;
        if (users.getStateCode() != null) {
            usersList = groupDataRepository.findByStateCodeAndEmployed(users.getStateCode(), users.getEmployed().toLowerCase());

            for (Users getUsers : usersList) {
                EmployedDetailsDTO employedDetailsCount = EmployedDetailsDTO.builder()
                        .name((getUsers.getFirstName() + " " + getUsers.getLastName()).trim())
                        .userId("" + userId)
                        .familyId(getUsers.getFamilyId())
                        .aadharNo(getUsers.getAadharNo())
                        .build();

                individualMemberList.add(employedDetailsCount);
            }
        }
        return individualMemberList;

    }

    @Override
    public List<SchemesEnrolledDTO> getListOfSchemesEnrolled(Users users) {


        if (users.getStateCode().equals("S01")) {

            List<SchemesEnrolledDTO> enrolledList = new ArrayList<>();
            SchemesEnrolledDTO enrolledDTO = SchemesEnrolledDTO.builder()
                    .schemeName("Atul Pension Yojana")
                    .schemeId("232323")
                    .population("23233")
                    .build();

            SchemesEnrolledDTO enrolledDTO2 = SchemesEnrolledDTO.builder()
                    .schemeName("Ayushman Bharat Yojana")
                    .schemeId("232324")
                    .population("23234")
                    .build();

            SchemesEnrolledDTO enrolledDTO3 = SchemesEnrolledDTO.builder()
                    .schemeName("radhan Mantri Awas yojana")
                    .schemeId("232325")
                    .population("23239")
                    .build();

            SchemesEnrolledDTO enrolledDTO4 = SchemesEnrolledDTO.builder()
                    .schemeName("Swamitva Yojana")
                    .schemeId("232326")
                    .population("23236")
                    .build();

            enrolledList.add(enrolledDTO);
            enrolledList.add(enrolledDTO2);
            enrolledList.add(enrolledDTO3);
            enrolledList.add(enrolledDTO4);

            return enrolledList;
        } else {
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<IndividualMemberDTO> getUserDataBySchemeEnrolled(Users users) {

        List<IndividualMemberDTO> finalEnrolledList = new ArrayList<>();
        IndividualMemberDTO enrolledList_1 = IndividualMemberDTO.builder()
                .name("SK Shing")
                .userId("232323")
                .familyId("223232")
                .build();

        IndividualMemberDTO enrolledList_2 = IndividualMemberDTO.builder()
                .name("Ram Shing")
                .userId("2323255")
                .familyId("223290")
                .build();

        IndividualMemberDTO enrolledList_3 = IndividualMemberDTO.builder()
                .name("Ankit")
                .userId("232347")
                .familyId("223200")
                .build();

        IndividualMemberDTO enrolledList_4 = IndividualMemberDTO.builder()
                .name("Ali Shing")
                .userId("232335")
                .familyId("223267")
                .build();

        IndividualMemberDTO enrolledList_5 = IndividualMemberDTO.builder()
                .name("Rajesh Shing")
                .userId("2323225")
                .familyId("223278")
                .build();

        if (users.getStateCode() != null) {
            if (users.getStateCode().equals("H01")) {
                finalEnrolledList.add(enrolledList_1);
                finalEnrolledList.add(enrolledList_2);
                finalEnrolledList.add(enrolledList_3);
                finalEnrolledList.add(enrolledList_4);
                finalEnrolledList.add(enrolledList_5);
                return finalEnrolledList;
            }

        } else if (users.getDistrictCode() != null) {
            if (users.getDistrictCode().equals("C01")) {
                finalEnrolledList.add(enrolledList_1);
                finalEnrolledList.add(enrolledList_3);
                finalEnrolledList.add(enrolledList_4);
                finalEnrolledList.add(enrolledList_5);
                return finalEnrolledList;
            }
        } else if (users.getTehsilCode() != null) {
            if (users.getTehsilCode().equals("S01")) {
                finalEnrolledList.add(enrolledList_3);
                finalEnrolledList.add(enrolledList_4);
                return finalEnrolledList;
            }
        } else if (users.getBlockCode() != null) {
            if (users.getBlockCode().equals("A01")) {
                finalEnrolledList.add(enrolledList_3);
                finalEnrolledList.add(enrolledList_4);
                return finalEnrolledList;
            }
        } else if (users.getVillageCode() != null) {
            if (users.getVillageCode().equals("B01")) {
                finalEnrolledList.add(enrolledList_4);
                return finalEnrolledList;
            }
        } else if (users.getCaste() != null) {
            if (users.getCaste().equals("SC")) {
                finalEnrolledList.add(enrolledList_4);
                return finalEnrolledList;
            }

        } else {
            throw new NoSuchElementException();
        }
        return null;
    }

    @Override
    public List<VmulyankanaResponseDTO> getVmulyankaList(Users users) {

        List<VmulyankanaResponseDTO> vMulList = new ArrayList<>();


        VmulyankanaResponseDTO vMulData_1 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("56%")
                .familyName("Amit Sharma Family")
                .familyId("23344")
                .familyCounts(5)
                .build();

        VmulyankanaResponseDTO vMulData_2 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("78%")
                .familyName("SK Shing Family")
                .familyId("23345")
                .familyCounts(3)
                .build();

        VmulyankanaResponseDTO vMulData_3 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("65%")
                .familyName("Mahinder Shing Family")
                .familyId("23346")
                .familyCounts(10)
                .build();

        VmulyankanaResponseDTO vMulData_4 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("76%")
                .familyName("Narishma Patel Family")
                .familyId("23347")
                .familyCounts(4)
                .build();

        VmulyankanaResponseDTO vMulData_5 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("89%")
                .familyName("JW Shing Family")
                .familyId("23348")
                .familyCounts(7)
                .build();

        VmulyankanaResponseDTO vMulData_6 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("70%")
                .familyName("Tulsi Das Gupta Family")
                .familyId("23349")
                .familyCounts(5)
                .build();

        VmulyankanaResponseDTO vMulData_7 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("60%")
                .familyName("Vinod Patel Family")
                .familyId("23350")
                .familyCounts(3)
                .build();

        VmulyankanaResponseDTO vMulData_8 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("57%")
                .familyName("Ramlal Yadav Family")
                .familyId("23351")
                .familyCounts(7)
                .build();

        VmulyankanaResponseDTO vMulData_9 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("72%")
                .familyName("Vinod Patel Family")
                .familyId("23352")
                .familyCounts(2)
                .build();

        VmulyankanaResponseDTO vMulData_10 = VmulyankanaResponseDTO.builder()
                .vMulyankaScore("56%")
                .familyName("N.K.Rao Family")
                .familyId("23353")
                .familyCounts(8)
                .build();

        if (users.getStateCode() != null) {
            if (users.getStateCode().equals("H01")) {
                vMulList.add(vMulData_1);
                vMulList.add(vMulData_2);
                vMulList.add(vMulData_3);
                vMulList.add(vMulData_4);
                vMulList.add(vMulData_5);
                vMulList.add(vMulData_6);
                vMulList.add(vMulData_7);
                vMulList.add(vMulData_8);
                vMulList.add(vMulData_9);
                vMulList.add(vMulData_10);

                return vMulList;
            }
        } else if (users.getDistrictCode() != null) {
            if (users.getDistrictCode().equals("C01")) {

                vMulList.add(vMulData_3);
                vMulList.add(vMulData_4);
                vMulList.add(vMulData_5);
                vMulList.add(vMulData_6);
                vMulList.add(vMulData_7);
                vMulList.add(vMulData_8);
                vMulList.add(vMulData_9);
                vMulList.add(vMulData_10);

                return vMulList;
            }
        } else if (users.getTehsilCode() != null) {
            if (users.getTehsilCode().equals("S01")) {

                vMulList.add(vMulData_5);
                vMulList.add(vMulData_6);
                vMulList.add(vMulData_7);
                vMulList.add(vMulData_8);
                vMulList.add(vMulData_9);
                vMulList.add(vMulData_10);

                return vMulList;
            }
        } else if (users.getBlockCode() != null) {
            if (users.getBlockCode().equals("A01")) {

                vMulList.add(vMulData_7);
                vMulList.add(vMulData_8);
                vMulList.add(vMulData_9);
                vMulList.add(vMulData_10);

                return vMulList;
            }
        } else if (users.getVillageCode() != null) {
            if (users.getVillageCode().equals("B01")) {

                vMulList.add(vMulData_9);
                vMulList.add(vMulData_10);

                return vMulList;
            }
        } else if (users.getCaste() != null) {
            if (users.getCaste().equals("SC")) {

                vMulList.add(vMulData_9);
                vMulList.add(vMulData_10);

                return vMulList;
            }
        } else {
            throw new NoSuchElementException();
        }


        return null;
    }


}
