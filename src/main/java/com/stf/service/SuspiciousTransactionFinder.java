package com.stf.service;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stf.idao.ICustomerDAO;
import com.stf.imodel.ICustomerModel;
import com.stf.imodel.ITransactionModel;
import com.stf.iservice.ISuspiciousTransactionFinder;

/**
 * 
 * find suspicious transaction depend on criteria
 * 
 * @author bhagwat
 *
 */
@Service
public class SuspiciousTransactionFinder implements ISuspiciousTransactionFinder {
	
	@Override
	public Set<ITransactionModel> findSuspiciousTransaction(Set<ITransactionModel> transactions, Map<Long, ICustomerModel> customers) throws Exception {
		Set<ITransactionModel> suspiciousTransaction = new LinkedHashSet<>(1);
		
		suspiciousTransaction = transactions.stream().filter(transaction -> {
			boolean test = false;
			ICustomerModel fromCustomer = customers.get(transaction.getFromAccount());
			ICustomerModel toCustomer = customers.get(transaction.getToAccount());
			if ((fromCustomer.getAddress().equals(toCustomer.getAddress()))
					&& (fromCustomer.getPhoneNo().equals(toCustomer.getPhoneNo())))
				test = true;
			return test;
		}).collect(Collectors.toCollection(LinkedHashSet::new ));
		
		return suspiciousTransaction;
	}

}
