package com.example.lostfiendchild.service;

import com.example.lostfiendchild.entity.LostChildEntity;
import com.example.lostfiendchild.repository.LostChildRepository;
import com.example.lostfiendchild.viewModels.LostChildVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostChildService {
    @Autowired
    LostChildRepository lostChildRepository;
    public void saveLostChiuld() {
        LostChildEntity lostChildEntity = new LostChildEntity();
        lostChildRepository.save(lostChildEntity);
    }

    public void saveLostChiuld(LostChildVM lostChild) {
        LostChildEntity lostChildEntity = new LostChildEntity();
        lostChildEntity.setName(lostChild.getName());
        lostChildEntity.setAge(lostChild.getAge());
        lostChildEntity.setHeight(lostChild.getHeight());
        lostChildEntity.setWeight(lostChild.getWeight());
        lostChildEntity.setFather_name(lostChild.getFather_name());
        lostChildEntity.setMother_name(lostChild.getMother_name());
        lostChildEntity.setAddress(lostChild.getAddress());
        lostChildEntity.setPhn_num(lostChild.getPhn_num());
        lostChildRepository.save(lostChildEntity);
    }

    public List<LostChildEntity> getAllChild() {
       return lostChildRepository.findAllByOrderByIdDesc();
    }
}
