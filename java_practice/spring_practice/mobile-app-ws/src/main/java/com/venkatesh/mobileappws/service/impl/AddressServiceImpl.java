package com.venkatesh.mobileappws.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.venkatesh.mobileappws.io.entity.AddressEntity;
import com.venkatesh.mobileappws.io.entity.UserEntity;
import com.venkatesh.mobileappws.io.repositories.AddressRepository;
import com.venkatesh.mobileappws.io.repositories.UserRepository;
import com.venkatesh.mobileappws.service.AddressService;
import com.venkatesh.mobileappws.shared.DTO.AddressDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAddressForUser(String publicUserId) {
        List<AddressDto> returnAddressDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserId(publicUserId);

        if(userEntity == null ) return returnAddressDtos;

        Iterable<AddressEntity> addresses = addressRepository.findAllByUser(userEntity);

        for( AddressEntity addressEntity: addresses) {
            returnAddressDtos.add(modelMapper.map(addressEntity, AddressDto.class));
        }

        return returnAddressDtos;

    }
}