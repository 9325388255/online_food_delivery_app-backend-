package com.foodApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.foodApp.model.Item;
import com.foodApp.model.Resturant;
import com.foodApp.service.ItemService;

@RestController
public class ItemController{
	
	@Autowired
	private ItemService iSer;
	
	@PostMapping("/Item")
	public Item saveItem(@Valid @RequestBody Item item) {
		
		Item i = iSer.addItem(item);
		
		return i;
	}
	
	@PutMapping("/Item")
	public ResponseEntity<Item> updateStudentHandler(@Valid @RequestBody Item item){
		
		Item updatedResturant=iSer.updateItem(item);
		
		return new ResponseEntity<Item>(updatedResturant,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/Item")
	
	public Item deleteResturant(@Valid @RequestBody Item itm){
		
		return iSer.removeItem(itm);
	}
		
	
	@GetMapping("/Item")
	public Item getItemByItemId(@Valid @RequestBody Item item) {
			
		return item;
	}

	@GetMapping("/resturant/{resturantName}")
	public ResponseEntity<List<Item>> viewResturant(String name){
		List<Item> items= iSer.viewAllItemByName(name);
	
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
}
