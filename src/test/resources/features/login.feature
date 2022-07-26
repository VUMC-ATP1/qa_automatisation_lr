Feature: Login feature
  As a user,
  I want to have the possibility to log in
  So that I can purchase products

  Scenario: Success Login
    Given I have navigate to login page
    When I login  with "standard_user" and "secret_sauce"
    Then I am successfully logged in
    When I add a product "Sauce Labs Bike Light" in cart
    Then I go to shopping cart
    And I check the product "Sauce Labs Bike Light" is in cart
    Then I navigate to Checkout
    And I fill in Order form customer name "John", last name "Doe", zip code "1111"
    Then I continue submit the Order
    And I check Order has correct item
    Then I finish order submitting
    And I check the Order have message "THANK YOU FOR YOUR ORDER"
    Then I click back Home button
    And I navigate to Home

    Scenario: Check Order form
      Given I have navigate to login page
      When I login  with "standard_user" and "secret_sauce"
      Then I am successfully logged in
      When I add a product "Sauce Labs Bike Light" in cart
      Then I go to shopping cart
      And I check the product "Sauce Labs Bike Light" is in cart
      Then I navigate to Checkout
      When I continue order without customer data
      Then I get error message "Error: First Name is required"
      When I enter customer "name" and click continue
      Then I get last name error message "Error: Last Name is required"
      When I enter customer "name", "last name" and click continue
      Then I get zip code error message "Error: Postal Code is required"