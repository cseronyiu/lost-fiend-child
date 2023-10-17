package com.example.lostfiendchild.service;

import com.example.lostfiendchild.entity.LostChildEntity;
import com.example.lostfiendchild.repository.LostChildRepository;
import com.example.lostfiendchild.viewModels.LostChildVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LostChildService {
    private final Path root = Paths.get("./uploads");

    @Autowired
    LostChildRepository lostChildRepository;
    public void saveLostChiuld() {
        LostChildEntity lostChildEntity = new LostChildEntity();
        lostChildRepository.save(lostChildEntity);
    }

    public void saveLostChiuld(LostChildVM lostChild, MultipartFile file) {
        LostChildEntity lostChildEntity = new LostChildEntity();
        lostChildEntity.setName(lostChild.getName());
        lostChildEntity.setAge(lostChild.getAge());
        lostChildEntity.setHeight(lostChild.getHeight());
        lostChildEntity.setWeight(lostChild.getWeight());
        lostChildEntity.setFather_name(lostChild.getFather_name());
        lostChildEntity.setMother_name(lostChild.getMother_name());
        lostChildEntity.setAddress(lostChild.getAddress());
        lostChildEntity.setPhn_num(lostChild.getPhn_num());
        lostChildEntity.setImageFileName(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lostChildRepository.save(lostChildEntity);
    }

    public List<LostChildEntity> getAllChild() {
       return lostChildRepository.findAllByOrderByIdDesc();
    }

    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
