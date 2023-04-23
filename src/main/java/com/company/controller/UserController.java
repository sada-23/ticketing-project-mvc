package com.company.controller;

import com.company.dto.UserDTO;
import com.company.service.RoleService;
import com.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO()); // UserDTO() will communicate with the UI
        model.addAttribute("roles", roleService.findAll()); // Bring all roles from DB
        model.addAttribute("users", userService.findAll());


        return "/user/create";

    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());

        userService.save(user); // save new user
//        model.addAttribute("users", userService.findAll()); // and display new user on the table

        //return "/user/create"; // user, roles, user
        return "redirect:/user/create";
        /*
         * redirect will go to the "createUser" controller not to the view.
         * · When we use redirect, we don't have to create new UserDTO(), roleService.findAll(), userService.findAll()
         *   in the "insertUser" method. Redirect will go to the "createUser" controller, not to the view.
         *
         *
         */
    }


}
