# CAR RENTAL BUSINESS SIMULATOR
We have designed a car rental business simulator in Java as a part of OOAD Project 3.
# NAMES OF TEAM MEMBERS :
- Aparajita Singh
- Nivetha Kesavan
- Sowjanya Achar

# INSTRUCTIONS TO RUN THE CODE :
Download all files and run main.java file. 

# LANGUAGE USED :
Java

# ENVIRONMENT USED :
IntelliJ IDEA

# DESCRIPTION :
Our car rental simulator makes uses of Observer, Factory and Decorator patterns. We have made use of Observer pattern to announce the profit made on a particular day, total profit made till that day, total rentals finished and their corresponding records. It is done in the OrderObserver.java and OrderObserverClass.java
We have used Factory pattern to instantiate all the 5 categories of Cars in our simulator. This is done in the InventoryFactory.java and Inventory.java. 
Decorator pattern is used for including the add ons like Child Seat, GPS Module, Satellite Radio Package.

# ASSUMPTIONS :
- Consumers will arrive on a random manner on each day if cars are available
- Consumers will be assigned random cars based on the Customer Type
- License plates are assumed to be alphanumeric, with the first three characters decribing the Car Type and last character is the identifier of the car within that particular type
- Economy, Standard, Luxury and SUV have 5 cars each and Minivan has 4 cars for a total of 24 cars

| Category       | Economy | Standard | Luxury | SUV | Minivan |
| -------------  |:-------:| --------:| ------:| ---:| -------:|
|Child Seat      |   $5    |  $7      | $20    | $15 |   $10   |
| GPS Module     |  $10    | $12      | $30    | $20 |   $15   |
| Satellite Radio|  $15    | $17      | $30    | $25 |   $20   |
| Per Day Rental |  $40    | $60      |$100    | $80 |   $70   |

# JUnit Testcases: 

Created a class called MyUnitTest.java under CarRental package. 
Created 10 Unit testcases to test varies classes and methods. 
Modified Main class to instantiate an object of JUnitCore to create a runner to execute the @Test methods of MyUnitTest.java.
Directed the test output to Output.txt

# REFERENCES :

https://www.tutorialspoint.com/design_pattern/factory_pattern.htm

https://howtodoinjava.com/design-patterns/creational/implementing-factory-design-pattern-in-java/

https://www.geeksforgeeks.org/decorator-pattern/

https://howtodoinjava.com/design-patterns/structural/decorator-design-pattern/

https://www.vogella.com/tutorials/DesignPatternObserver/article.html

https://www.tutorialspoint.com/junit/junit_basic_usage.htm

