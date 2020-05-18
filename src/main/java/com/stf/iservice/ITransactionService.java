package com.stf.iservice;

/**
 * Transaction service
 * @author bhagwat
 *
 */
public interface ITransactionService extends IService {

	/**
	 * find suspicious transaction and generate report
	 * 
	 * @throws Exception
	 */
	public void suspiciousTransaction() throws Exception;
	
}
