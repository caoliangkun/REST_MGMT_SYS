package edu.zufe.rms.path;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zufe.rms.model.Food;
import edu.zufe.rms.service.CartItemService;

public class TestFilePath {
	
	

	
	@Test
	public void testCart() {
		Food foo = new Food();
		foo.setId(new Long(13));
		CartItemService cartService = new CartItemService();
		boolean flag = cartService.isFoodExist(foo);
		if (flag) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
	}
}
