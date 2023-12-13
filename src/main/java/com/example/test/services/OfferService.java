package com.example.test.services;

import com.example.test.dtos.ModelDto;
import com.example.test.dtos.OfferDto;
import com.example.test.dtos.UserDto;
import com.example.test.dtos.views.ModelViewModel;
import com.example.test.dtos.views.OfferViewModel;
import com.example.test.dtos.views.UserViewModel;

import java.util.List;

public interface OfferService {

    void addNewOffer(OfferDto offerDto);
    OfferDto getOfferById(String id);
    void deleteOfferById(String id);
    List<OfferViewModel> getAllOffer();

//    List<OfferDto> getOfferByImageUrl(String image_url);

//    OfferDto updateOfferImageUrl(String id, String image_url);
    List<OfferViewModel> findOffersByBrandName(String brandName);

    List<UserDto> showUsers();
    List<ModelDto> showModels();
}
