package com.foodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.model.Item;
import com.foodApp.repository.CartDao;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ResturantServiceImpl rsi;

	
//	@Autowired
//	private UserServiceImpl usi;
//	
	
	@Override
	public Item getItembyId(Integer resturantId, Integer itemId) {
		
		List<Item> items =  rsi.getListofItembyResturantId(rest_Id);
		
		for(Integer i=0; i<items.size(); i++) {
			if(items.get(i).getItemId() == itemId) {
				return items.get(i);
			}
		}
		
		throw new ItemUnavailable("List is Empty..!");
		
	}

	@Override
	public List<Item> getCartId(Integer cart_Id, Integer user_Id) {
		
		Optional<Cart> c = cr.findById(cart_Id);
		
		if(c.isPresent()) {
			Cart cart = c.get();
			
			cart.getUser().getUserId();
			
			cart.setLiItem(null);
		}
		
		return null;
	}

	@Override
	public Cart storeItemwithUser(Integer user_Id, Integer cart_Id, Integer item_Id,Integer quantity) throws ItemUnavailable {


		Item i = getItembyId(cart_Id, item_Id);
		
		User u = uii.findUserById(user_Id);
		
		
		
		
		if( u!= null ) {
			
			Optional<Cart> opt= cr.findById(cart_Id);
			
			
			if(opt.isPresent()) {
				
				Cart existingCart= opt.get();
				
				List<Item> it =   existingCart.getLiItem();
				
				it.add(i);
			        
				existingCart.setLiItem(it);
				
				
				cr.save(existingCart);
				
				return existingCart;
				
			}
			else{
				throw new ItemUnavailable("Cart is Empty..!");
			}
		}
		
		else{
			throw new ItemUnavailable("Please enter correct credentials...");
		}
	}

	@Override
	public Cart getCartById(Integer cart_Id) {

		Optional<Cart> ob = cr.findById(cart_Id);
		
		if(ob.isPresent()) {
			
			Cart r = ob.get();
			
			return r;
		}
		
		return null;
	}

	@Override
	public String delivery(Integer cartId ) {
		//Cart ct = storeItemwithUser(userId, cartId, itemId);
		Cart  cg = getCartById(cartId);
	  List<Item>

}
