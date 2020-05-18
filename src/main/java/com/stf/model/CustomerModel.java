package com.stf.model;

import com.stf.entity.Customer;
import com.stf.ientity.ICustomer;
import com.stf.imodel.ICustomerModel;

/**
 * 
 * @author bhagwat
 *
 */
public class CustomerModel implements ICustomerModel {
	
	private ICustomer customer;
	
	public CustomerModel() {
		this.customer = new Customer();
	}
	
	public CustomerModel(ICustomer customer) {
		this.customer = customer;
	}
	
	@Override
	public Long getAccountNo() {
		return this.customer.getAccountNo();
	}

	@Override
	public void setAccountNo(Long accountNo) {
		this.customer.setAccountNo(accountNo);
	}

	@Override
	public String getName() {
		return this.customer.getName();
	}

	@Override
	public void setName(String name) {
		this.customer.setName(name);
	}

	@Override
	public String getAddress() {
		return this.customer.getAddress();
	}

	@Override
	public void setAddress(String address) {
		this.customer.setAddress(address);
	}

	@Override
	public Long getPhoneNo() {
		return this.customer.getPhoneNo();
	}

	@Override
	public void setPhoneNo(Long phoneNo) {
		this.customer.setPhoneNo(phoneNo);
	}

}
