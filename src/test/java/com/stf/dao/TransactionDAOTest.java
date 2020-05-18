package com.stf.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.stf.idao.ITransactionDAO;
import com.stf.ientity.ITransaction.TransactionFile;
import com.stf.imodel.ITransactionModel;


public class TransactionDAOTest {

	private static String TRANSACTION_FILE_PATH = "src/test/resources/transactions.txt";
	
	/**
	 * Test for checking transaction file reading
	 * 
	 * @throws Exception
	 */
	@Test
	public void getTransactions() throws Exception{
		TransactionFile.TRANSACTION_FILE_PATH = TRANSACTION_FILE_PATH;
		
		ITransactionDAO transactionDAO = new TransactionDAO();
		Set<ITransactionModel> transactions = transactionDAO.getTransactions();
		assertEquals(transactions.size(), 14);
		
	}
}
