package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Image;
import edu.zufe.rms.repository.ImageRepository;

@Service
public class imageService {
	@Autowired
	private ImageRepository imgRepo;

	public Image findById(long id) {
		Optional<Image> img = imgRepo.findById(Long.valueOf(id));
		if (img.isPresent()) 
			return img.get();
		return null;
	}
	
	public List<Image> findAll() {
		List<Image> images = new ArrayList<>();
		for (Image img : imgRepo.findAll()) {
			images.add(img);
		}
		return images;
	}
}
