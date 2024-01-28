
Feature: Search and place order for product
@SearchProduct

    Scenario Outline: search a product both in home and offers screen
    Given user is on Greenkart home page
    When user searched with short name <name> and extracted actual name of the product
    Then user searched with same short name <name> in offers page 
    And check if the product is available
  
  Examples: 
      | name |
      | Car  |
    	| Tom  |
      | Boo  |