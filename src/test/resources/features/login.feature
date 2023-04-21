Feature: Logging with recent registration info.

  @login
  Scenario: successfully log in with generated email
    Given user logs back in with previous credentials
    When user successfully logs in
    Then user's account is registered and user must log off.