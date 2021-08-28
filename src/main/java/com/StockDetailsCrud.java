package com;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.onetoone.StockBean;
import com.bean.onetoone.StockDetailsBean;

public class StockDetailsCrud {

	public static void main(String[] args) {
		new StockDetailsCrud().addStock();
	}

	void addStock() {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction  tx = session.beginTransaction();
		
		StockBean stock = new StockBean();
		stock.setStockName("Reliance");
		stock.setStockType("LargeCap");
		stock.setStockCode("RIL");
		
		StockDetailsBean stockDetail = new StockDetailsBean();
		stockDetail.setCurrentPrice(2070);
		stockDetail.setMaxPrice(2350);
		stockDetail.setMinPrice(1256);
		
		stock.setStockDetails(stockDetail);
		stockDetail.setStock(stock);
		
		session.persist(stock);
		tx.commit();
		session.close();
	}
}
