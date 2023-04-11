package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UploadService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class ArquivoController {
    private final UploadService uploadService;

    @PostMapping
    public void upload(@RequestParam MultipartFile arquivo) throws IllegalStateException, IOException{
        uploadService.uploadArquivo(arquivo);
    }
}
