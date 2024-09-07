package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Department obj = new Department(1,"Books");
		Seller seller = 
				new Seller(21,"Dante","dante@gmail.com", new Date(),1500.00,obj);
		System.out.println(seller);
	}

}
