Feature: BaseTest
  Scenario: BaseTestSteps
    Given I open the SauceDemo website
    When I log in as a standard user
    And I select a product named "Sauce Labs Backpack"
    Then I should see the product details matching "Sauce Labs Backpack"
    And I add the product to the cart
    And I go to the cart
    And I proceed to checkout
    And I enter the following checkout information:
      | First Name | Last Name | Zip Code |
      | MyName     | Testing   | 775500   |
    And I continue with the checkout
    And I complete the order
    Then I should see a confirmation message "THANK YOU FOR YOUR ORDER"

  Scenario: Unsuccessful Shopping
    Given I open the SauceDemo website
    When I log in as a standard user
    And I select a product named "Invalid Product"
    Then I should see an error message
