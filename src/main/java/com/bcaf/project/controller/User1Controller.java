//package com.bcaf.project.controller;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bcaf.project.model.ApplicationUser;
//import com.bcaf.project.repository.ApplicationUserRepository;
//
//@RestController
//@RequestMapping("/users")
//public class User1Controller {
//
//    private ApplicationUserRepository applicationUserRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public User1Controller(ApplicationUserRepository applicationUserRepository,
//                          BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.applicationUserRepository = applicationUserRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @PostMapping("/sign-up")
//    public void signUp(@RequestBody ApplicationUser user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        applicationUserRepository.save(user);
//    }
//}