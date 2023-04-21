Feature: Registered user must successfully add items to a cart and checkout


  @checkout
  Scenario: checkout item in shopping cart
      Given user has registered and successfully logged in
      When user searches for any item
      And adds the selected item to the cart
      Then user must be able to successfully purchase the item at checkout.

  @checkout-address-credentials
  Scenario: Fill out address credentials if empty in checkout
    Given user has registered and successfully logged in
    When user searches for any item and adds item to the cart
    And user hasn't filled out address credentials
    Then user must fill out credentials and complete purchase at checkout.


