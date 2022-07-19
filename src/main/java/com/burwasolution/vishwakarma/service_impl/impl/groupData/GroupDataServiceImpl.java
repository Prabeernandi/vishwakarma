package com.burwasolution.vishwakarma.service_impl.impl.groupData;

import com.burwasolution.vishwakarma.config.utils.ApplicationConstant;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedDetailsDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.EmployedType;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.FamilyListDTO;
import com.burwasolution.vishwakarma.domains.dto.response.groupData.IndividualMemberDTO;
import com.burwasolution.vishwakarma.domains.dto.response.headerFilter.CardDataFilterDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.TableDataFilter;
import com.burwasolution.vishwakarma.domains.entity.basic.Users;
import com.burwasolution.vishwakarma.domains.entity.headerFilter.CardDataFilter;
import com.burwasolution.vishwakarma.reprository.groupData.GroupDataRepository;
import com.burwasolution.vishwakarma.reprository.users.ImageUploadRepository;
import com.burwasolution.vishwakarma.reprository.users.UsersRepository;
import com.burwasolution.vishwakarma.service_impl.service.groupData.GroupDataService;
import com.google.common.collect.ArrayListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class GroupDataServiceImpl implements GroupDataService, ApplicationConstant {

    private final GroupDataRepository groupDataRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private ImageUploadRepository imageUploadRepository;

    String stateCode = null, districtCode = null, tehsilCode = null, blockCode = null,
            villageCode = null, category = null, ageBar = null, gender = null,
            employedCode = null, schemeCode = null, name = null;

    List<Users> usersList = new ArrayList<>();

    @Autowired
    public GroupDataServiceImpl(GroupDataRepository groupDataRepository, UsersRepository usersRepository,
                                ModelMapper modelMapper, ImageUploadRepository imageUploadRepository) {
        this.groupDataRepository = groupDataRepository;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.imageUploadRepository = imageUploadRepository;
    }

    private List<FamilyListDTO> getFamilyList(CardDataFilterDTO cardDataFilter) {
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
        List<CardDataFilter> cardDataFilterList = new ArrayList<>();

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

                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBar(stateCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGender(stateCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCode(stateCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(stateCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByStateCode(stateCode);
                }
            }


            ArrayList<String> list = new ArrayList<>();
            FamilyListDTO familyListDTO = new FamilyListDTO();
            List<FamilyListDTO> familyListDTOS = new ArrayList<>();
            List<Users> getHeadList = new ArrayList<>();
            for (Users usersHeadList : usersList) {
                if (!list.contains(usersHeadList.getFamilyId())) {
                    list.add(usersHeadList.getFamilyId());//

                }
            }
            log.error("Family Id " + list.size());

            String[] list2 = list.parallelStream().toArray(String[]::new);
            log.error("Family Id " + list2.length);
//            String[] list2 = {"744201", "744061", "74406/11", "74406/21", "74406/31", "744071", "74407/11", "74407/21", "74407/31", "74407/51", "744081", "74408/11", "74408/21", "744091", "744101", "744111", "74411/11", "74411/21", "74411क1", "744121", "744131", "744141", "744151", "744161", "74416/11", "744171", "744181", "74418/11", "74418/21", "74418/31", "74419/11", "744211", "744221", "744231", "744241", "744251", "744261", "744271", "744281", "744291", "744301", "744311", "74431/11", "74431/21", "744321", "74432/11", "74432/21", "74432/31", "74432/41", "744331", "744341", "74434/11", "74434/21", "744351", "74435/11", "74435/21", "74435/31", "74४३५/३1", "744361", "744371", "74437/11", "74437/21", "74437/31", "74437/41", "744381", "74438/11", "74438/21", "74438/31", "744391", "744401", "74440/11", "74440/21", "744411", "744421", "744431", "74443/11", "74443/21", "744441", "74444/11", "74444/21", "744451", "74445/11", "744461", "74446/11", "744471", "74447/11", "74447/21", "744481", "744491", "744501", "744511", "744521", "744531", "744541", "744561", "744571", "744581", "744591", "744601", "74460/11", "744611", "744621", "744631", "744641", "744661", "744671", "744681", "74468/11", "744691", "74469/11", "744701", "744711", "74471क1", "744721", "74472/11", "74472/21", "744731", "74473क1", "744741", "744751", "744761", "74476/11", "74476/21", "744771", "74477/11", "74477/21", "74477/31", "74477/41", "744781", "744791", "744801", "74480/11", "74480/21", "74480/31", "744811", "744821", "744831", "744841", "744851", "74485/11", "74485/21", "74485/31", "744861", "744871", "744881", "744891", "74489/11", "74489/21", "74489/31", "74489/41", "74489/51", "744901", "74490/11", "74490/21", "74490/31", "744911", "744921", "744931", "744941", "744951", "744961", "744981", "744991", "74499/11", "745001", "745011", "745021", "74502/11", "74502/21", "745031", "745041", "74504/11", "74504/21", "745051", "745061", "74506क1", "74392", "741162", "742662", "742842", "742902", "743092", "743312", "743322", "743332", "743342", "74334/12", "743352", "743362", "743372", "743382", "743392", "743402", "743412", "74341/12", "743422", "743432", "743442", "743462", "743472", "743482", "743492", "743502", "74350/12", "743512", "743522", "743532", "74353/12", "743562", "743572", "743592", "743602", "743612", "743622", "743632", "74363/12", "74363/22", "74363/32", "74३६३/३2", "743642", "743652", "743662", "743672", "743682", "743692", "743702", "743712", "743722", "74372/12", "743732", "743742", "743762", "743772", "743782", "743792", "743802", "74380/12", "743812", "74381/!2", "743822", "74382/12", "743832", "743842", "743852", "74385/12", "743862", "743872", "743882", "743892", "743902", "74390/12", "743912", "743922", "743932", "743972", "743982", "743992", "744002", "744012", "744022", "744032", "74403/12", "744042", "744052", "74405/12", "743621", "743421", "743331", "743911", "743371", "743681", "74405/11", "743081", "743851", "743311", "743881", "743701", "743321", "743671", "743721", "743661", "74363/31", "7551", "75521", "752381", "75321/11", "753251", "75325/11", "753611", "754691", "75469/11", "75463/31", "755011", "755021", "755071", "755081", "755091", "755101", "75510/11", "755111", "755121", "755131", "755141", "755151", "755161", "755171", "75517/11", "755181", "755191", "755201", "755211", "755221", "755231", "755241", "755251", "75525/11", "75525/21", "75525/31", "755261", "755271", "755281", "755291", "755301", "755311", "755321", "755331", "75533/11", "75533/21", "755341", "75534/11", "755351", "755361", "755371", "75537/21", "755381", "755391", "755401", "755411", "755421", "755431", "755441", "755451", "75545/11", "755461", "755471", "75547/11", "75547/21", "75547/31", "755481", "755491", "755501", "755511", "755521", "755531", "755551", "755561", "75556/11", "75556/21", "75556/31", "755571", "755581", "755591", "755601", "755611", "755621", "755631", "755641", "755651", "755661", "755671", "755681", "755691", "755701", "755711", "755721", "75572/11", "75572/21", "755731", "75573/11", "75573/21", "755741", "755751", "75575/11", "755761", "75576/11", "755771", "755791", "75579/11", "755801", "75580/11", "75580/21"};
            for (String list3 : list2) {
                getHeadList = usersRepository.findAllByFamilyId(list3);

                for (Users setHeadList : getHeadList) {

                    familyListDTO = FamilyListDTO.builder()
                            .name(setHeadList.getFullName() + " Family")
                            .familyId(setHeadList.getFamilyId())
                            .members(getHeadList.size())
                            .stateCode(setHeadList.getStateCode())
                            .districtCode(setHeadList.getDistrictCode())
                            .build();
                }

                familyListDTOS.add(familyListDTO);
            }

            return familyListDTOS;
        } else {
            throw new HttpMessageNotReadableException(cardDataFilter.getStateCode());
        }

    }


    @Override
    public List<FamilyListDTO> findFamilyList(CardDataFilterDTO cardDataFilter) {

        return getFamilyList(cardDataFilter);
    }


    @Override
    public List<IndividualMemberDTO> getFamilyMemberDetails(String familyId) {

        List<Users> usersList = usersRepository.findAllByFamilyId(familyId);
        String rationUrl = "", pmKissanUrl = "", pmAwaasUrl = "";
        List<IndividualMemberDTO> familyMemberList = new ArrayList<>();

        int userId = (int) (Math.random() * (1000000 - 100000)) + 100000;
        for (Users usersListDetails : usersList) {

            if (usersListDetails.getRationCardNumber() != null) {
                rationUrl = baseUrl + "icon/";
            }
            if (usersListDetails.isHasPradhanMantriAwaasYojna()) {
                pmAwaasUrl = baseUrl + "icon/Pradhan-Mantri-Aawas-Yojna.png";
            }
            if (usersListDetails.isPMKisaanEnabled()) {
                pmKissanUrl = baseUrl + "icon/PM-Kisan.png";
            } else {

            }

            IndividualMemberDTO individualList = IndividualMemberDTO.builder()
                    .name(usersListDetails.getFullName())
                    .userId("" + userId)
                    .familyId(usersListDetails.getFamilyId())
                    .aadharNo(usersListDetails.getAadharNo())
                    .address(usersListDetails.getAddress())
                    .dateOfBirth("" + usersListDetails.getDateOfBirth())
                    .employed(usersListDetails.getEmployed())
                    .stateName(usersListDetails.getStateName())
                    .districtName(usersListDetails.getDistrictName())
                    .tehsilName(usersListDetails.getTehsilName())
                    .villageName(usersListDetails.getVillageName())
                    .voterResidence(usersListDetails.getHouseNumber())
                    .income(usersListDetails.getIncome() == 0 ? "Not Available" : "" + usersListDetails.getIncome())
                    .age(usersListDetails.getAge())
                    .vmulyankana(usersListDetails.getVmulyankana() == 0 ? "Not Available" : "" + usersListDetails.getVmulyankana())
                    .rationCardImgUrl(rationUrl.trim() == null ? "" : rationUrl.trim())
                    .pmAwaasImgUrl(pmAwaasUrl.trim() == null ? "" : pmAwaasUrl.trim())
                    .pmkissanImgUrl(pmKissanUrl.trim() == null ? "" : pmKissanUrl.trim())
                    .isManrekaEnabled(usersListDetails.isManrekaEnabled())
                    .voterId(usersListDetails.getVoterId())
                    .panCardNo(usersListDetails.getPanCardNo() == null ? "Not Available" : usersListDetails.getPanCardNo())
                    .epf_nps(usersListDetails.getEpf_nps() == null ? "Not Available" : "" + usersListDetails.getEpf_nps())
                    .gramPanchayat(usersListDetails.getGramPanchayat() == null ? "Not Available" : "" + usersListDetails.getGramPanchayat())
                    .mobileNumber(usersListDetails.getMobileNumber() == null ? "Not Available" : "" + usersListDetails.getMobileNumber())
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

    @Deprecated
    public CardDataFilter getFinalCardData(String type, CardDataFilterDTO cardDataFilter) {

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
        List<CardDataFilter> cardDataFilterList = new ArrayList<>();

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

                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBar(stateCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGender(stateCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCode(stateCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(stateCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByStateCode(stateCode);
                }
            }

            switch (type) {
                case "all":
                    cardDataFilter2 = getBasicCardFilterCounts(usersList, cardDataFilter);
                    break;

                case "emp":
                    cardDataFilter2 = getEmployedTypes(usersList, cardDataFilter);
                    break;


            }


        } else {
            throw new HttpMessageNotReadableException(cardDataFilter.getStateCode());
        }

        return cardDataFilter2;
    }


    public CardDataFilter getBasicCardFilterCounts(List<Users> usersList, CardDataFilterDTO cardDataFilter) {
        CardDataFilter cardDataFilter2 = CardDataFilter.builder()
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
        return cardDataFilter2;
    }


    public CardDataFilter getEmployedTypes(List<Users> usersList, CardDataFilterDTO cardDataFilter) {

        List<Users> getEmployedDetails = usersRepository.findAllByEmployed();

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> getList = new ArrayList<>();
        for (Users arr : getEmployedDetails) {


            if (!list.contains(arr.getGovtSchemeEnrolled())) {
                list.add(arr.getGovtSchemeEnrolled());
            }

        }
        String[] list2 = list.parallelStream().toArray(String[]::new);
        for (String list3 : list2) {
            String[] removeComma = list3.split(",");

            for (String secondList : removeComma) {
                if (!getList.contains(secondList)) {
                    getList.add(secondList.trim());
                    getList.removeAll(Collections.singleton(""));

                }
            }
        }
        String[] list4 = getList.parallelStream().toArray(String[]::new);


        CardDataFilter cardDataFilter2 = CardDataFilter.builder()
                .build();

        return cardDataFilter2;

    }

    @Override
    public CardDataFilter findByCardDataFilter(CardDataFilterDTO cardDataFilter) {
        String type = "all";
        return getFinalCardData(type, cardDataFilter);
    }

    @Override
    public List<EmployedType> getListOfEmployedTypes(EmployedType cardDataFilter){

        List<Users> usersList = new ArrayList<>();
        ArrayList<String> listOfEmployed = new ArrayList<>();
        ArrayList<String> finalEmployedList = new ArrayList<>();
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
        EmployedType cardDataFilter2 = new EmployedType();
        List<EmployedType> cardDataFilterList = new ArrayList<>();

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

                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBar(stateCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGender(stateCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCode(stateCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(stateCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByStateCode(stateCode);
                }
            }


            for (Users arr : usersList) {


                if (!listOfEmployed.contains(arr.getEmployed())) {
                    listOfEmployed.add(arr.getEmployed());
                }

            }
            String[] list2 = listOfEmployed.parallelStream().toArray(String[]::new);

            for (String list3 : list2) {
                String[] removeComma = list3.split(",");

                for (String secondList : removeComma) {
                    if (!finalEmployedList.contains(secondList)) {
                        finalEmployedList.add(secondList.trim());
                        finalEmployedList.removeAll(Collections.singleton(""));
                    }
                }
            }
            String[] list4 = finalEmployedList.parallelStream().toArray(String[]::new);

            String employedId = "";
            for (String list5 : list4) {

                if (list5.equals("Farmer")) {
                    employedId = "fr01";
                }
                if (list5.equals("Daily Worker")) {
                    employedId = "dw01";
                }
                if (list5.equals("Artisan")) {
                    employedId = "ar01";
                }


                cardDataFilter2 = EmployedType.builder()
                        .name(list5)
                        .stateCode(cardDataFilter.getStateCode())
                        .districtCode(cardDataFilter.getDistrictCode())
                        .tehsilCode(cardDataFilter.getTehsilCode())
                        .blockCode(cardDataFilter.getBlockCode())
                        .villageCode(cardDataFilter.getVillageCode())
                        .categoryCode(cardDataFilter.getCategoryCode())
                        .gender(cardDataFilter.getGender())
                        .employedCode(employedId == null ? "" : employedId)
                        .ageBar(cardDataFilter.getAgeBar())
                        .build();
                cardDataFilterList.add(cardDataFilter2);
            }
        } else {
            throw new HttpMessageNotReadableException(cardDataFilter.getStateCode());
        }
        return cardDataFilterList;
    }

    @Override
    public List<EmployedType> getSchemeTypeList(EmployedType cardDataFilter) {
        List<Users> usersList = new ArrayList<>();
        ArrayList<String> listOfEmployed = new ArrayList<>();
        ArrayList<String> finalEmployedList = new ArrayList<>();
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
        EmployedType cardDataFilter2 = new EmployedType();
        List<EmployedType> cardDataFilterList = new ArrayList<>();

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

                if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBar(stateCode, ageBar);
                } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGender(stateCode, ageBar, gender);
                } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCode(stateCode, ageBar, gender, employedCode);
                } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                    usersList = usersRepository.findAllByStateCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(stateCode, ageBar, gender, employedCode, schemeCode);
                } else {
                    usersList = usersRepository.findAllByStateCode(stateCode);
                }
            }

            for (Users arr : usersList) {


                if (!listOfEmployed.contains(arr.getGovtSchemeEnrolled())) {
                    listOfEmployed.add(arr.getGovtSchemeEnrolled());
                }

            }
            String[] list2 = listOfEmployed.parallelStream().toArray(String[]::new);
            for (String list3 : list2) {
                String[] removeComma = list3.split(",");

                for (String secondList : removeComma) {
                    if (!finalEmployedList.contains(secondList)) {
                        finalEmployedList.add(secondList.trim());
                        finalEmployedList.removeAll(Collections.singleton(""));

                    }
                }
            }
            String[] list4 = finalEmployedList.parallelStream().toArray(String[]::new);
            String schemeCodes = "";
            for (String list5 : list4) {
                if (list5.equals("RationCard")) {
                    schemeCodes = "RC01";
                }
                if (list5.equals("PMKisaanYojana")) {
                    schemeCodes = "RMKY01";
                }
                if (list5.equals("PMAwaasYojana")) {
                    schemeCodes = "PMAY01";
                }

                cardDataFilter2 = EmployedType.builder()
                        .name(list5)
                        .stateCode(cardDataFilter.getStateCode())
                        .districtCode(cardDataFilter.getDistrictCode())
                        .tehsilCode(cardDataFilter.getTehsilCode())
                        .blockCode(cardDataFilter.getBlockCode())
                        .villageCode(cardDataFilter.getVillageCode())
                        .categoryCode(cardDataFilter.getCategoryCode())
                        .gender(cardDataFilter.getGender())
                        .employedCode(schemeCodes == null ? "" : schemeCodes)
                        .ageBar(cardDataFilter.getAgeBar())
                        .build();
                cardDataFilterList.add(cardDataFilter2);

            }

        }else {
            throw new HttpMessageNotReadableException(cardDataFilter.getStateCode());
        }

        return cardDataFilterList;

    }


    public List<TableDataFilter> getFinalFilterData(TableDataFilter tableDataFilter) {

        TableDataFilter tableDataFilter2 = new TableDataFilter();
        List<Users> usersList = new ArrayList<>();
        ArrayList<String> getList = new ArrayList<>();
        String[] list2 = null;
        List<TableDataFilter> filterList = new ArrayList<>();

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

                name = "Gen";

                filterList.add(getFilteredCounts(usersList, tableDataFilter, name));

            } else if (blockCode != null) {

                usersList = usersRepository.findAllByBlockCode(blockCode);


                for (Users getUniqueVillage : usersList) {
                    if (!getList.contains(getUniqueVillage.getVillageCode())) {
                        getList.add(getUniqueVillage.getVillageCode());

                        log.error("First Log " + getList);
                    }

                }

                list2 = getList.parallelStream().toArray(String[]::new);

                for (String list3 : list2) {
                    if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByVillageCodeAndAgeBar(list3, ageBar);
                    } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGender(list3, ageBar, gender);
                    } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                        usersList = usersRepository.findAllByVillageCodeAndAgeBarAndGenderAndEmployedCode(list3, ageBar, gender, employedCode);
                    } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                        usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(list3, ageBar, gender, employedCode, schemeCode);
                    } else {
                        usersList = usersRepository.findAllByVillageCode(list3);
                    }
                    for (Users getName : usersList) {
                        name = getName.getVillageName();
                    }
                    filterList.add(getFilteredCounts(usersList, tableDataFilter, name));
                }


            } else if (tehsilCode != null) {
                usersList = usersRepository.findAllByTehsilCode(tehsilCode);

                for (Users getUniqueBlock : usersList) {
                    if (!getList.contains(getUniqueBlock.getBlockCode())) {
                        getList.add(getUniqueBlock.getBlockCode());
                        log.error("First Log " + getList);
                    }

                }

                list2 = getList.parallelStream().toArray(String[]::new);

                for (String list3 : list2) {
                    if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByBlockCodeAndAgeBar(list3, ageBar);
                    } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGender(list3, ageBar, gender);
                    } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                        usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGenderAndEmployedCode(list3, ageBar, gender, employedCode);
                    } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                        usersList = usersRepository.findAllByBlockCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(list3, ageBar, gender, employedCode, schemeCode);
                    } else {
                        usersList = usersRepository.findAllByBlockCode(list3);
                    }

                    for (Users getName : usersList) {
                        name = getName.getBlockName();
                    }
                    filterList.add(getFilteredCounts(usersList, tableDataFilter, name));
                }

            } else if (districtCode != null) {

                usersList = usersRepository.findAllByDistrictCode(districtCode);

                for (Users getUniqueTehsil : usersList) {
                    if (!getList.contains(getUniqueTehsil.getTehsilCode())) {
                        getList.add(getUniqueTehsil.getTehsilCode());
                        log.error("First Log " + getList);
                    }

                }

                list2 = getList.parallelStream().toArray(String[]::new);

                for (String list3 : list2) {
                    if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByTehsilCodeAndAgeBar(list3, ageBar);
                    } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGender(list3, ageBar, gender);
                    } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                        usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCode(list3, ageBar, gender, employedCode);
                    } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                        usersList = usersRepository.findAllByTehsilCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(list3, ageBar, gender, employedCode, schemeCode);
                    } else {
                        usersList = usersRepository.findAllByTehsilCode(list3);
                    }
                    for (Users getName : usersList) {
                        name = getName.getTehsilName();
                    }
                    filterList.add(getFilteredCounts(usersList, tableDataFilter, name));
                }
            } else {
                usersList = usersRepository.findAllByStateCode(stateCode);
                for (Users getUniqueDistrict : usersList) {
                    if (!getList.contains(getUniqueDistrict.getDistrictCode())) {
                        getList.add(getUniqueDistrict.getDistrictCode());
                        log.error("First Log " + getList);
                    }

                    name = getUniqueDistrict.getDistrictName();
                }

                list2 = getList.parallelStream().toArray(String[]::new);
                for (String list3 : list2) {

                    if (ageBar != null && gender == null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByDistrictCodeAndAgeBar(list3, ageBar);
                    } else if (ageBar != null && gender != null && schemeCode == null && employedCode == null) {
                        usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGender(list3, ageBar, gender);
                    } else if (ageBar != null && gender != null && employedCode != null && schemeCode == null) {
                        usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCode(list3, ageBar, gender, employedCode);
                    } else if (ageBar != null && gender != null && schemeCode != null && employedCode != null) {
                        usersList = usersRepository.findAllByDistrictCodeAndAgeBarAndGenderAndEmployedCodeAndSchemeCode(list3, ageBar, gender, employedCode, schemeCode);
                    } else {
                        usersList = usersRepository.findAllByDistrictCode(list3);
                    }
                    for (Users getName : usersList) {
                        name = getName.getDistrictName();
                    }
                    filterList.add(getFilteredCounts(usersList, tableDataFilter, name));
                }

            }

        } else {
            throw new HttpMessageNotReadableException(tableDataFilter2.getStateCode());
        }


        return filterList;
    }

    public TableDataFilter getFilteredCounts(List<Users> usersList, TableDataFilter tableDataFilter, String name) {

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

        TableDataFilter tableDataFilter2 = TableDataFilter.builder()
                .stateCode(tableDataFilter.getStateCode())
                .districtCode(tableDataFilter.getDistrictCode())
                .tehsilCode(tableDataFilter.getTehsilCode())
                .blockCode(tableDataFilter.getBlockCode())
                .villageCode(tableDataFilter.getVillageCode())
                .categoryCode(tableDataFilter.getCategoryCode())
                .ageBar(tableDataFilter.getAgeBar())
                .name(name)
                .gender(tableDataFilter.getGender())
                .employedCode(tableDataFilter.getEmployedCode())
                .schemeCode(tableDataFilter.getSchemeCode())
                .counts(addAllCounts.get("counts"))
                .build();

        return tableDataFilter2;
    }

    @Override
    public List<TableDataFilter> findByTableDataFilter(TableDataFilter tableDataFilter) {

        List<TableDataFilter> usersList = getFinalFilterData(tableDataFilter);
        return usersList;

    }

}
