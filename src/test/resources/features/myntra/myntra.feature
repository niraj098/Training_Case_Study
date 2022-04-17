Feature: Myntra Tests

  Scenario: Validate invalid login

    Given Launch Myntra Website
    And   User clicks on 'profile' icon
    And   User click on 'login or signup' button
    And   User enters valid username
    And   User clicks on 'continue' button
    And   User clicks on 'Login using password' link
    And   User enters invalid password
    When  User clicks on 'login' button
    Then  User should be displayed with proper notification


  Scenario Outline: Place order for product

    Given Launch Myntra Website
    And   User searches for "<product>" in the main searchbox
    And   User must be displayed with relevant search results for "<product>"
    And   User clicks on first search result
    And   User clicks on 'Add to Bag' button
    And   User clicks on 'Go to Bag' button
    When  User clicks on 'Place Order' link
    Then  User must be redirected to login page


    Examples:
      | product |
      |sling bag|
      |watch    |


