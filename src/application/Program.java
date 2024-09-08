package application;

import java.text.ParseException;
import java.util.Locale;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;
import model.entities.impl.SellerDaoJDBC;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
	
		SellerDAO sellerDao = DaoFactory.createSellerDAO();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
	}

}
