package com.enigma.restfulAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.restfulAPI.entity.Good;

public interface GoodRepository extends JpaRepository<Good, Long> {

}
