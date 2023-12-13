package com.example.test.repositories;

import com.example.test.dtos.views.OfferViewModel;
import com.example.test.models.Offer;
import com.example.test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    @Query("SELECT o FROM Offer o JOIN o.user u WHERE u.username = :username")
    List<Offer> findOffers(String username);
}
