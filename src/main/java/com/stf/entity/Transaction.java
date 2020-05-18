package com.stf.entity;

import java.util.Date;

import com.stf.ientity.ITransaction;
/**
 * 
 * @author bhagwat
 *
 */
public class Transaction implements ITransaction {
	
	/**
	 * Unique transaction id
	 */
	private String transactionId;
	
	/**
	 * date of transaction in timestamp
	 */
	private Long transactionDate;
	
	/**
	 * debited account number
	 */
	private Long fromAccount;
	
	/**
	 * credited account number
	 */
	private Long toAccount;
	
	/**
	 * amount of transaction
	 */
	private Double amount;
	
	public Transaction() {
		this.transactionId = "";
		this.transactionDate = 0l;
		this.fromAccount = 0l;
		this.toAccount = 0l;
		this.amount = 0.0;
	}
	
	/**
	 * constructor to build object from file data 
	 * 
	 * @param transactionString
	 * @throws Exception
	 */
	public Transaction(String transactionString) throws Exception{
		String[] transactionSplit =  transactionString.trim().split(TransactionFile.DELIMITER);
		if(transactionSplit.length == TransactionFile.values().length){
			this.transactionId = transactionSplit[TransactionFile.TRANSACTIONID.ordinal()].trim();
			Date date = TransactionFile.DATE_FORMAT.parse(transactionSplit[TransactionFile.TRANSACTIONDATE.ordinal()].trim());
			this.transactionDate = date.getTime();
			this.fromAccount = Long.parseLong(transactionSplit[TransactionFile.FROMACCOUNT.ordinal()].trim());
			this.toAccount = Long.parseLong(transactionSplit[TransactionFile.TOACCOUNT.ordinal()].trim());
			this.amount = Double.parseDouble(transactionSplit[TransactionFile.AMOUNT.ordinal()].trim());
		}else{
			throw new Exception("Invalid transaction data");
		}
	}
	
	@Override
	public String getTransactionId() {
		return transactionId;
	}
	
	@Override
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	@Override
	public Long getTransactionDate() {
		return transactionDate;
	}
	
	@Override
	public void setTransactionDate(Long transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Override
	public Long getFromAccount() {
		return fromAccount;
	}
	
	@Override
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	
	@Override
	public Long getToAccount() {
		return toAccount;
	}
	
	@Override
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	
	@Override
	public Double getAmount() {
		return amount;
	}
	
	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Transaction hashcode will generate depends on transactionId
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}

	/**
	 * Transaction uniqueness is depends on transactionId
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
	
	

}
