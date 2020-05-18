package com.stf.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.stf.idao.ICustomerDAO;
import com.stf.ientity.ICustomer.CustomerFile;
import com.stf.imodel.ICustomerModel;

/**
 * Test for CustomerDAO
 * @author bhagwat
 *
 */
public class CustomerDAOTest {
	
	private static String CUSTOMER_FILE_PATH = "src/test/resources/customers.txt";

	/**
	 * Test for checking customer file reading
	 * @throws Exception
	 */
	@Test
	public void getCustomersTest() throws Exception{
		
		CustomerFile.CUSTOMER_FILE_PATH = CUSTOMER_FILE_PATH;
		
		ICustomerDAO customerDAO = new CustomerDAO();
		Map<Long, ICustomerModel> customers = customerDAO.getCustomers();
		assertEquals(customers.size(), 5);
	}
	
}
