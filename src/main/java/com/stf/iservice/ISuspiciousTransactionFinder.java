package com.stf.iservice;

import java.util.Map;
import java.util.Set;

import com.stf.imodel.ICustomerModel;
import com.stf.imodel.ITransactionModel;

/**
 * Find suspicious transaction 
 * @author bhagwat
 *
 */
public interface ISuspiciousTransactionFinder extends IService {
	
	/**
	 * find suspicious transaction depend on criteria
	 * @param transactions
	 * @return
	 * @throws Exception
	 */
	public Set<ITransactionModel> findSuspiciousTransaction(Set<ITransactionModel> transactions, Map<Long, ICustomerModel> customers) throws Exception;

}
