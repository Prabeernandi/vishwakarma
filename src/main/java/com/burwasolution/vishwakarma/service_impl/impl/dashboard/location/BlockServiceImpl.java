package com.burwasolution.vishwakarma.service_impl.impl.dashboard.location;

import com.burwasolution.vishwakarma.domains.dto.response.location.BlockCountDTO;
import com.burwasolution.vishwakarma.domains.dto.response.location.LocationLists;
import com.burwasolution.vishwakarma.domains.entity.location.Blocks;
import com.burwasolution.vishwakarma.reprository.location.BlockRepository;
import com.burwasolution.vishwakarma.service_impl.service.dashboard.BlockService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BlockServiceImpl(BlockRepository blockRepository, ModelMapper modelMapper) {
        this.blockRepository = blockRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Blocks> saveData(List<Blocks> blocks) {
        return blockRepository.saveAll(blocks);
    }

    @Override
    public List<Blocks> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public List<LocationLists> findByTehsilCode(String tehsilId) {

        List<Blocks> blocks = blockRepository.findyByTehsilCode(tehsilId);
        List<LocationLists> locationArray = new ArrayList<>();

        for (Blocks setBlocks : blocks) {
            LocationLists locationLists = LocationLists.builder()
                    .name(setBlocks.getName())
                    .displayName(setBlocks.getDisplayName())
                    .code(setBlocks.getBlockCode())
                    .build();
            locationArray.add(locationLists);
        }

        return locationArray;
    }

    @Override
    public BlockCountDTO getCountsInBlock(String blockId) {
        Blocks blocks = blockRepository.findByBlockCode(blockId);
        if (blockId != null) {
            long families, employed, govtSchemesEnrolled, vMulyankana;
            families = employed = govtSchemesEnrolled = vMulyankana = 0;

            if (blockId.equals("AK01")) {
                families = 34767;
                employed = 12456;
                govtSchemesEnrolled = 3416;
                vMulyankana = 13786;
            } else if (blockId.equals("AM01")) {
                families = 23768;
                employed = 15987;
                govtSchemesEnrolled = 2544;
                vMulyankana = 18097;

            } else if (blockId.equals("A01")) {
                families = 38998;
                employed = 22000;
                govtSchemesEnrolled = 9887;
                vMulyankana = 16776;

            }

            BlockCountDTO blockCountDTO = BlockCountDTO.builder()
                    .name(blocks.getName())
                    .blockCode(blocks.getBlockCode())
                    .families(families)
                    .employed(employed)
                    .govtSchemesEnrolled(govtSchemesEnrolled)
                    .vMulyankana(vMulyankana)
                    .build();
            return blockCountDTO;
        } else {
            throw new NoSuchElementException();
        }


    }


}
