package com.venkatesh.mobileappws.ui.controller;

import com.venkatesh.mobileappws.service.AddressService;
import com.venkatesh.mobileappws.service.UserService;
import com.venkatesh.mobileappws.shared.DTO.AddressDto;
import com.venkatesh.mobileappws.shared.DTO.UserDTO;
import com.venkatesh.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.venkatesh.mobileappws.ui.model.response.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @GetMapping(path = "/{id}")
    public UserResponseModel getUser(@PathVariable String id) {
        UserResponseModel returningUser = new UserResponseModel();

        UserDTO userDTO = userService.getUserByUserId(id);

        BeanUtils.copyProperties(userDTO, returningUser);

        return returningUser;
    }

    @PostMapping
    public UserResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception{

        //if(userDetails.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        if(userDetails.getFirstName().isEmpty()) throw new NullPointerException("First Name cannot be null");

        UserResponseModel returnUser = new UserResponseModel();

//        UserDTO userDTO = new UserDTO();
//        BeanUtils.copyProperties(userDetails, userDTO);

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);

        UserDTO createdUserDTO = userService.createUser(userDTO);
        returnUser = modelMapper.map(createdUserDTO, UserResponseModel.class);

        //BeanUtils.copyProperties(createdUserDTO, returnUser);

        return returnUser;
    }

    @PutMapping(
            path = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public UserResponseModel updateUser(@PathVariable String id,
                             @RequestBody UserDetailsRequestModel userDetailsRequestModel) {

        UserResponseModel returnValue = new UserResponseModel();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetailsRequestModel, userDTO);

        UserDTO updatedUser = userService.updateUser(id, userDTO);
        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(
            path = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public OperationStatusModel deleteUser(@PathVariable String id) {

        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        userService.deleteUser(id);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<UserResponseModel> getUsers(@RequestParam(value="page", defaultValue = "0") int page,
                                            @RequestParam(value="limit", defaultValue = "2") int limit) {
        List<UserResponseModel> returnList = new ArrayList<>();

        List<UserDTO> userDTOList = userService.getUsers(page, limit);

        for(UserDTO userDTO: userDTOList) {
            UserResponseModel userResponseModel = new UserResponseModel();
            BeanUtils.copyProperties(userDTO, userResponseModel);
            returnList.add(userResponseModel);
        }

        return returnList;
    }

    @GetMapping(path = "/{id}/addresses")
    public List<AddressResponseModel> getUserAddresses(@PathVariable String id) {
        List<AddressResponseModel> addressesResponse = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();

        List<AddressDto> addressDtos = addressService.getAddressForUser(id);

        if(addressDtos!= null && !addressDtos.isEmpty()) {
            Type listType = new TypeToken<List<AddressResponseModel>>() {}.getType();
            addressesResponse = modelMapper.map(addressDtos, listType);
        }

        return  addressesResponse;
    }

}
