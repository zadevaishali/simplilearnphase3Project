package com.project.sporty_shoes.controller;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sporty_shoes.dto.ShoesDto;
import com.project.sporty_shoes.exception.ShoesNotFoundException;
import com.project.sporty_shoes.model.Shoes;
import com.project.sporty_shoes.response.ApiResponse;
import com.project.sporty_shoes.service.ShoesService;


@RestController
@RequestMapping(path = { "/shoes", "/admin/shoes" })
public class ShoesController {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public ShoesService shoesService;

	@GetMapping
	public List<ShoesDto> getAllShoes() {
		return shoesService.getAllShoes().stream().map(shoes -> modelMapper.map(shoes, ShoesDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping("/addShoes")
	public ResponseEntity<ShoesDto> addShoes(@RequestBody ShoesDto shoesDto) {
		Shoes shoesRequest = modelMapper.map(shoesDto, Shoes.class);
		Shoes shoes = shoesService.addShoes(shoesRequest);
		ShoesDto shoesResponse = modelMapper.map(shoes, ShoesDto.class);
		return new ResponseEntity<>(shoesResponse, CREATED);

	}

	@PutMapping("/editShoes/{id}")
	public ResponseEntity<ShoesDto> updateShoes(@PathVariable(name = "id") String id, @RequestBody ShoesDto shoesDto)
			throws ShoesNotFoundException {
		Shoes shoesRequest = modelMapper.map(shoesDto, Shoes.class);
		Shoes shoes = shoesService.updateShoes(Integer.parseInt(id), shoesRequest);
		ShoesDto shoesResponse = modelMapper.map(shoes, ShoesDto.class);
		return ResponseEntity.ok().body(shoesResponse);
	}

	@DeleteMapping("/deleteShoes/{id}")
	public ResponseEntity<ApiResponse> deleteShoes(@PathVariable int id) {
		shoesService.deleteShoes(id);
		ApiResponse apiResponse = new ApiResponse();
		return new ResponseEntity<>(apiResponse, OK);
	}

}
