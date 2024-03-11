# Test Automation Challenge

# Tools/Language/Framework Used :

*Intellij Community 

*Java Programming language

*Selenium Webdriver

*TestNG Framework

*Maven

# Brief Description

 I used TestNG framework using Java language with integration of Selenium Webdriver and Maven for Build Management. The code design I used is Page Object Module with Object Oriented Programming, by which means I have separated the package class by Test, Util and Common Setup. For common setup I made a class for configuration of browser, selenium command and initialization of selenium. Test is where the test locators & action per pages, test data and test case scenario command are written.

# Test Cases Scenarios
*Login Scenario (src/main/java/test/testcases/loginScenario.java)

   TC#1 - Verify Elements on Sign In Modal

   TC#2 - Verify Validation of Missing Email or Password

   TC#3 - Verify Validation of Invalid Password

   TC#4 - Verify if User Successfully Sign In

![image](https://github.com/legor0210/ballysTestChallenge/assets/52125153/61aa758a-2d34-4dc3-842a-72d24ceed4f8)
![image](https://github.com/legor0210/ballysTestChallenge/assets/52125153/16a9711e-e0bb-41cc-b415-ded62ff44766)
   
# Allure HTML Report 
  Command : allure generate --single-file C:\Users\Nicko\Documents\exam\ballysTestChallenge\htmlReport                   
       
