package model.dao;

import model.entities.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDAO createSellerDAO() {
		return new SellerDaoJDBC();
	}
	
}
