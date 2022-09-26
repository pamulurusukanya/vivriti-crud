package com.example.vivriti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vivriti.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
