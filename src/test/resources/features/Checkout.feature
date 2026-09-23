Feature: SauceLabs mobile purchase
  As a Customer
  I want to grab two swag items in one go
  So that checkout feels quick and painless

  Scenario: Grab a backpack plus a bike light in one checkout
    Given User clicks the "standard_user" autofill entry and logs in
    Then User lands on the products catalog page
    When User drops "Sauce Labs Backpack" and "Sauce Labs Bike Light" into the basket
    And User opens the shopping basket page
    Then User spots "Sauce Labs Backpack" and "Sauce Labs Bike Light" inside the basket
    When User heads to the checkout form
    And User types "Aldan" as first name, "Maulana" as last name and "0823" as zip code
    And User hits continue and reaches the order summary page
    Then User confirms the item and grand totals are accurate
    And User places the order and gets the thank-you note
