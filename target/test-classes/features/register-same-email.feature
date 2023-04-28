@register-same-email
Feature: registering with same email
  Scenario:
    Given user logged out and is back on the homepage
    When user attempts to create second account with same email but different credentials
    And user submits the form
    Then user should be led to the account confirmation page
    And user must log out