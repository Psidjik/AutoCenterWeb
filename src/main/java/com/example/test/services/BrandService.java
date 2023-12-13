package com.example.test.services;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.views.BrandViewModel;

import java.util.List;

public interface BrandService {
//    List<BrandDto> getAllBrands();
//    BrandDto addNewBrand();
//    BrandDto getBrandById();
//    void deleteBrand(ID id);

//    Brand addNewBrand(Brand brand);
    void addNewBrand(BrandDto brandDto);
    BrandViewModel getBrandById(String id);
    void deleteBrandById(String id);
    BrandViewModel getBrandByName(String name);
    List<BrandDto> getAllBrands();
    BrandDto updateBrandName(String id, String name);

    List<String> numberOfModels(String name);
}
