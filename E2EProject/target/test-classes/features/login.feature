#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login into Application
  I want to use this template for my feature file

 
  Scenario Outline: Positive test validating login ## for this scenario to work with other username and password we need to add " Outline" after Scenario
    Given Initialize the browser with chrome
    And Navigate to "http://www.qaclickacademy.com/" site
    And Click on Login link in home page to land on Secure sign in page
    When User enters <username> and <password> and logs in
    Then Verify that user is successfully logged in
    And close browsers
 
 
Examples:   ##a table with further parameters to run in TestCases
|username					  |password	|
|test99@gmail.com		|123456		|
|test123@gmail.com	|123456789|
 
 