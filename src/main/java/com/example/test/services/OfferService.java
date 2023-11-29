package com.example.test.services;

import com.example.test.dtos.OfferDto;
import com.example.test.dtos.views.OfferViewModel;

import java.util.List;

public interface OfferService<ID> {

    OfferDto addNewOffer(OfferDto offerDto);
    OfferViewModel getOfferById(ID id);
    void deleteOfferById(ID id);
    List<OfferViewModel> getAllOffer();

    List<OfferDto> getOfferByImageUrl(String image_url);

    OfferDto updateOfferImageUrl(ID id, String image_url);
    List<OfferViewModel> findOffersByBrandName(String brandName);
}
