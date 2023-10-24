Feature: Login Page Saucedemo

  @Regression @Positive
  Scenario: Success Login
    Given Page Login Saucedemo
    When Input username
    And Input password
    And click the login button
    Then user in on dashboard page

  @Regression @Negative
  Scenario: Failed Login
    Given Page Login Saucedemo
    When Input username
    And Input Invalid password
    And click the login button
    Then user get error message

  @Regression @Positive
  Scenario: Success Logout
    Given Page Login Saucedemo
    When Input username
    And Input password
    And click the login button
    Then user in on dashboard page
    When click burger menu
    And click logout
    Then user on landing page

  @Regression @Positive
  Scenario: Success Sorting
    Given Page Login Saucedemo
    When Input username
    And Input password
    And click the login button
    Then user in on dashboard page
    When User click the sort menu
    And User selects price low to high
    Then showing the sorted Swag Labs page



  @Regression @Positive
  Scenario: Success AddToCart
    Given Page Login Saucedemo
    When Input username
    And Input password
    And click the login button
    When click add product to cart
    And click the cart icon
    Then user see detail product in cart page


    Scenario: Succes Checkout
      Given Page Login Saucedemo
      When Input username
      And Input password
      And click the login button
      When click add product to cart
      And click the cart icon
      Then user see detail product in cart page
      When click checkout
      Then User see information product page
      When Input First Name
      And Input Last Name
      And Input postal code form
      And click continue
      Then User see checkout overview page
      And click finish
      Then showing Page Checkout complete







  @TDD
    Scenario Outline: User login to soucedemo
      Given Page Login Saucedemo
      When I input <username> as username
      And I input <password> as password
      And click the login button
      Then I verify <status> login result

      Examples:
        | username    | password    | status |
        |standard_user|secret_sauce |succes|
        |standard_user|secret       |failed|

  @TDD
  Scenario Outline: User logout
    Given Page Login Saucedemo
    When I input <username> as username
    And I input <password> as password
    And click the login button
    Then I verify <status> login result
    When click burger menu
    And click logout
    Then user on landing page

    Examples:
      | username    | password    | status |
      |standard_user|secret_sauce |succes|


  Scenario Outline: User Checkout
    Given Page Login Saucedemo
    When I input <username> as username
    And I input <password> as password
    And click the login button
    Then I verify <status> login result
    When click add product to cart
    And click the cart icon
    Then user see detail product in cart page
    When click checkout
    Then User see information product page
    When I Input <firstName> as firstName
    And I Input <lastName> as lastName
    And I Input <postalCode> as postalCode
    And click continue
    Then User see checkout overview page
    And click finish
    Then showing Page Checkout complete

    Examples:
      | username    | password    | status | firstName     | lastName    | postalCode |
      |standard_user|secret_sauce |succes  | Nafidhatul    |Ula          |78513|



