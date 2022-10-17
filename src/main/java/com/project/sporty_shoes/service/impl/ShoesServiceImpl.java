package com.project.sporty_shoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sporty_shoes.exception.ShoesNotFoundException;
import com.project.sporty_shoes.model.Shoes;
import com.project.sporty_shoes.repository.ShoesRepository;
import com.project.sporty_shoes.service.ShoesService;

@Service
public class ShoesServiceImpl implements ShoesService {

	@Autowired
	public ShoesRepository shoesRepository;

	@Override
	public List<Shoes> getAllShoes() {
		return shoesRepository.findAll();
	}

	@Override
	public Shoes getShoesById(int shoesId) throws ShoesNotFoundException {
		return shoesRepository.findById(shoesId).orElseThrow(() -> new ShoesNotFoundException("Shoes not found"));
	}

	@Override
	public Shoes addShoes(Shoes shoes) {
		return shoesRepository.save(shoes);
	}

	@Override
	public Shoes updateShoes(int shoesId, Shoes shoes) throws ShoesNotFoundException {
		Shoes existingShoes = shoesRepository.findById(shoesId)
				.orElseThrow(() -> new ShoesNotFoundException("Shoes not found"));
		existingShoes.setName(shoes.getName());
		existingShoes.setPrice(shoes.getPrice());
		existingShoes.setQuantityAvailable(shoes.getQuantityAvailable());
		existingShoes.setImageUrl(shoes.getImageUrl());
		return shoesRepository.save(existingShoes);
	}

	@Override
	public void deleteShoes(int shoesId) {
		shoesRepository.deleteById(shoesId);
	}

}
