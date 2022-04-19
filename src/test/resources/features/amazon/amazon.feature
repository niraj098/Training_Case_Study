Feature: Amazon Tests

  Scenario: Validate Unsuccessful Login
    Given Launch Amazon Website
    When  User Clicks on 'Sign In' button
    And   User inputs username
    And   User Clicks on continue button
    And   User inputs incorrect password and clicks submit button
    Then  User should be displayed with proper error message


  Scenario Outline: Validate search results for amazon product
    Given Launch Amazon Website
    When  User searches for product "<product>"
    Then  Relevant search for corresponding "<product>" should be displayed
    And   User opens details page for first product
    And   'Buy Now' button must be enabled
    And   click on 'Buy Now' Button
    And   User must be directed to login page
    Examples:
      | product |
      | alexa   |
      | echo    |
