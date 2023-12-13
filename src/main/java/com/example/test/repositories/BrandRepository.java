package com.example.test.repositories;

import com.example.test.models.Brand;
import com.example.test.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
//    @Query("select b from Brand b where b.name = :name")
//    List<Brand> findAllByName(String name);

    Optional<Brand> findByName(String name);
    @Query("SELECT m.name FROM Model m JOIN m.brand b WHERE b.name = :name")
    List<String> numberOfModels(String name);
}
