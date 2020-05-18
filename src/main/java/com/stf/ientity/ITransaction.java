package com.stf.ientity;

import java.text.SimpleDateFormat;

/**
 * Entity represent bank transaction 
 * 
 * @author bhagwat
 *
 */
public interface ITransaction extends IEntity {
	
	/**
	 * Transaction file configuration
	 * 
	 * @author bhagwat
	 *
	 */
	public enum TransactionFile {
		// sequence must be same as column of transaction data file
		TRANSACTIONID, TRANSACTIONDATE, FROMACCOUNT, TOACCOUNT, AMOUNT;
		
		// delimiter of transaction file
		public static String DELIMITER = "\\|";
		
		// date format of transaction date
		public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yy");
		
		//check file with header
		public static boolean IS_HEADER_INCLUDE = true;
		
		// transaction file path
		public static String TRANSACTION_FILE_PATH = "";
	}

	/**
	 * return unique transaction id for transaction
	 * @return
	 */
	public String getTransactionId();
	
	/**
	 * set unique transaction id for transaction
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId);
	
	/**
	 * return date for transaction in timestamp
	 * @return
	 */
	public Long getTransactionDate();
	
	/**
	 * set transaction date in timestamp
	 * @param transactionDate
	 */
	public void setTransactionDate(Long transactionDate);
	
	/**
	 * return debited account number
	 * @return
	 */
	public Long getFromAccount();
	
	/**
	 * set debited account number
	 * @param fromAccount
	 */
	public void setFromAccount(Long fromAccount);
	
	/**
	 * return credited account number
	 * @return
	 */
	public Long getToAccount();
	
	/**
	 * set credited account number
	 * @param toAccount
	 */
	public void setToAccount(Long toAccount);
	
	/**
	 * return transaction amount
	 * @return
	 */
	public Double getAmount();
	
	/**
	 * set transaction amount
	 * @param amount
	 */
	public void setAmount(Double amount);

}
