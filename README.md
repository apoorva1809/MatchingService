# MatchingService

Technologies Used

Java 1.8

Spring Boot 1.3.x

Spring Framework 4.3.x

Hibernate4

Kafka2.2

Zookeeper

Oracle DB XE





Steps to Run The application


1) After cloning the project download ojdbc jar & put it in class path

2) Modify configOracleDao.xml config file hibernate property hibernate.hbm2ddl.auto to create, which will automatically creates all the tables in Oracle or any db configured.(This step is happens first time to create tables)

3) Insert data into tables criteria, CustPendingIssues, Technicians

4) Change hibernate.hbm2ddl.auto in hibernate to update

5) Install zookeeper & kafka to run in local & create users topic for testing purpose

6) Run the application once its started on tomcat port - 6062 
     Use any rest Client or browser to call API - localhost:6062/AssignTechnicians
	 

7) Once everything is run . Please check the table technicianassigned with Reservation details & response.







