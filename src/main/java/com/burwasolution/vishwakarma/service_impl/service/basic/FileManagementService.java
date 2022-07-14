package com.burwasolution.vishwakarma.service_impl.service.basic;

import com.burwasolution.vishwakarma.config.utils.ApplicationConstant;
import com.burwasolution.vishwakarma.domains.dto.users.ImageUploadDTO;
import com.burwasolution.vishwakarma.domains.entity.basic.ImageUpload;
import com.burwasolution.vishwakarma.reprository.users.ImageUploadRepository;
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
        fileName = idNo + "_" + file.getOriginalFilename().trim().toLowerCase().replaceAll(" ", "_");
        Path path = Paths.get(fileUploadPath + File.separator + idName + File.separator + fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        fileUrl = baseUrl + "/" + fileName;

        ImageUpload uploadImage = ImageUpload.builder()
                .fileName(file.getOriginalFilename())
                .fileSize("" + file.getSize())
                .fileType(file.getContentType())
                .fileCategory(idName)
                .url("" + fileUrl)
                .idName(idName)
                .build();
        imageUploadRepository.save(uploadImage);
        ImageUploadDTO imageUploadDTO = modelMapper.map(uploadImage, ImageUploadDTO.class);
        return imageUploadDTO;
    }
}



