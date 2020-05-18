package com.stf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stf.entity.Transaction;
import com.stf.imodel.ITransactionModel;
import com.stf.iservice.IReportGenerator;
import com.stf.model.TransactionModel;

/**
 * Generate suspicious transactions report
 * 
 * @author bhagwat
 *
 */
public class ReportGeneratorTest {
	
	/**
	 * To read console
	 */
	private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeEach
    public void before() throws Throwable {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }
 
    @AfterEach
    public void after() {
        System.setOut(sysOut);
    }
 
    public String asString() {
        return outContent.toString();
    }
	
	@Test
	public void generateSuspiciousTransactionReport() throws Exception{
		IReportGenerator reportGenerator = new ReportGenerator();
		reportGenerator.generateSuspiciousTransactionReport(this.getSuspiciousTransactionData());
		String report = outContent.toString();
		assertEquals(report, this.consoleOutput());
	}
	
	/**
	 * Dummy suspicious transaction
	 * @return
	 * @throws Exception
	 */
	private Set<ITransactionModel> getSuspiciousTransactionData() throws Exception{
		Set<ITransactionModel> transactions = new LinkedHashSet<>();
		transactions.add(new TransactionModel(new Transaction("T0175896345|10-Jan-20|10010589|80074567|100000")));
		transactions.add(new TransactionModel(new Transaction("T0175896347|21-Jan-20|78524169|30045721|6500")));
		transactions.add(new TransactionModel(new Transaction("T0175896349|31-Jan-20|30045721|78524169|4200")));
		transactions.add(new TransactionModel(new Transaction("T0175896350|4-Feb-20|80074567|10010589|8950")));
		transactions.add(new TransactionModel(new Transaction("T0175896353|18-Feb-20|30045721|78524169|28000")));
		transactions.add(new TransactionModel(new Transaction("T0175896356|9-Mar-20|78524169|30045721|64000")));
		transactions.add(new TransactionModel(new Transaction("T0175896358|25-Mar-20|10010589|80074567|89000")));
		return transactions;
	}

	/**
	 * actual report which print on console
	 * 
	 * @return
	 */
	private String consoleOutput() {
		StringBuilder sb = new StringBuilder();

		sb.append("For the Month of Jan:\n");
		sb.append("Suspicious Transactions :\n");
		sb.append("T0175896345\n");
		sb.append("T0175896347\n");
		sb.append("T0175896349\n");

		sb.append("\n");

		sb.append("For the Month of Feb:\n");
		sb.append("Suspicious Transactions :\n");
		sb.append("T0175896350\n");
		sb.append("T0175896353\n");

		sb.append("\n");

		sb.append("For the Month of Mar:\n");
		sb.append("Suspicious Transactions :\n");
		sb.append("T0175896356\n");
		sb.append("T0175896358\n");

		sb.append("\n");

		sb.append("Suspicious Accounts\n");
		sb.append("[10010589, 80074567]\n");
		sb.append("[78524169, 30045721]\n");

		return sb.toString();
	}
	
	@Test
	public void noSuspiciousTransactionReport() throws Exception{
		IReportGenerator reportGenerator = new ReportGenerator();
		reportGenerator.generateSuspiciousTransactionReport(new HashSet<ITransactionModel>(1));
		assertEquals(outContent.toString(), "No suspicious transactions found\n");
	}
	
}
