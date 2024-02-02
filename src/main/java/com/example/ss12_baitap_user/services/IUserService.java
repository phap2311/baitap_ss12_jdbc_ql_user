package com.example.ss12_baitap_user.services;

import com.example.ss12_baitap_user.models.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);

    User findById(Integer id);

    void update(User user);

    void delete(Integer id);

    List<User> searchByCountry(String countryUser);

    List<User> findAllArranged();
}
