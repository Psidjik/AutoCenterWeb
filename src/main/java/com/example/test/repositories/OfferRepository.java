package com.example.test.repositories;

import com.example.test.dtos.OfferDto;
import com.example.test.models.BaseEntity;
import com.example.test.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
    @Query("SELECT o " +
            "FROM Offer o " +
            "JOIN o.model m " +
            "JOIN m.brand b " +
            "WHERE b.name = :brandName")
List<Offer> findOffersByBrandName(String brandName);



}
