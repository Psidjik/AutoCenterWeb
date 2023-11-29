package com.example.test.services.impl;

import com.example.test.dtos.OfferDto;
import com.example.test.models.Offer;
import com.example.test.repositories.OfferRepository;
import com.example.test.services.OfferService;
import com.example.test.dtos.views.OfferViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService<UUID> {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OfferDto addNewOffer(OfferDto offerDto) {
        offerDto.setId(UUID.randomUUID());
        return modelMapper.map(offerRepository.save(modelMapper.map(offerDto, Offer.class)), OfferDto.class);

    }
    @Override
    public OfferViewModel getOfferById(UUID id) {
        return modelMapper.map(offerRepository.findById(id), OfferViewModel.class);
    }

    @Override
    public void deleteOfferById(UUID id) {
    offerRepository.deleteById(id);
    }

    @Override
    public OfferDto updateOfferImageUrl(UUID uuid, String image_url) {
        Offer offer = offerRepository.findById(uuid).orElseThrow();
        offer.setImage_url(image_url);
        offerRepository.save(offer);
        return modelMapper.map(offer, OfferDto.class);
    }

    @Override
    public List<OfferViewModel> getAllOffer() {
        return offerRepository.findAll().stream().map(offer -> modelMapper.map(offer, OfferViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferViewModel> findOffersByBrandName(String brandName) {
        return offerRepository.findOffersByBrandName(brandName).stream().map(offer -> modelMapper.map(offer, OfferViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDto> getOfferByImageUrl(String image_url) {
        return null;
    }
}
