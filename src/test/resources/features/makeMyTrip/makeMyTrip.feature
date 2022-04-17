Feature: MakeMyTrip Tests

  Scenario Outline: Validate invalid login

    Given Launch MakeMyTrip Website
    And   User selects from "<fromCity>"
    And   User selects to "<toCity>"
    And   User selects "<departureDate>"
    And   User clicks on search button
    And   User click on book now button
    And   User select radio button not to opt for secure trip
    And   User clicks Add new Adult Button
    And   User enters passenger informations - "<First Name>", "<Last Name>", "<Mobile Number>", "<Email>"
    And   User clicks on continue button
    And   User confirms details
    And   User selects seats
    And   User clicks on continue button
    And   User clicks on continue button
    And   User review AddOns
    When  User clicks Proceed to pay button
    Then  User must be displayed with payment options with Pay Now Button
    Examples:
      | fromCity | toCity    | departureDate | First Name | Last Name | Mobile Number | Email   |
      | Chennai  | Bengaluru |               | kumar      | Kumar     | 1234567890    | a@a.com |





