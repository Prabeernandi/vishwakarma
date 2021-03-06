package com.burwasolution.vishwakarma.service_impl.service.basic;

import com.burwasolution.vishwakarma.config.utils.ApplicationConstant;
import com.burwasolution.vishwakarma.domains.dto.users.ImageUploadDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.ImageUpload;
import com.burwasolution.vishwakarma.reprository.users.ImageUploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class FileManagementService implements ApplicationConstant {

    private ImageUploadRepository imageUploadRepository;
    private ModelMapper modelMapper;
    private String fileUrl;
    private String fileName;

    @Autowired
    public FileManagementService(ImageUploadRepository imageUploadRepository, ModelMapper modelMapper) {
        this.imageUploadRepository = imageUploadRepository;
        this.modelMapper = modelMapper;
    }

    @Value("${file.upload-dir}")
    private String fileUploadPath;

    public ImageUploadDTO uploadFile(String idName, String idNo, MultipartFile file) throws IOException {
        fileName = idName + "_" + idNo + "_" + file.getOriginalFilename().trim();
        fileName = fileName.toLowerCase().replaceAll(" ", "_");
        Path path = Paths.get(serverUploadPath + File.separator + "uploads" + File.separator + File.separator + fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        fileUrl = baseUrl + File.separator + "uploads" + File.separator + fileName;
        log.error("File Url " + baseUrl);

        ImageUpload uploadImage = ImageUpload.builder()
                .fileName(file.getOriginalFilename())
                .fileSize("" + file.getSize())
                .fileType(file.getContentType())
                .fileCategory(idName)
                .url("" + fileUrl)
                .idNo(idNo)
                .idName(idName)
                .build();
        imageUploadRepository.save(uploadImage);

//        ImageUploadDTO uploadDTO = new ImageUploadDTO();

        ImageUploadDTO imageUploadDTO = modelMapper.map(uploadImage, ImageUploadDTO.class);
        return imageUploadDTO;
    }
}



