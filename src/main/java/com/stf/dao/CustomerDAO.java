package com.stf.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.stf.entity.Customer;
import com.stf.idao.ICustomerDAO;
import com.stf.ientity.ICustomer.CustomerFile;
import com.stf.imodel.ICustomerModel;
import com.stf.model.CustomerModel;
import com.stf.utils.StfUtils;

/**
 * provide customer data to services
 * 
 * @author bhagwat
 *
 */
@Component
public class CustomerDAO implements ICustomerDAO {
	
	@Override
	public Map<Long, ICustomerModel> getCustomers() throws Exception {
		
		Map<Long, ICustomerModel> customers = new HashMap<>();
		
		if(StfUtils.stringNullEmptyCheck(CustomerFile.CUSTOMER_FILE_PATH))
			return customers;
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(CustomerFile.CUSTOMER_FILE_PATH);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			if( (! CustomerFile.IS_HEADER_INCLUDE) && line != null){
				CustomerModel customerModel = new CustomerModel(new Customer(line));
				customers.put(customerModel.getAccountNo(),customerModel);
			}
				 
			line = br.readLine();
			while(line != null){
				CustomerModel customerModel = new CustomerModel(new Customer(line));
				customers.put(customerModel.getAccountNo(),customerModel);
				line = br.readLine();
			}
		} finally {
			if(br != null)
				br.close();
		}
		
		return customers;
	}
	
}
