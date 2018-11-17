package com.venkatesh.mobileappws.io.repositories;

import java.util.List;

import com.venkatesh.mobileappws.io.entity.AddressEntity;
import com.venkatesh.mobileappws.io.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>{
    List<AddressEntity> findAllByUser(UserEntity userEntity);
    AddressEntity findByAddressId(String addressId);
}