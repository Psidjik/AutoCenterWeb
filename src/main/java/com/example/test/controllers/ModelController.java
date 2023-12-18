package com.example.test.controllers;

import com.example.test.dtos.ModelDto;
import com.example.test.services.ModelService;

import com.example.test.dtos.views.ModelViewModel;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/model")
public class ModelController {
    private ModelService modelService;

    private static final Logger LOG = LogManager.getLogger(Controller.class);


    @ModelAttribute("modelDto")
    public ModelDto initBrand() {
        return new ModelDto();
    }

    @GetMapping("/add")
    public String addModel(Model model) {
            model.addAttribute("availableBrands", modelService.showBrand());
        return "model-add";
    }

    @PostMapping("/add")
    String addModel(@Valid ModelDto modelDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelDto", modelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelDto",
                    bindingResult);
            return "redirect:/model/add";
        }
        modelService.addNewModel(modelDto);
        return "redirect:/";
    }
    @GetMapping("/all")
    String getAllModels(Model model){
        model.addAttribute("allModels", modelService.getAllModels());
        return "model-all";
    }
    @GetMapping("/model-details/{name}")
    String modelDetails(@PathVariable("name") String name, Model model){
        model.addAttribute("modelDetails", modelService.getModelByName(name));
        return "model-details";
    }
    @DeleteMapping("/delete/{id}")
    String deleteModel(@PathVariable String id){
        modelService.deleteModelById(id);
        return "Model with id = " + id + " was deleted";}
    @PutMapping("/{id}/{name}")
    ModelDto updateBrandName(@PathVariable String id,@Valid @PathVariable String name){
        return modelService.updateModelName(id, name);}
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

//    @GetMapping("/all/{name}")
//    List<ModelViewModel> getAllModelByName(@PathVariable String name){
//        return modelService.getAllModelByName(name);
//    }
}
