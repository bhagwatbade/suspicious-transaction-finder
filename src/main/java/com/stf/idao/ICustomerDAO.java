package com.stf.idao;

import java.util.Map;

import com.stf.imodel.ICustomerModel;

/**
 * provide customer data to services
 * @author bhagwat
 *
 */
public interface ICustomerDAO extends IDAO {

	/**
	 * read customer file data
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<Long, ICustomerModel> getCustomers() throws Exception;
}
