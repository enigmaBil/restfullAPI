/**
 * 
 */
package com.enigma.restfulAPI.service;

import java.util.List;

import com.enigma.restfulAPI.entity.Good;

/**
 * @author enigma
 *interface de gestion des biens, elle permet de definir le crud sur les biens
 */
public interface GoodService {

	
	Good createGood(Good good);
	
	Good getGoodById(Long goodId);
	
	List<Good> getAllGoods();
	
	Good updateGood(Good good);
	
	void deleteGood(Long goodId);
}
