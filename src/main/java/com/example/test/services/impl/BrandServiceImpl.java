package com.example.test.services.impl;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.ModelDto;
import com.example.test.models.Brand;
import com.example.test.repositories.BrandRepository;
import com.example.test.services.BrandService;
import com.example.test.util.ValidationUtil;
import com.example.test.dtos.views.BrandViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

@Service
@EnableCaching
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapper modelMapper;

    public BrandServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public void addNewBrand(BrandDto brandDto) {
        Brand brand = modelMapper.map(brandDto, Brand.class);
        brand.setCreated(LocalDateTime.now());
        brand.setModified(LocalDateTime.now());
        brandRepository.saveAndFlush(brand);
    }

    @Override
    public BrandViewModel getBrandById(String id) {
        return modelMapper.map(brandRepository.findById(id), BrandViewModel.class);
    }

    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public void deleteBrandById(String id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BrandViewModel getBrandByName(String name) {
        return modelMapper.map(brandRepository.findByName(name).orElseThrow(), BrandViewModel.class);
    }

    @Override
    @Cacheable("brands")
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public BrandDto updateBrandName(String uuid, String name) {
        Brand brand = brandRepository.findById(uuid).orElseThrow();
        brand.setName(name);
        brand.setModified(LocalDateTime.now());
        brandRepository.save(brand);
        return modelMapper.map(brand, BrandDto.class);
    }

    @Override
    public List<String> numberOfModels(String name) {
        return brandRepository.numberOfModels(name);
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
}
