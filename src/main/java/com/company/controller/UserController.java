package com.company.controller;

import com.company.dto.UserDTO;
import com.company.service.RoleService;
import com.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
         * · When we use redirect, we don't have to create new UserDTO(), roleService.findAll(), userService.findAll()
         *   in the "insertUser" method. Redirect will go to the "createUser" controller, not to the view.
         */
    }


    /*
     *
     * · @GetMapping("/update/{username}") : Passing the Path variable to the endpoint to retrieve a specific user when
     *   we click on the respective update button
     * · @PathVariable("username") : We have to specify an end point variable name inside the @PathVariable() annotation
     *   and pass it into the method parameter.
     *
     */
    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", userService.findById(username)); // populate the fields with chosen existing user data
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";

    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user){

        userService.update(user);
        // After clicking on the save button, it updates the user info and displays on the table. And redirect to the create a view
        return "redirect:/user/create";

    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){

        userService.deleteById(username);

        return "redirect:/user/create";
    }







}
