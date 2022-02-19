Feature: Account Page Feature

  Background: 
    Given User has already logged in to application
      | username                | password |
      | samitkumarabc@gmail.com | abc123   |

  Scenario: Account Page Title
    Given user is on Accounts page
    When User gets the title of the page
    And Page title should be "My account - My Store"

  Scenario: Account Section Count
    Given user is on Accounts page
    Then user gets the Accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And Accounts section count should be 6
