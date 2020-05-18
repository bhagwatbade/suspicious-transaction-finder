package com.stf.entity;

import com.stf.ientity.ICustomer;

/**
 * 
 * @author bhagwat
 *
 */
public class Customer implements ICustomer {
	
	/**
	 * Unique account number for each customer
	 */
	private Long accountNo;
	
	/**
	 * name of customer
	 */
	private String name;
	
	/**
	 * address of customer
	 */
	private String address;
	
	/**
	 * phone number of customer
	 */
	private Long phoneNo;
	
	public Customer() {
		this.accountNo = 0l;
		this.name = "";
		this.address = "";
		this.phoneNo = 0l;
	}
	
	/**
	 * constructor to build object from file data 
	 * 
	 * @param customerString
	 * @throws Exception
	 */
	public Customer(String customerString) throws Exception{
		try {
			String[] customerSplit = customerString.trim().split(CustomerFile.DELIMITER);
			if(customerSplit.length == CustomerFile.values().length){
				this.accountNo = Long.parseLong(customerSplit[CustomerFile.ACCOUNT.ordinal()].trim());
				this.name = customerSplit[CustomerFile.NAME.ordinal()].trim();
				this.address = customerSplit[CustomerFile.ADDRESS.ordinal()].trim();
				this.phoneNo = Long.parseLong(customerSplit[CustomerFile.PHONENUMBER.ordinal()].trim());
			}else{
				throw new Exception("Invalid customer data");
			}
		} catch (Exception e) {
			throw new Exception("Invalid customer data");
		}
	}
	
	@Override
	public Long getAccountNo() {
		return accountNo;
	}
	
	@Override
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getAddress() {
		return address;
	}
	
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public Long getPhoneNo() {
		return phoneNo;
	}
	
	@Override
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * customer hashcode will generate depends on account number 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}

	/**
	 * customer uniqueness is depends on account number 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

	
}
