package com.stf.service;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stf.idao.ICustomerDAO;
import com.stf.idao.ITransactionDAO;
import com.stf.imodel.ICustomerModel;
import com.stf.imodel.ITransactionModel;
import com.stf.iservice.IReportGenerator;
import com.stf.iservice.ISuspiciousTransactionFinder;
import com.stf.iservice.ITransactionService;

/**
 * provide transaction related services
 * 
 * @author bhagwat
 *
 */
@Service
public class TransactionService implements ITransactionService {
	
	@Autowired
	ICustomerDAO customerDAO;
	
	@Autowired
	ITransactionDAO transactionDAO;
	
	@Autowired
	ISuspiciousTransactionFinder suspiciousTransactionFinder;
	
	@Autowired
	IReportGenerator reportGenerator;
	
	@Override
	public void suspiciousTransaction() throws Exception {
		Map<Long, ICustomerModel> customers = customerDAO.getCustomers();
		Set<ITransactionModel> transactions = this.transactionDAO.getTransactions();
		Set<ITransactionModel> suspiciousTransactions = this.suspiciousTransactionFinder.findSuspiciousTransaction(transactions, customers);
		this.reportGenerator.generateSuspiciousTransactionReport(suspiciousTransactions);
	}

}
