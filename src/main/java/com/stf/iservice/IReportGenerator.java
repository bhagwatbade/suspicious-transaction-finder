package com.stf.iservice;

import java.util.Set;

import com.stf.imodel.ITransactionModel;

/**
 * Generate report of suspicious transaction
 * @author bhagwat
 *
 */
public interface IReportGenerator extends IService {
	/**
	 * Enum to find out month.
	 * @author bhagwat
	 *
	 */
	public enum Month {
		JAN("Jan"), FEB("Feb"), MAR("Mar"), APR("Apr"), MAY("May"), JUN("Jun"), JUL("Jul"), AUG("Aug"), 
		SEP("Sep"), OCT("Oct"), NOV("Nov"), DEC("Dec");

		private String month;

		private Month(String month) {
			this.month = month;
		}
		
		public String getMonth(){
			return this.month;
		}

		private static Month[] values = Month.values();
		
		public static String getMonth(int ordinal){
			return values[ordinal].getMonth();
		}
	}
	
	/**
	 * generate report for suspicious transaction
	 * @param suspiciousTransactions
	 */
	public void generateSuspiciousTransactionReport(Set<ITransactionModel> suspiciousTransactions);

}
