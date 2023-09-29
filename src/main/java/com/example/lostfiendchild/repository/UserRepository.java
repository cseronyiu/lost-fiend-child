package com.example.lostfiendchild.repository;

import com.example.lostfiendchild.entity.LostChildEntity;
import com.example.lostfiendchild.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


import com.example.lostfiendchild.entity.LostChildEntity;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    List<UserEntity> findAllByOrderByIdDesc();
    List<UserEntity> findAllByEmailAndPassword(String email,String password);
}