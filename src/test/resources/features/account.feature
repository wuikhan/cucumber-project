Feature: As a user , I should be able to verify and create accounts

  @regression @sprint1 @smoketest @accounts
  Scenario: Create Account using Data Table
    Given I open the browser
    And I visit the application
    And I enter valid username
    And I enter valid password
    When I click the login button
    And I create and save the Account
      | Account Name | Account Number | Account Site     | Active | Annual Revenue | Account Source |
      | Waqas 123    |          12345 | www.codegator.us | Yes    |         100000 | Web            |
    And I click the "Edit" button
    And I should see the following values for the "00N2E00000D7LOy" field
      | --None-- |
      | No       |
      | Yes      |
    And I should see the following values for the "AccountSource" field
      | --None--         |
      | Web              |
      | Phone Inquiry    |
      | Partner Referral |
      | Purchased List   |
      | Other            |