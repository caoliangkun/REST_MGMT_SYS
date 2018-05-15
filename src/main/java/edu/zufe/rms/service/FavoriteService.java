package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.Favorite;
import edu.zufe.rms.repository.FavoriteRepository;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteRepository fvtRepo;

	public Favorite save(Favorite fvt) {
		return fvtRepo.save(fvt);

	}

	public boolean exsit(Favorite fvt) {
		long custId = fvt.getCustomer().getId();
		long foodId = fvt.getFood().getId();
		for (Favorite f : fvtRepo.findAll()) {
			long cid = f.getCustomer().getId();
			long fid = f.getFood().getId();
			if (custId == cid && foodId == fid)
				return true;
		}
		return false;
	}

	public List<Favorite> findAll(Customer cust) {
		List<Favorite> favorites = new ArrayList<>();
		for (Favorite f : fvtRepo.findAll()) {
			if (f.getCustomer().getId().compareTo(cust.getId()) == 0)
				favorites.add(f);
		}
		return favorites;
	}

	public void deleteById(Long id) {
		fvtRepo.deleteById(id);
		
	}

}
