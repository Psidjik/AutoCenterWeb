package com.example.test.services;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.ModelDto;
import com.example.test.dtos.views.ModelViewModel;

import java.util.List;

public interface ModelService {


    void addNewModel(ModelDto modelDto);
    ModelDto getModelByName(String name);
    void deleteModelById(String id);

    List<BrandDto> showBrand();
//    List<ModelViewModel> getAllModelByName(String name);
    List<ModelViewModel> getAllModels();
    ModelDto updateModelName(String id, String name);
}
