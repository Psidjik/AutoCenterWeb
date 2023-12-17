package com.example.test.services.impl;

import com.example.test.dtos.ModelDto;
import com.example.test.dtos.OfferDto;
import com.example.test.dtos.UserDto;
import com.example.test.dtos.views.ModelViewModel;
import com.example.test.dtos.views.UserViewModel;
import com.example.test.models.Offer;
import com.example.test.repositories.ModelRepository;
import com.example.test.repositories.OfferRepository;
import com.example.test.repositories.UserRepository;
import com.example.test.services.OfferService;
import com.example.test.dtos.views.OfferViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class OfferServiceImpl implements OfferService {
    OfferRepository offerRepository;
    ModelRepository modelRepository;
    UserRepository userRepository;


    @Autowired
    ModelMapper modelMapper;

    @Override
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void addNewOffer(OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        offer.setModel(modelRepository.findByName(offerDto.getModel()).orElseThrow());
        offer.setUser(userRepository.findByUsername(offerDto.getUser()).orElseThrow());
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        offerRepository.saveAndFlush(offer);

    }
    @Override
    @Cacheable("offers")
    public OfferDto getOfferById(String id) {
        return modelMapper.map(offerRepository.findById(id), OfferDto.class);
    }

    @Override
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void deleteOfferById(String id) {
    offerRepository.deleteById(id);
    }

//    @Override
//    public OfferDto updateOfferImageUrl(String uuid, String image_url) {
//        Offer offer = offerRepository.findById(uuid).orElseThrow();
//        offer.setImage_url(image_url);
//        offerRepository.save(offer);
//        return modelMapper.map(offer, OfferDto.class);
//    }

    @Override
    @Cacheable("offers")
    public List<OfferViewModel> getAllOffer() {
        return offerRepository.findAll().stream().map(offer -> modelMapper.map(offer, OfferViewModel.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("offers")
    public List<OfferViewModel> findOffersByBrandName(String brandName) {
        return offerRepository.findOffersByBrandName(brandName).stream().map(offer -> modelMapper.map(offer, OfferViewModel.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("offers")
    public List<UserDto> showUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("offers")
    public List<ModelDto> showModels() {
        return modelRepository.findAll().stream().map(model -> modelMapper.map(model, ModelDto.class)).collect(Collectors.toList());
    }
@Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
@Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
//    @Override
//    public List<OfferDto> getOfferByImageUrl(String image_url) {
//        return null;
//    }
}
