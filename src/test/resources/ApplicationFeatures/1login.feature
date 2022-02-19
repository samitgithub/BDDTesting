Feature: All Features

  Scenario: Login Page Feature
    Given User is on login page
    When User gets the title of the page
    Then Page title should be "Login - My Store"

  Scenario: Forgot Password Link
    Given User is on login page
    Then Forgot your password link should be displayed

  Scenario: Login With Correct Credentials
    Given User is on login page
    When User enters username "samitkumarabc@gmail.com"
    And User enters password "abc123"
    And User clicks on login button
    Then User gets the title of the page
    And Page title should be "My account - My Store"
