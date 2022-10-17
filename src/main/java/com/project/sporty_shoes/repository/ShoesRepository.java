package com.project.sporty_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sporty_shoes.model.Shoes;

public interface ShoesRepository extends JpaRepository<Shoes, Integer>  {

}
