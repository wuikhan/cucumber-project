Feature: Test the login functionality
  As an authenticated user I should be able to login to the application

  Scenario: Using valid credentials I should be able to login
    Given I open the browser
    And I visit the application
    And I enter valid username
    And I enter valid password
    When I click the login button
    Then I should see the dashboard
    And I quit the browser

  Scenario: Using valid credentials I should be able to login2
    Given I open the browser
    And I visit the application
    And I enter valid username
    And I enter valid password
    When I click the login button
    Then I should see the dashboard
    And I quit the browser
