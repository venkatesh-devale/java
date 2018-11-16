package com.venkatesh.mobileappws.service;

import com.venkatesh.mobileappws.shared.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUser(String email);
    UserDTO getUserByUserId(String publicUserId);
    UserDTO updateUser(String id, UserDTO userDTO);
    void deleteUser(String id);
    List<UserDTO> getUsers(int page, int limit);
}
