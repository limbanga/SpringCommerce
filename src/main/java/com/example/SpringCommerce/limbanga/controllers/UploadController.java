package com.example.SpringCommerce.limbanga.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/upload/")
public class UploadController {

    private final Cloudinary cloudinary;

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Vui lòng chọn một file để tải lên.");
        }
        // todo: upload file to cloudinary
        // todo: add validation for file type, size, role of user
        try {
            var uuid = UUID.randomUUID().toString();
            var data = cloudinary.uploader()
                    .upload(
                            file.getBytes(),
                            ObjectUtils.asMap("public_id", uuid)
                    );
            var url = data.get("url").toString();
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Không thể xử lý file.");
        }
    }
}
