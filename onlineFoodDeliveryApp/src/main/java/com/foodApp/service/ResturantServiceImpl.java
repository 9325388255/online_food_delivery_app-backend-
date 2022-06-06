package com.foodApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodApp.model.Resturant;
import com.foodApp.repository.ItemDao;
import com.foodApp.repository.ResturantDao;

@Service
public class ResturantServiceImpl implements ResturantService{

	@Autowired
	private ResturantDao rDao;
	@Autowired
	private ItemDao iDao;
	
	@Override
	public Resturant addResturant(Resturant res) {
		// TODO Auto-generated method stub
		return rDao.save(res);
	}
	@Override
	public Resturant updateResturant(Resturant res) {
		// TODO Auto-generated method stub
		
				Optional<Resturant> optR = rDao.findById(res.getResturantId());
				
				if(optR.isPresent()) {
					
					Resturant existingResturant= optR.get();
					
					return rDao.save(res);
				}
				return null;
	}

	@Override
	public Resturant removeResturant(Resturant res) {
		Optional<Resturant> optR = rDao.findById(res.getResturantId());
		
		if(optR.isPresent()) {
			
			Resturant existingResturant= optR.get();
			
			
		   rDao.delete(existingResturant);
		   
		   return res;
		}
		return null;
	}

//		Optional<Resturant> optR = rdao.findById(res.getResturantId());
//		
//		if(optR.isPresent()) {
//			
//			Resturant existingResturant= optR.get();
//			
//			return rdao.save(res);
//		}

		

	@Override
	public Resturant viewResturantByResturantId(Resturant res) {
   Optional<Resturant> optR = rDao.findById(res.getResturantId());
		
		if(optR.isPresent()) {
			
			Resturant existingResturant= optR.get();
			
		    return existingResturant;
					
		}
		return null;
	}

	@Override
	public List<Resturant> viewNearByResturant(String location) {
		
		return null;
	}

	@Override
	public List<Resturant> viewResturantByItemName(String name) {
		
		return null;
	}
}
