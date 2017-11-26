#README
# Restaurant Billing System
> 
> Neeta Pandey | neetaparul.pandey@gmail.com 
> 
------------------------------------------------------------
## Intent

In an effort to demonstrate Design Principles our Restaurant Billing System is a Single Page Application using Spring Boot, BDD approach utilizing Cucumber, Selenium. On client side, its inspired from ngbp seed application at : https://github.com/ngbp/ngbp for folder organization and a standardized approach.

------------------------------------------------------------

## Goals

* Use Best Practices and Design Principles for a Single Page Application using Spring Boot.
* Demonstrate a BDD approach using Cucumber, Selenium
* Give a simple unit test for restaurant bill computations

------------------------------------------------------------

## Deployment 

Build : 

		mvn clean && mvn install

Deploy:

		java -jar <artifact>.war 

## Testing 

- Unit Testing for Services for computing Total, GST, Discount is at: 

/restaurantbilling/src/test/java/com/restaurantbilling/service/CalcServiceTest.java

- Integration testing using BDD Cucumber, Selenium is at:

/restaurantbilling/src/test/java/com/restaurantbilling/CucumberTest.java


## PDF 

- PDF of clientside UI is at root level:

/restaurantbilling/demo.pdf

## Demo 

- Video clip of UI is at root level : 

/restaurantbilling/demo.webm

------------------------------------------------------------
