package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.validator;

import org.springframework.web.multipart.MultipartFile;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.exeptions.StorageException;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

public class ImageValidator {

    public static void checkImage(MultipartFile file) {
        try (InputStream input = file.getInputStream()) {
            try {
                //only BMP, GIF, JPG and PNG
                ImageIO.read(input).toString();
            } catch (Exception e) {
               throw new StorageException("Not an image!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
