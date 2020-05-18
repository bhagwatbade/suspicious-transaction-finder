package com.stf.ientity;

/**
 * Entity represent customer of bank
 * 
 * @author bhagwat
 *
 */
public interface ICustomer extends IEntity {
	
	/**
	 * Customer file configuration
	 * 
	 * @author bhagwat
	 *
	 */
	public enum CustomerFile {
		// sequence must be same as column of customer data file
		ACCOUNT, NAME, ADDRESS, PHONENUMBER;
		
		//delimiter of customer data file
		public static String DELIMITER = "\\|";
		
		//check file with header
		public static boolean IS_HEADER_INCLUDE = true;
		
		// customer file path
		public static String CUSTOMER_FILE_PATH = "";
	}

	/**
	 * return unique account number for each customer
	 * @param accountNo
	 */
	public Long getAccountNo();
	
	/**
	 * set unique account number for each customer
	 * @return
	 */
	public void setAccountNo(Long accountNo);
	
	/**
	 * return name of customer
	 * @return
	 */
	public String getName();
	
	/**
	 * set name of customer
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * return address of customer
	 * @return
	 */
	public String getAddress();
	
	/**
	 * set address of customer
	 * @param address
	 */
	public void setAddress(String address);
	
	/**
	 * return phone number of customer 
	 * @return
	 */
	public Long getPhoneNo();
	
	/**
	 * set phone number of customer
	 * @param phoneNo
	 */
	public void setPhoneNo(Long phoneNo);
	
}
