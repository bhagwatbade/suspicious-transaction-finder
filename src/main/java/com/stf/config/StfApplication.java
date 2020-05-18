package com.stf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.stf.ientity.ICustomer.CustomerFile;
import com.stf.ientity.ITransaction.TransactionFile;
import com.stf.iservice.ITransactionService;

/**
 * Entry point of application
 * 
 * @author bhagwat
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.stf")
public class StfApplication implements CommandLineRunner {
	
	@Autowired
	ITransactionService transactionService;
	
	public static void main(String[] args) {
		 new SpringApplicationBuilder(StfApplication.class)
		 .bannerMode(Banner.Mode.OFF)
         .logStartupInfo(false)
         .run(args);
	}

	@Override
    public void run(String...args) {
		try {
			if(args != null && args.length == 2){
				// First argument is customer file path
				CustomerFile.CUSTOMER_FILE_PATH = args[0].trim();
				
				// Second argument is transaction file path
				TransactionFile.TRANSACTION_FILE_PATH = args[1].trim();
				
				this.transactionService.suspiciousTransaction();
			}else {
				System.out.println("Please provide customer and transaction file path in command line arguments.");
			}
		} catch (Exception e) {
			System.out.println("Somthing wents wrong...\nplease try again...\n" + e.getMessage());
		}
    }
}
