//package com.example.test.init;
//
//
//import com.example.test.models.enums.Category;
//import com.example.test.models.enums.Engine;
//import com.example.test.models.enums.Role;
//import com.example.test.models.enums.Transmission;
//import com.example.test.dtos.*;
//import com.example.test.services.*;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//@Component
//public class CommandLineRunnerImpl implements CommandLineRunner {
//
//        private BrandService brandService;
//        private ModelService modelService;
//        private OfferService offerService;
//        private UserRoleService userRoleService;
//        private UserService userService;
//
//        private ModelMapper modelMapper;
//
//    public CommandLineRunnerImpl(BrandService brandService, ModelService modelService, OfferService offerService,
//                                 UserRoleService userRoleService, UserService userService, ModelMapper modelMapper) {
//        this.brandService = brandService;
//        this.modelService = modelService;
//        this.offerService = offerService;
//        this.userRoleService = userRoleService;
//        this.userService = userService;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//        public void run(String... args) throws  Exception{
//            seedData();
//
//        }
//        private void seedData() throws IOException {
//
//            BrandDto brandDto = new BrandDto(LocalDateTime.now(), LocalDateTime.now(), "BMW");
//            brandService.addNewBrand(brandDto);
//            BrandDto brandDto1 = new BrandDto(LocalDateTime.now(), LocalDateTime.now(), "Bens");
//            brandService.addNewBrand(brandDto1);
//            UserRoleDto userRoleDto = new UserRoleDto(Role.USER);
//            UserRoleDto userRoleDto1 = new UserRoleDto(Role.ADMIN);
//            userRoleService.addNewUserRole(userRoleDto);
//            userRoleService.addNewUserRole(userRoleDto1);
//
//            ModelDto modelDto = new ModelDto(LocalDateTime.now(), LocalDateTime.now(),
//                    Category.Car, 2012, "123452125.url", "lincoln", 1994, brandDto.getName());
//            ModelDto modelDto1 = new ModelDto(LocalDateTime.now(), LocalDateTime.now(),
//                    Category.Buss, 2015, "1234525.url", "EXEED", 1995, brandDto.getName());
//            ModelDto modelDto2 = new ModelDto(LocalDateTime.now(), LocalDateTime.now(),
//                    Category.Motorcycle, 2017, "123125.url", "MERC", 2004, brandDto1.getName());
//            modelService.addNewModel(modelDto);
//            modelService.addNewModel(modelDto1);
//            modelService.addNewModel(modelDto2);
//
//            UserDto userDto = new UserDto(LocalDateTime.now(), LocalDateTime.now(),
//                    userRoleDto, true, "Goga", "1231234124", "Niki", "1234", "gogavich");
//            UserDto userDto1 = new UserDto(LocalDateTime.now(), LocalDateTime.now(),
//                    userRoleDto1, true, "Goga", "1231234124", "Niki", "1234", "gogavich");
//            UserDto userDto2 = new UserDto(LocalDateTime.now(), LocalDateTime.now(),
//                    userRoleDto1, true, "Goga", "1231234124", "Niki", "1234", "gogavich");
//            userService.addNewUser(userDto);
//            userService.addNewUser(userDto1);
//            userService.addNewUser(userDto2);
//
//            OfferDto offerDto = new OfferDto(LocalDateTime.now(), LocalDateTime.now(),
//                    modelDto, userDto, "Бричка", Engine.DIESEL, "1231234", 123, 125412.25, Transmission.MANUAL, 2012);
//            OfferDto offerDto1 = new OfferDto(LocalDateTime.now(), LocalDateTime.now(),
//                    modelDto1, userDto2, "{thbx}", Engine.ELECTRIC, "1235555", 123, 1254142.25, Transmission.AUTOMATIC, 2020);
//            OfferDto offerDto2 = new OfferDto(LocalDateTime.now(), LocalDateTime.now(),
//                    modelDto2, userDto1, "HBnjmk", Engine.HYBRID, "1254444", 123, 1254121.25, Transmission.AUTOMATIC, 2018);
//            offerService.addNewOffer(offerDto);
//            offerService.addNewOffer(offerDto1);
//            offerService.addNewOffer(offerDto2);
//
//
//            System.out.println("------------------------------------------------------");
//            System.out.println(brandDto.getId());
//            System.out.println((brandService.getBrandById(brandDto.getId())).toString());
//            System.out.println("------------------------------------------------------");
//            System.out.println(brandDto1.getId());
//            System.out.println((brandService.getBrandById(brandDto1.getId())).toString());
//            System.out.println("------------------------------------------------------");
//            System.out.println(brandService.getAllBrands());
//            System.out.println("------------------------------------------------------");
//            System.out.println(userRoleDto.getId());
//            System.out.println((userRoleService.getUserRoleById(userRoleDto.getId())));
//            System.out.println("------------------------------------------------------");
//            System.out.println(userRoleDto1.getId());
//            System.out.println((userRoleService.getUserRoleById(userRoleDto1.getId())).toString());
//            System.out.println("------------------------------------------------------");
//            System.out.println(modelDto.getId());
//            System.out.println((modelService.getModelById(modelDto.getId())).toString());
//            System.out.println("------------------------------------------------------");
////            System.out.println(modelDto.getId());
////            System.out.println(modelDto1.getId());
////            System.out.println(modelDto2.getId());
//            System.out.println((modelService.getAllModelByName("lincoln")));
//            System.out.println("------------------------------------------------------");
//            System.out.println(userDto.getId());
//            System.out.println(userDto1.getId());
//            System.out.println(userDto2.getId());
//            System.out.println((userService.getUserById(userDto1.getId())).toString());
//            System.out.println((userService.getAllUser()));
//            System.out.println("------------------------------------------------------");
//            modelService.deleteModelById(userDto1.getId());
//            System.out.println(modelService.getAllModels());
//            System.out.println("------------------------------------------------------");
////            userRoleService.deleteUserRoleById(userRoleDto1.getId());
//            System.out.println("------------------------------------------------------");
//            System.out.println(userService.getAllUser());
//            System.out.println("------------------------------------------------------");
//            System.out.println(offerDto.getId());
//            System.out.println(offerDto1.getId());
//            System.out.println(offerDto2.getId());
//
//            offerService.deleteOfferById(offerDto2.getId());
//
////            userService.deleteUserById(userDto2.getId());
//
//            System.out.println("------------------------------------------------------");
//            System.out.println(offerService.getAllOffer());
//            System.out.println("------------------------------------------------------");
//            modelService.updateModelName(modelDto.getId(), "zzz");
//            System.out.println(modelService.getModelById(modelDto.getId()));
//            System.out.println(offerService.getOfferById(offerDto1.getId()));
//            System.out.println("------------------------------------------------------");
//            System.out.println(brandService.getBrandByName("BMW"));
//            System.out.println(offerService.findOffersByBrandName(brandDto.getName()));
//        }
//
//}
