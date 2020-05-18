package com.stf.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.stf.entity.Transaction;
import com.stf.idao.ITransactionDAO;
import com.stf.ientity.ITransaction.TransactionFile;
import com.stf.imodel.ITransactionModel;
import com.stf.model.TransactionModel;
import com.stf.utils.StfUtils;

/**
 * 
 * provide transaction data to services
 * 
 * @author bhagwat
 *
 */
@Component
public class TransactionDAO implements ITransactionDAO {
	
	@Override
	public Set<ITransactionModel> getTransactions() throws Exception {
		
		Set<ITransactionModel> transactions = new LinkedHashSet<>();
		
		if(StfUtils.stringNullEmptyCheck(TransactionFile.TRANSACTION_FILE_PATH))
			return transactions;
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(TransactionFile.TRANSACTION_FILE_PATH);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			if((! TransactionFile.IS_HEADER_INCLUDE ) && line != null){
				TransactionModel transactionModel = new TransactionModel(new Transaction(line));
				transactions.add(transactionModel);
			}
			
			line = br.readLine();
			while(line != null){
				TransactionModel transactionModel = new TransactionModel(new Transaction(line));
				transactions.add(transactionModel);
				line = br.readLine();
			}
			
		} finally {
			if(br != null)
				br.close();
		}
		
		return transactions;
	}
	
	

}
