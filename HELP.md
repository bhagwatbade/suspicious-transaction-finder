# Project description
**Suspicious Transaction Finder (STF)**
* some of the basic feature:
	* Find suspicious transactions
	* Generate report of suspicious transaction

### Technology stack
* Java 8
* Spring Boot v2.3.0
* Junit 5

### build tool
Maven 3.6.3

### Assumptions
* Application always get data from txt file. At the time of running application we have to provide customer and transaction file paths.
* Text file format like header(i.e. column name), delimiter,date format remain same. if any chages happened we need to do changes in application.
* Transaction file contaion quarterly transaction only. If we provide more transaction then it will generate report for all transactions.
* Report generation foramt is fixed as per given reqirement, if any chages happened we need to do changes in application.
* Customer uniqueness is depend on account number.
* Transaction uniqueness is depends on transaction id.
* Application only trim customer address and not make any changes in it.
* **If there is no customer found for debited account or for credited account then such transaction treated as suspious transactions.**
* If we won't get any suspious transaction then we show message **No suspicious transactions found** in response.

### How to run project
* Go to root folder where **pom.xml** keept.
* Run command **mvn package**
* Run command **java -jar target/STF-1.0.jar {customer_file_path} {transaction_file_path}**
* First  argument is customer file path and second argument is transaction file path.
* Demo file available in **src/test/resources** folder.
* Quick run command : **java -jar target/STF-1.0.jar src/test/resources/customers.txt src/test/resources/transactions.txt** 