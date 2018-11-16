package com.venkatesh.mobileappws.io.entity;

import com.venkatesh.mobileappws.shared.DTO.UserDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "addresses")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 330412154586183259L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String addressId;

    @Column(nullable = false, length = 15)
    private String city;

    @Column(nullable = false, length = 15)
    private String country;

    @Column(nullable = false, length = 7)
    private String zipcode;

    @Column(nullable = false, length = 10)
    private String type;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
