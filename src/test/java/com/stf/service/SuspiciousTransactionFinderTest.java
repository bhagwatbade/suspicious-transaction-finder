package com.stf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.stf.entity.Customer;
import com.stf.entity.Transaction;
import com.stf.imodel.ICustomerModel;
import com.stf.imodel.ITransactionModel;
import com.stf.iservice.ISuspiciousTransactionFinder;
import com.stf.model.CustomerModel;
import com.stf.model.TransactionModel;

/**
 * Test suspicious transaction service
 * 
 * @author bhagwat
 *
 */
public class SuspiciousTransactionFinderTest {

	@Test
	public void findSuspiciousTransactionTest() throws Exception {
		
		ISuspiciousTransactionFinder suspiciousTransactionFinder = new SuspiciousTransactionFinder();
		Set<ITransactionModel> suspiciousTransaction = suspiciousTransactionFinder.findSuspiciousTransaction(this.getTransactionData(), this.getCustomerData());
		assertEquals(suspiciousTransaction.size(), 7);
	}
	
	/**
	 * Dummy data for customer
	 * @return
	 * @throws Exception
	 */
	protected Map<Long, ICustomerModel> getCustomerData() throws Exception{
		Map<Long, ICustomerModel> customers = new HashMap<>();
		customers.put(10010589l, new CustomerModel(new Customer("10010589|Mr. S Kumar|Flat no. 501, Green View Park,Hinjewandi, Pune|9001045238")));
		customers.put(30045721l, new CustomerModel(new Customer("30045721|Mr. A Gupta|Flat no. 103, Ganaga nagari, Kharadi, Pune|7521457896")));
		customers.put(68748963l, new CustomerModel(new Customer("68748963|Miss K Rao|Flat no. 703, Platinum Plazza, Dhanori, Pune|8201475689")));
		customers.put(80074567l, new CustomerModel(new Customer("80074567|Mr. O Vilas|  Flat no. 501, Green View Park,Hinjewandi, Pune|9001045238")));
		customers.put(78524169l, new CustomerModel(new Customer("78524169|Mrs. N Akira|Flat no. 103, Ganaga nagari, Kharadi, Pune|7521457896")));
		return customers;
	}
	
	/**
	 * Dummy data for transaction
	 * @return
	 * @throws Exception
	 */
	private Set<ITransactionModel> getTransactionData() throws Exception{
		Set<ITransactionModel> transactions = new LinkedHashSet<>();
		transactions.add(new TransactionModel(new Transaction("T0175896345|10-Jan-20|10010589|80074567|100000")));
		transactions.add(new TransactionModel(new Transaction("T0175896346|15-Jan-20|68748963|30045721|500")));
		transactions.add(new TransactionModel(new Transaction("T0175896347|21-Jan-20|78524169|30045721|6500")));
		transactions.add(new TransactionModel(new Transaction("T0175896348|26-Jan-20|80074567|68748963|8700")));
		transactions.add(new TransactionModel(new Transaction("T0175896349|31-Jan-20|30045721|78524169|4200")));
		transactions.add(new TransactionModel(new Transaction("T0175896350|4-Feb-20|80074567|10010589|8950")));
		transactions.add(new TransactionModel(new Transaction("T0175896351|11-Feb-20|78524169|68748963|20000")));
		transactions.add(new TransactionModel(new Transaction("T0175896352|15-Feb-20|68748963|10010589|50000")));
		transactions.add(new TransactionModel(new Transaction("T0175896353|18-Feb-20|30045721|78524169|28000")));
		transactions.add(new TransactionModel(new Transaction("T0175896354|23-Feb-20|10010589|78524169|34000")));
		transactions.add(new TransactionModel(new Transaction("T0175896355|3-Mar-20|68748963|10010589|75000")));
		transactions.add(new TransactionModel(new Transaction("T0175896356|9-Mar-20|78524169|30045721|64000")));
		transactions.add(new TransactionModel(new Transaction("T0175896357|19-Mar-20|78524169|10010589|23000")));
		transactions.add(new TransactionModel(new Transaction("T0175896358|25-Mar-20|10010589|80074567|89000")));
		return transactions;
	}

}
