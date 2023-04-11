package com.example.demo.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
    
    public void uploadArquivo( MultipartFile arquivo) throws IllegalStateException, IOException {
        arquivo.transferTo(new File("C:\\Users\\Luis Felipe\\projetos\\receita_bruta_spring\\demo\\src\\main\\resources\\static\\arquivos"+arquivo.getOriginalFilename()));
    }
}
