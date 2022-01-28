# Super Simple Stock Market
Coding Assignment – Super Simple Stock Market

#Requirements

* Provide working source code that will:-
  * For a given stock, 
    * Given any price as input, calculate the dividend yield
    * Given any price as input, calculate the P/E Ratio
    * Record a trade, with timestamp, quantity of shares, buy or sell indicator and 
    * Calculate Volume Weighted Stock Price based on trades in past 15 minutes
  * Calculate the GBCE All Share Index using the geometric mean of prices for all stocks traded price


#Features of the Project
* It uses Spring Boot and Java 8. 
* It is a Server App running on port 8080, having the REST APIs for the required 5 functions given in Requirements
* It is integrated with Swagger which enables the User to run the APIs from Browser
* Sample data from the Global Beverage Corporation Exchange is Added via the application.properties

#How to use:
This is a maven project, so you can run these 2 goals:
* mvn test -> to execute the unit tests.
* mvn package -> to generate the executable jar.


#Controller Classes
* com.jpm.stockmarket.controller.StockMarketController -> Controller for Calculating GBCE API
* com.jpm.stockmarket.stock.controller.StockController -> Controller for Calculating Dvident Yield, PE Ratio, Vol Weighted  values for given Stock
* com.jpm.stockmarket.trade.controller.TradeController -> Controller for Adding Trades

# Test Controller Classes
* com.jpm.stockmarket.controller.StockMarketControllerTest
* com.jpm.stockmarket.stock.controller.StockControllerTest
* com.jpm.stockmarket.trade.controller.TradeControllerTest

