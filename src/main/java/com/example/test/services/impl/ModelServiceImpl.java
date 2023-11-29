package com.example.test.services.impl;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.ModelDto;
import com.example.test.models.Model;
import com.example.test.repositories.BrandRepository;
import com.example.test.repositories.ModelRepository;
import com.example.test.services.ModelService;
import com.example.test.dtos.views.ModelViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    ModelRepository modelRepository;
    BrandRepository brandRepository;
    ModelMapper modelMapper;

    public ModelServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewModel(ModelDto modelDto) {
        Model model = modelMapper.map(modelDto, Model.class);
        model.setBrand(brandRepository.findByName(modelDto.getBrand()).orElseThrow());
        model.setCreated(LocalDateTime.now());
        model.setModified(LocalDateTime.now());
        modelRepository.save(model);
    }

    @Override
    public ModelDto getModelByName(String name) {
        return modelMapper.map(modelRepository.findByName(name), ModelDto.class);
    }

//    @Override
//    public List<ModelViewModel> getAllModelByName(String name) {
//        return modelRepository.findAllByName(name).stream().map(model -> modelMapper.map(model, ModelViewModel.class)).collect(Collectors.toList());
//    }

    @Override
    public ModelDto updateModelName(String uuid, String name) {
        Model model = modelRepository.findById(uuid).orElseThrow();
        model.setName(name);
        model.setModified(LocalDateTime.now());
        modelRepository.save(model);
        return modelMapper.map(model, ModelDto.class);
    }

    @Override
    public List<ModelViewModel> getAllModels() {
        return modelRepository.findAll().stream().map(model -> modelMapper.map(model, ModelViewModel.class)).collect(Collectors.toList());
    }
    @Override
    public void deleteModelById(String id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<BrandDto> showBrand() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
