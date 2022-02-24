Feature: Check login functionality

  @smoke
  Scenario: first
    Given user is on login page
    When user enters valid username and password
    And clicks on login button
    Then user is navigated to the home page

  Scenario: second
    Given user is on login page
    When user enters valid username and password
    And clicks on login button
    Then user is navigated to the home page
