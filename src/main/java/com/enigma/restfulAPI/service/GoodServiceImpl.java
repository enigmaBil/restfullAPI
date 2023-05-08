/**
 * 
 */
package com.enigma.restfulAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enigma.restfulAPI.entity.Good;
import com.enigma.restfulAPI.repository.GoodRepository;

import lombok.AllArgsConstructor;

/**
 * @author enigma
 *
 */


@Service
@AllArgsConstructor
public class GoodServiceImpl implements GoodService {

	private GoodRepository goodRepository;
	
	
	@Override
	public Good createGood(Good good) {
		return goodRepository.save(good);
	}

	@Override
	public Good getGoodById(Long goodId) {
		Optional<Good> optionalGood = goodRepository.findById(goodId);
		return optionalGood.get();
	}

	@Override
	public List<Good> getAllGoods() {
		return goodRepository.findAll();
	}

	@Override
	public Good updateGood(Good good) {
		Good existingGood = goodRepository.findById(good.getId()).get();
		existingGood.setName(good.getName());
		existingGood.setPrice(good.getPrice());
		existingGood.setAge(good.getAge());
		Good updatedGood = goodRepository.save(existingGood);
		return updatedGood;
	}

	@Override
	public void deleteGood(Long goodId) {
		goodRepository.deleteById(goodId);
	}

}
