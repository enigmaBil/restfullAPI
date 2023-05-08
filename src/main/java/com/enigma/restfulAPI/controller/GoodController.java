/**
 * 
 */
package com.enigma.restfulAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.restfulAPI.entity.Good;
import com.enigma.restfulAPI.service.GoodService;

import lombok.AllArgsConstructor;

/**
 * @author enigma
 *
 */

@RestController
@AllArgsConstructor
@RequestMapping("api/goods")
public class GoodController {
	
	private GoodService goodService;
	
	//endpoint pour la creation d'un bien
	@PostMapping
	public ResponseEntity<Good> createGood(@RequestBody Good good){
		Good savedGood = goodService.createGood(good);
		return new ResponseEntity<>(savedGood, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Good> getGoodById(@PathVariable("id") Long goodId){
		Good good = goodService.getGoodById(goodId);
		return new ResponseEntity<>(good, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List <Good>> getAllGood(){
		List<Good> goods = goodService.getAllGoods();
		return new ResponseEntity<>(goods, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Good> updateGood(@PathVariable("id") Long goodId, @RequestBody Good good){
		good.setId(goodId);
		Good updatedGood = goodService.updateGood(good);
		return new ResponseEntity<>(updatedGood, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteGood(@PathVariable("id") Long goodId){
		goodService.deleteGood(goodId);
		return new ResponseEntity<>("Good successfully deleted!", HttpStatus.OK);
	}

}
