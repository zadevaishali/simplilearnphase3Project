package com.project.sporty_shoes.service;

import java.util.List;

import com.project.sporty_shoes.exception.ShoesNotFoundException;
import com.project.sporty_shoes.model.Shoes;
public interface ShoesService {

	public List<Shoes> getAllShoes();

	public Shoes getShoesById(int shoesId) throws ShoesNotFoundException;

	public Shoes addShoes(Shoes shoes);

	public Shoes updateShoes(int shoesId, Shoes shoes) throws ShoesNotFoundException;

	public void deleteShoes(int shoesId);

}

