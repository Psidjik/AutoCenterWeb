package com.example.test.repositories;

import com.example.test.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

//    @Query("select m from Model m where m.name = :name")
//    List<Model> findAllByName(String name);


    Optional<Model> findByName(String name);
}
