package com.example.test.controllers;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.ModelDto;
import com.example.test.services.BrandService;
import com.example.test.dtos.views.BrandViewModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brand")
public class BrandController {
    private BrandService brandService;

    @ModelAttribute("brandDto")
    public BrandDto initBrand() {
        return new BrandDto();
    }

    @GetMapping("/add")
    public String addBrand() {
        return "brand-add";
    }

    @PostMapping("/add")
    String addBrand(@Valid BrandDto brandDto){
        brandService.addNewBrand(brandDto);
        return "redirect:/";
    }
    @GetMapping("/all")
    String getAllBrand(Model model){
        model.addAttribute("allBrand", brandService.getAllBrands());
        return "brand-all";
    }
    @GetMapping("/{id}")
    BrandViewModel getBrand(@PathVariable String id){
        return brandService.getBrandById(id);
    }

    @DeleteMapping("/delete/{id}")
    String deleteBrand(@PathVariable String id){
        brandService.deleteBrandById(id);
        return "Brand with id = " + id + " was deleted";}
    @PutMapping("/{id}/{name}")
    BrandDto updateBrandName(@PathVariable String id, @Valid @PathVariable String name){
        return brandService.updateBrandName(id, name);}
    @GetMapping("/brand-details/{name}")
    String getBrandByName(@PathVariable("name") String name, Model model){
        model.addAttribute("brandDetails", brandService.getBrandByName(name));
        return "brand-details";
    }
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
