

Feature: Search and add vegitable quantity
@AddQuantity

Scenario Outline: search a product in home page and add quantity and verify same on checkout page. 
    Given user is on Greenkart home page
    When user searched with short name <name> and extracted actual name of the product then
    And User adds the <quantity> of the product moves to checkout page
    Then Check if vegitable <name> and <quantity> is added to the shopping list on checkout page
    And Check if Apply and Checkout buttons are available on checkout page
  
  Examples: 
      | name |	quantity	|
      | Car  |	3					|
    	| Tom  |	2					|		
      | Boo  |	1					|
      



  

