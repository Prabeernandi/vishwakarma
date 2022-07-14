package com.burwasolution.vishwakarma.service_impl.impl.groupData;

import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedDetailsDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualMemberDTO;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.TableDataFilter;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.domains.entity.headerFilter.CardDataFilter;
import com.burwasolution.vishwakarma.reprository.groupData.GroupDataRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.groupData.GroupDataService;
import com.google.common.collect.ArrayListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.*;

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
                usersList = groupDataRepository.findByStateCodeAndAgeBarAndGender(users.getStateCode(), users.getAgeBar().toLowerCase(), users.getGender().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByStateCodeAndAgeBar(users.getStateCode(), users.getAgeBar().toLowerCase());
            } else {

                usersList = groupDataRepository.findByStateCode(users.getStateCode());
            }
            return getFamilyList(usersList);


        } else if (users.getDistrictCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByDistrictCodeAndAgeBarAndGender(users.getDistrictCode(), users.getAgeBar().toLowerCase(), users.getGender().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByDistrictCodeAndAgeBar(users.getDistrictCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByDistrictCode(users.getDistrictCode());
            }
            return getFamilyList(usersList);
        } else if (users.getTehsilCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByTehsilCodeAndAgeBarAndGender(users.getTehsilCode(), users.getAgeBar().toLowerCase(), users.getGender().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByTehsilCodeAndAgeBar(users.getTehsilCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByTehsilCode(users.getTehsilCode());
            }
            return getFamilyList(usersList);
        } else if (users.getBlockCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByBlockCodeAndAgeBarAndGender(users.getBlockCode(), users.getAgeBar().toLowerCase(), users.getGender().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByBlockCodeAndAgeBar(users.getBlockCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByBlockCode(users.getBlockCode());
            }
            return getFamilyList(usersList);
        } else if (users.getVillageCode() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByVillageCodeAndAgeBarAndGender(users.getVillageCode(), users.getAgeBar().toLowerCase(), users.getGender().toLowerCase());

            } else if (users.getAgeBar() != null) {
                usersList = groupDataRepository.findByVillageCodeAndAgeBar(users.getVillageCode(), users.getAgeBar().toLowerCase());
            } else {
                usersList = groupDataRepository.findByVillageCode(users.getVillageCode());
            }
            return getFamilyList(usersList);
        } else if (users.getCaste() != null) {
            if (users.getGender() != null) {
                usersList = groupDataRepository.findByCasteAndAgeBarAndGender(users.getCaste(), users.getAgeBar().toLowerCase(), users.getGender().toLowerCase());

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

    public Long getFamilyCounts(List<Users> users) {

        LinkedHashSet<String> counts = new LinkedHashSet<>();
        for (Users familyId : users) {
            counts.add(familyId.getFamilyId());
        }
        long size = counts.size();

        return size;
    }

    public Long getEmployedCounts(List<Users> users) {

        long size = 0;
        ArrayList<String> list = new ArrayList<>();
        for (Users getEmployed : users) {
            if (getEmployed.getEmployedCode() != null) {
                list.add(getEmployed.getEmployedCode());
            }

            size = list.size();
        }

        return size;
    }

    public Long getSchemeCounts(List<Users> users) {
        long size = 0;
        ArrayList<String> list = new ArrayList<>();
        for (Users getSchemes : users) {
            if (getSchemes.getGovtSchemeEnrolled() != null) {
                list.add(getSchemes.getGovtSchemeEnrolled());
            }
        }
        size = list.size();

        return size;
    }


    @Override
    @Deprecated
    public CardDataFilter findByCardDataFilter(CardDataFilterDTO cardDataFilter) {

        String stateCode = null, districtCode = null, tehsilCode = null, blockCode = null,
                villageCode = null, category = null, ageBar = null, gender = null,
                employedCode = null, schemeCode = null;

        List<Users> usersList = new ArrayList<>();

        stateCode = cardDataFilter.getStateCode();
        districtCode = cardDataFilter.getDistrictCode();
        tehsilCode = cardDataFilter.getTehsilCode();
        blockCode = cardDataFilter.getBlockCode();
        villageCode = cardDataFilter.getVillageCode();
        category = cardDataFilter.getCategoryCode();
        ageBar = cardDataFilter.getAgeBar();
        gender = cardDataFilter.getGender();
        employedCode = cardDataFilter.getEmployedCode();
        schemeCode = cardDataFilter.getSchemeCode();
        CardDataFilter cardDataFilter2 = new CardDataFilter();
        if (stateCode != null) {

            if (villageCode != null) {

                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBar(villageCode, ageBar);
                    log.error("size " + usersList.size());
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGender(villageCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                        usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGenderAndEmployedCode(villageCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(villageCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByVillageCode(villageCode);
                }

            } else if (blockCode != null) {
                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBar(blockCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGender(blockCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGenderAndEmployedCode(blockCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(blockCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByBlockCode(blockCode);
                }
            } else if (tehsilCode != null) {
                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBar(tehsilCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGender(tehsilCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCode(tehsilCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(tehsilCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByTehsilCode(tehsilCode);
                }

            } else if (districtCode != null) {
                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBar(districtCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGender(districtCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCode(districtCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(districtCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByDistrictCode(districtCode);
                }
            } else {
                usersList = usersRepository.findAllByStateCode(stateCode);
            }


            cardDataFilter2 = CardDataFilter.builder()
                    .stateCode(cardDataFilter.getStateCode())
                    .districtCode(cardDataFilter.getDistrictCode())
                    .tehsilCode(cardDataFilter.getTehsilCode())
                    .blockCode(cardDataFilter.getBlockCode())
                    .villageCode(cardDataFilter.getVillageCode())
                    .categoryCode(cardDataFilter.getCategoryCode())
                    .families(getFamilyCounts(usersList).longValue())
                    .employed(getEmployedCounts(usersList).longValue())
                    .gender(cardDataFilter.getGender())
                    .employedCode(cardDataFilter.getEmployedCode())
                    .govtSchemesEnrolled(getSchemeCounts(usersList).longValue())
                    .vMulScore(177889)
                    .ageBar(cardDataFilter.getAgeBar())
                    .build();

        } else {
            throw new HttpMessageNotReadableException(cardDataFilter.getStateCode());
        }

        return cardDataFilter2;
    }

    @Override
    public TableDataFilter findByTableDataFilter(TableDataFilter tableDataFilter) {

        String stateCode = null, districtCode = null, tehsilCode = null, blockCode = null,
                villageCode = null, category = null, ageBar = null, gender = null,
                employedCode = null, schemeCode = null;

        List<Users> usersList = new ArrayList<>();

        stateCode = tableDataFilter.getStateCode();
        districtCode = tableDataFilter.getDistrictCode();
        tehsilCode = tableDataFilter.getTehsilCode();
        blockCode = tableDataFilter.getBlockCode();
        villageCode = tableDataFilter.getVillageCode();
        category = tableDataFilter.getCategoryCode();
        ageBar = tableDataFilter.getAgeBar();
        gender = tableDataFilter.getGender();
        employedCode = tableDataFilter.getEmployedCode();
        schemeCode = tableDataFilter.getSchemeCode();
        TableDataFilter tableDataFilter2 = new TableDataFilter();


        if (stateCode != null) {

            if (villageCode != null) {

                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBar(villageCode, ageBar);
                    log.error("size " + usersList.size());
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGender(villageCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGenderAndEmployedCode(villageCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(villageCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByVillageCode(villageCode);
                }

            } else if (blockCode != null) {
                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBar(villageCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGender(villageCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGenderAndEmployedCode(villageCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(villageCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByBlockCode(blockCode);
                }
            } else if (tehsilCode != null) {
                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBar(tehsilCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGender(tehsilCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCode(tehsilCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(tehsilCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByTehsilCode(tehsilCode);
                }

            } else if (districtCode != null) {
                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBar(districtCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGender(districtCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCode(districtCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(districtCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByDistrictCode(districtCode);
                }
            } else {
                usersList = usersRepository.findAllByStateCode(stateCode);
            }

            Map<String, Object> familyCounts = new HashMap<>();
            familyCounts.put("name", "Family");
            familyCounts.put("count", getFamilyCounts(usersList).longValue());

            Map<String, Object> employedCounts = new HashMap<>();
            employedCounts.put("name", "Employed");
            employedCounts.put("count", getEmployedCounts(usersList).longValue());

            Map<String, Object> schemeCounts = new HashMap<>();
            schemeCounts.put("name", "govtSchemeEnrolled");
            schemeCounts.put("count", getSchemeCounts(usersList).longValue());

            Map<String, Object> vMulCounts = new HashMap<>();
            vMulCounts.put("name", "vMulyankana");
            vMulCounts.put("count", 17765);

            ArrayListMultimap<String, Object> addAllCounts = ArrayListMultimap.create();
            addAllCounts.put("counts", familyCounts);
            addAllCounts.put("counts", employedCounts);
            addAllCounts.put("counts", schemeCounts);
            addAllCounts.put("counts", vMulCounts);

            tableDataFilter2 = TableDataFilter.builder()
                    .stateCode(tableDataFilter.getStateCode())
                    .districtCode(tableDataFilter.getDistrictCode())
                    .tehsilCode(tableDataFilter.getTehsilCode())
                    .blockCode(tableDataFilter.getBlockCode())
                    .villageCode(tableDataFilter.getVillageCode())
                    .categoryCode(tableDataFilter.getCategoryCode())
                    .ageBar(tableDataFilter.getAgeBar())
                    .gender(tableDataFilter.getGender())
                    .employedCode(tableDataFilter.getEmployedCode())
                    .schemeCode(tableDataFilter2.getSchemeCode())
                    .counts(addAllCounts.get("counts"))
                    .build();
            return tableDataFilter2;

        } else {
            throw new HttpMessageNotReadableException(tableDataFilter2.getStateCode());
        }


    }


}
