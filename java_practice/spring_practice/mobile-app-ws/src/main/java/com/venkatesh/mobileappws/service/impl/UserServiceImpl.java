package com.venkatesh.mobileappws.service.impl;

import com.venkatesh.mobileappws.exceptions.UserServiceException;
import com.venkatesh.mobileappws.io.entity.UserEntity;
import com.venkatesh.mobileappws.io.repositories.UserRepository;
import com.venkatesh.mobileappws.service.UserService;
import com.venkatesh.mobileappws.shared.DTO.AddressDto;
import com.venkatesh.mobileappws.shared.DTO.UserDTO;
import com.venkatesh.mobileappws.shared.Utils.Utils;
import com.venkatesh.mobileappws.ui.model.response.ErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if(userRepository.findByEmail(userDTO.getEmail()) != null)
            throw new RuntimeException("Record with the same email already exists");


        for(int i=0;i<userDTO.getAddressList().size();i++) {
            AddressDto addressDto = userDTO.getAddressList().get(i);
            addressDto.setAddressId(utils.generateAddressId(30));
            addressDto.setUser(userDTO);
            userDTO.getAddressList().set(i, addressDto);
        }

        //UserEntity userEntity = new UserEntity();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        //BeanUtils.copyProperties(userDTO, userEntity);


        String encryptedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userEntity.setEncryptedPassword(encryptedPassword);

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);



        UserEntity storedUserDetails = userRepository.save(userEntity);
        System.out.println("Stored User Details: " + storedUserDetails);

//        UserDTO newUserDTO = new UserDTO();
//        BeanUtils.copyProperties(storedUserDetails, newUserDTO);


        UserDTO newUserDTO = modelMapper.map(storedUserDetails, UserDTO.class);

        return newUserDTO;
    }

    @Override
    public UserDTO getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEntity, userDTO);

        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());


    }

    @Override
    public UserDTO getUserByUserId(String publicUserId) {
        UserDTO returnValue = new UserDTO();
        UserEntity foundUser = userRepository.findByUserId(publicUserId);

        if(foundUser == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        BeanUtils.copyProperties(foundUser,returnValue);
        return returnValue;
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {

        UserDTO returnUpdatedUser = new UserDTO();
        UserEntity retrievedUser = userRepository.findByUserId(userId);

        if(retrievedUser == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        retrievedUser.setFirstName(userDTO.getFirstName());
        retrievedUser.setLastName(userDTO.getLastName());

        UserEntity updatedUser = userRepository.save(retrievedUser);

        BeanUtils.copyProperties(updatedUser, returnUpdatedUser);

        return returnUpdatedUser;
    }

    @Override
    public void deleteUser(String id) {
        UserEntity foundUser = userRepository.findByUserId(id);

        if(foundUser == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        userRepository.delete(foundUser);
    }

    @Override
    public List<UserDTO> getUsers(int page, int limit) {
        List<UserDTO> returnList = new ArrayList<>();

        if(page > 0) page -= 1;
        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
        System.out.println(usersPage.getContent());
        List<UserEntity> userEntityList = usersPage.getContent();

        for (UserEntity userEntity: userEntityList) {

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            returnList.add(userDTO);

        }

        return returnList;
    }
}
