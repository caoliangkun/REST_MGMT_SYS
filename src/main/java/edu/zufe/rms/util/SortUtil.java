package edu.zufe.rms.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.zufe.rms.model.Order;
import edu.zufe.rms.model.Payment;
import edu.zufe.rms.model.Table;

public class SortUtil {

	private static List Payment;

	public static void sortByDate(List<Order> orders) {
		Collections.sort(orders, new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				return (int) (o2.getCreatedAt().getTime() - o1.getCreatedAt().getTime());
			}
			
		});
	}

	public static void sortByPayDate(List<Payment> payments) {
		Collections.sort(payments, new Comparator<Payment>() {

			@Override
			public int compare(edu.zufe.rms.model.Payment o1, edu.zufe.rms.model.Payment o2) {
				
				return (int) (o2.getPayAt().getTime() - o1.getPayAt().getTime());
			}
			
		});
		
	}

	public static void sortByStatus(List<Table> tables) {
		Collections.sort(tables, new Comparator<Table>() {
			@Override
			public int compare(Table o1, Table o2) {
				return o1.getTableStatus().compareTo(o2.getTableStatus());
			}
			
		});
		
	}

}
