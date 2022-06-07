package com.foodApp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodApp.model.Item;
import com.foodApp.model.Resturant;
import com.foodApp.repository.ItemDao;
import com.foodApp.repository.ResturantDao;



@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ResturantDao resturantDao;

	@Override
	public Item addItem(Item i) {
		// TODO Auto-generated method stub
		return itemDao.save(null);
	}

	@Override
	public Item updateItem(Item i) {
		// TODO Auto-generated method stub
		java.util.Optional<Item> optI = itemDao.findById(i.getItemId());
				
		if(optI.isPresent()) {
			
			Item existingItem= optI.get();
			
			return itemDao.save(i);
		}
		return null;
	}
	


	@Override
	public Item removeItem(Integer i) {
java.util.Optional<Item> optI = itemDao.findById(i);
		
		if(optI.isPresent()) {
			
			Item existingResturant= optI.get();
			
			itemDao.delete(existingResturant);
		   
		   return existingResturant;
		}
		return null;
	}

	@Override
	public Item viewItem(Integer i) {
		java.util.Optional<Item> optI = itemDao.findById(i);
		if(optI.isPresent()) {
			
			Item existingResturant= optI.get();
			
		   return existingResturant;
		}
		return null;
	}

	@Override
	public List<Item> viewAllItemResturant(Resturant res) {
		List<Item> items = itemDao.findAll();
		
//		if(items.size()==0) {
//			throw new NotFoundException("Beneficiaries not found");
//		}
		return items;
	}

	@Override
	public List<Item> viewAllItemByName(String name) {
		
		Resturant n =  resturantDao.findByResturantName(name);
		
		if(n!= null) {
			
			return n.getItemlist();
		}
		return null;
		
	}
}
	
	
	
	
	
	
	
	
