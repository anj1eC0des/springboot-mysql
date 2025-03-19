package com.example.persistenceDemo;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {
	private final JdbcTemplate jdbc;
	public PurchaseRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	public void storePurchase(Purchase purchase) {
		String sql="INSERT INTO purchase(product,price) VALUES (?,?)";
		jdbc.update(sql,purchase.getProduct(),purchase.getPrice());
	}
	public List<Purchase> findAllPurchases(){
		String sql="SELECT * FROM purchase";
		RowMapper<Purchase> purchaseMapper=(r,i)->{
			Purchase rowObject=new Purchase();
			rowObject.setId(r.getInt("id"));
			rowObject.setProduct(r.getString("product"));
			rowObject.setPrice(r.getBigDecimal("price"));
			return rowObject;
		};
		return jdbc.query(sql, purchaseMapper);
	}
}
