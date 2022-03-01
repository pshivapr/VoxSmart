Feature: Add favorites and validate cryptocurrencies

  @smoke @regression
  Scenario: Create demo account and add random cryptos to favorites
    Given a demo user account is created
    When I add random cryptos as favorites
    And I click on favorite tab and view the page
    Then the cryptos are added and can be seen