package com.stf.idao;

import java.util.Set;

import com.stf.imodel.ITransactionModel;

/**
 * provide transaction data to services
 * @author bhagwat
 *
 */
public interface ITransactionDAO extends IDAO {
	
	/**
	 * read transaction file data 
	 * @return
	 * @throws Exception
	 */
	public Set<ITransactionModel> getTransactions() throws Exception;

}
