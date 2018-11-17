package com.venkatesh.mobileappws.service;

import java.util.List;

import com.venkatesh.mobileappws.shared.DTO.AddressDto;

public interface AddressService {
    List<AddressDto> getAddressForUser(String publicUserId);
    AddressDto getSpecificAddress(String addressId);
}