package com.example.test.controllers;

import com.example.test.dtos.OfferDto;
import com.example.test.models.User;
import com.example.test.services.OfferService;
import com.example.test.dtos.views.OfferViewModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private OfferService offerService;

    @ModelAttribute("offerDto")
    public OfferDto initOffer(){
        return new OfferDto();
    }

    @GetMapping("/add")
    String addOffer(Model model){

        model.addAttribute("models", offerService.showModels());
//        model.addAttribute("user", principal.getName());
        return "offer-add";
    }

    @PostMapping("/add")
    String addOffer(@Valid OfferDto offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto",
                    bindingResult);
            return "redirect:/offer/add";
        }
        offerDto.setUser(principal.getName());
        offerService.addNewOffer(offerDto);
        return "redirect:/";
    }

    @GetMapping("/all")
    String getAllOffers(Model model){
        model.addAttribute("allOffer", offerService.getAllOffer());
        return "offer-all";
    }
    @GetMapping("/details/{id}")
    String getOfferDetailsById(@PathVariable String id, Model model){
        model.addAttribute("offerDetail", offerService.getOfferById(id));
        System.out.println(offerService.getOfferById(id));
        return "offer-details";
    }

    @DeleteMapping("/delete/{id}")
    String deleteOffer(@PathVariable String id){
        offerService.deleteOfferById(id);
        return "Offer with id = " + id + " was deleted";
    }
//    @PutMapping("/{id}/{name}")
//    OfferDto updateOfferImageUrl(@PathVariable String id,@Valid @PathVariable String image_url){
//        return offerService.updateOfferImageUrl(id, image_url);
//    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;}
}
