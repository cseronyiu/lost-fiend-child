package com.example.lostfiendchild.repository;

import com.example.lostfiendchild.entity.LostChildEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostChildRepository extends CrudRepository<LostChildEntity,Integer> {
}
