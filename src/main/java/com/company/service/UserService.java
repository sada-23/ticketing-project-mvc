package com.company.service;

import com.company.dto.UserDTO;

import java.util.List;


public interface UserService extends CrudService <UserDTO, String> {

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();

//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    List<UserDTO> findAll();
//    void delete(UserDTO user);
//    void deleteById(String username);



}
