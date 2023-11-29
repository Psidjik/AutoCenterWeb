package com.example.test.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ApplicationConfig{

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
//
//        TypeMap<Brand, BrandDto> brandBrandDtoTypeMap = modelMapper.createTypeMap(Brand.class, BrandDto.class);
//        brandBrandDtoTypeMap.addMappings((m->m.map(src -> src.getId(), BrandDto::setId)));
//        brandBrandDtoTypeMap.addMappings((m->m.map(src -> src.getModified(), BrandDto::setModified)));
//        brandBrandDtoTypeMap.addMappings((m->m.map(src -> src.getCreated(), BrandDto::setCreated)));
//        brandBrandDtoTypeMap.addMappings((m->m.map(src -> src.getName(), BrandDto::setName)));
//        TypeMap<Brand, BrandDto> typeMapBrand = modelMapper.createTypeMap(Brand.class,BrandDto.class);
//        typeMapBrand.addMappings((m->m.map(src -> src.getName(),BrandDto::setName)));
//        typeMapBrand.addMappings((m->m.map(src -> src.getCreated(), BrandDto::setCreated)));
//        typeMapBrand.addMappings(m->m.map(src -> src.getModified() , BrandDto::setModified));

//
//        TypeMap<BrandDto, Brand> brandDtoBrandTypeMap = modelMapper.createTypeMap(BrandDto.class, Brand.class);
//        brandDtoBrandTypeMap.addMappings((m->m.map(src-> src.getId(), Brand::setId)));
//        brandDtoBrandTypeMap.addMappings((m->m.map(src-> src.getCreated(), Brand::setCreated)));
//        brandDtoBrandTypeMap.addMappings((m->m.map(src-> src.getModified(), Brand::setModified)));
//        brandDtoBrandTypeMap.addMappings((m->m.map(src-> src.getName(), Brand::setName)));
//
//
//        TypeMap<Model, ModelDto> modelModelDtoTypeMap = modelMapper.createTypeMap(Model.class, ModelDto.class);
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getId(), ModelDto::setId)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getModified(), ModelDto::setBrand)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getCreated(), ModelDto::setCreated)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getCategory(), ModelDto::setCategory)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getEndYear(), ModelDto::setEndYear)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getImageUrl(), ModelDto::setImageUrl)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getName(), ModelDto::setName)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getStartYear(), ModelDto::setStartYear)));
//        modelModelDtoTypeMap.addMappings((m -> m.map(src -> src.getBrand(), ModelDto::setBrand)));
//
//        TypeMap<ModelDto, Model> modelDtoModelTypeMap = modelMapper.createTypeMap(ModelDto.class, Model.class);
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getId(), Model::setId)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getModified(), Model::setBrand)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getCreated(), Model::setCreated)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getCategory(), Model::setCategory)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getEndYear(), Model::setEndYear)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getImageUrl(), Model::setImageUrl)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getName(), Model::setName)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getStartYear(), Model::setStartYear)));
//        modelDtoModelTypeMap.addMappings((m -> m.map(src -> src.getBrand(), Model::setBrand)));
//
//        TypeMap<Model, ModelViewModel> modelModelViewModelTypeMap = modelMapper.createTypeMap(Model.class, ModelViewModel.class);
//        modelModelViewModelTypeMap.addMappings((m->m.map(src->src.getName(), ModelViewModel::setName)));
//        modelModelViewModelTypeMap.addMappings((m->m.map(src->src.getCategory(), ModelViewModel::setCategory)));
//        modelModelViewModelTypeMap.addMappings((m->m.map(src->src.getEndYear(), ModelViewModel::setEndYear)));
//        modelModelViewModelTypeMap.addMappings((m->m.map(src->src.getImageUrl(), ModelViewModel::setImageUrl)));

//        TypeMap<Brand, BrandViewModel> brandBrandViewModelTypeMap = modelMapper.createTypeMap(Brand.class, BrandViewModel.class);
//        brandBrandViewModelTypeMap.addMappings((m->m.map(src->src.getName(), ModelViewModel::setName)));


        return modelMapper;
    }
}