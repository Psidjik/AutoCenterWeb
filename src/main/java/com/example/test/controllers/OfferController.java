package com.example.test.controllers;

import com.example.test.dtos.OfferDto;
import com.example.test.services.OfferService;
import com.example.test.dtos.views.OfferViewModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private OfferService offerService;
    @GetMapping("/all")
    List<OfferViewModel> getAllOffers(){
        return offerService.getAllOffer();
    }
    @GetMapping("/{id}")
    OfferViewModel getOfferById(@PathVariable UUID id){
        return offerService.getOfferById(id);
    }
    @PostMapping("/add")
    OfferDto addOffer(@Valid @RequestBody OfferDto offerDto){
        return offerService.addNewOffer(offerDto);
    }
    @DeleteMapping("/delete/{id}")
    String deleteOffer(@PathVariable UUID id){
        offerService.deleteOfferById(id);
        return "Offer with id = " + id + " was deleted";
    }
    @PutMapping("/{id}/{name}")
    OfferDto updateOfferImageUrl(@PathVariable UUID id,@Valid @PathVariable String image_url){
        return offerService.updateOfferImageUrl(id, image_url);
    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;}
}
