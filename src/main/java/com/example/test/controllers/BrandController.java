package com.example.test.controllers;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.ModelDto;
import com.example.test.services.BrandService;
import com.example.test.dtos.views.BrandViewModel;
import com.example.test.services.OfferService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    private BrandService brandService;

    private OfferService offerService;

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("brandDto")
    public BrandDto initBrand() {
        return new BrandDto();
    }

    @GetMapping("/add")
    public String addBrand() {
        return "brand-add";
    }

    @PostMapping("/add")
    String addBrand(@Valid BrandDto brandDto, Principal principal){
        LOG.log(Level.INFO, "Add new brand for " + principal.getName());
        brandService.addNewBrand(brandDto);
        return "redirect:/";
    }
    @GetMapping("/all")
    String getAllBrand(Model model, Principal principal){
        LOG.log(Level.INFO, "Show all brands for " + principal.getName());
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
    @GetMapping("/details/{name}")
    String getBrandByName(@PathVariable("name") String name, Model model){
        System.out.println(name);
        List<String> modelsName = brandService.numberOfModels(name);
        System.out.println(modelsName);
        model.addAttribute("brandDetails", brandService.getBrandByName(name));
//        model.addAttribute("offers", offerService.findOffersByBrandName(name));

        model.addAttribute("numberOfModels", modelsName);
        return "brand-details";
    }
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
}
