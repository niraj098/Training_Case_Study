Feature: Amazon Tests

  Scenario: Validate Unsuccessful Login
    Given Launch Amazon Website
    When  User Clicks on 'Sign In' button
    And   User inputs username
    And   User Clicks on continue button
    And   User inputs incorrect password and clicks submit button
    Then  User should be displayed with proper error message


  Scenario: Validate Unsuccessful Login
    Given Launch Amazon Website
    When  User Clicks on 'Sign In' button
