package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.services.base;

import org.springframework.web.multipart.MultipartFile;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.models.File;

import java.nio.file.Path;

public interface StorageService {
    File getById(long id);

    void createDirectory(Path path);

    File store(MultipartFile multipartFile, long userId, String type);

    Path load(long id);

    org.springframework.core.io.Resource loadAsResource(long id);
}
