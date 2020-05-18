package com.stf.model;

import com.stf.entity.Transaction;
import com.stf.ientity.ITransaction;
import com.stf.imodel.ITransactionModel;

public class TransactionModel implements ITransactionModel {
	
	private ITransaction transaction;
	
	public TransactionModel() {
		this.transaction = new Transaction();
	}
	
	public TransactionModel(ITransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String getTransactionId() {
		return this.transaction.getTransactionId();
	}

	@Override
	public void setTransactionId(String transactionId) {
		this.transaction.setTransactionId(transactionId);
	}

	@Override
	public Long getTransactionDate() {
		return this.transaction.getTransactionDate();
	}

	@Override
	public void setTransactionDate(Long transactionDate) {
		this.transaction.setTransactionDate(transactionDate);
	}

	@Override
	public Long getFromAccount() {
		return this.transaction.getFromAccount();
	}

	@Override
	public void setFromAccount(Long fromAccount) {
		this.transaction.setFromAccount(fromAccount);
	}

	@Override
	public Long getToAccount() {
		return this.transaction.getToAccount();
	}

	@Override
	public void setToAccount(Long toAccount) {
		this.transaction.setToAccount(toAccount);
	}

	@Override
	public Double getAmount() {
		return this.transaction.getAmount();
	}

	@Override
	public void setAmount(Double amount) {
		this.transaction.setAmount(amount);
	}

}
