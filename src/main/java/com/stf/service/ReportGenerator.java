package com.stf.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.stf.imodel.ITransactionModel;
import com.stf.iservice.IReportGenerator;

/**
 * generate report
 * 
 * @author bhagwat
 *
 */
@Service
public class ReportGenerator implements IReportGenerator {

	@Override
	public void generateSuspiciousTransactionReport(Set<ITransactionModel> suspiciousTransactions) {
		
		Map<Integer, List<String>> transactionByMonth = new TreeMap<>();
		Map<Long, List<Long>> suspiciousAccounts = new LinkedHashMap<Long, List<Long>>();
		
		
		Calendar cal = Calendar.getInstance();
		suspiciousTransactions.stream().forEach(suspiciousTransaction -> {
			//Transaction by month
			cal.setTime(new Date(suspiciousTransaction.getTransactionDate()));
			int month = cal.get(Calendar.MONTH);
			if(transactionByMonth.containsKey(month)){
				List<String> transactionIdByMonth = transactionByMonth.get(month);
				transactionIdByMonth.add(suspiciousTransaction.getTransactionId());
			}else {
				List<String> transactionIdByMonth = new ArrayList<>();
				transactionIdByMonth.add(suspiciousTransaction.getTransactionId());
				transactionByMonth.put(month, transactionIdByMonth);
			}
			
			// suspicious accounts 
			Long uniqueKey = suspiciousTransaction.getFromAccount() + suspiciousTransaction.getToAccount();
			if(! suspiciousAccounts.containsKey(uniqueKey)){
				List<Long> suspiciousAccountInfo = new ArrayList<>(2);
				suspiciousAccountInfo.add(suspiciousTransaction.getFromAccount());
				suspiciousAccountInfo.add(suspiciousTransaction.getToAccount());
				suspiciousAccounts.put(uniqueKey, suspiciousAccountInfo);
			}
			
		});
		
		// print transaction by month
		transactionByMonth.forEach((month, transactions) -> {
			System.out.println("For the Month of " + IReportGenerator.Month.getMonth(month) + ":");
			System.out.println("Suspicious Transactions :");
			transactions.forEach(transactionId -> System.out.println(transactionId));
			System.out.println("");
		});
		
		// print suspicious accounts
		System.out.println("Suspicious Accounts");
		suspiciousAccounts.values().stream().forEach(suspiciousAccount -> System.out.println(suspiciousAccount));
	}

}
