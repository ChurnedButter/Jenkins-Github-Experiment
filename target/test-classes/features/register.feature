Feature: Registering with the same email address
  @register
  Scenario: Register with same email address and verify account
    Given user is on the homepage
    And user clicks on the register link
    When user fills out the registration form with valid credentials using randomly generated email address
    And user submits the form
    Then user should be led to the account confirmation page
    And user must log out