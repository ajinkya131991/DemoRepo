Feature: ToolsQA Functional Test

Description: Purpose of this feature is to test End 2 End Feature.

Scenario: Customer places an order by purchasing an item from search field 

    Given : user is on Home Page
    When :he search for "dress"
    And :choose to buy the first item
    And :moves to checkout from mini cart
    And :enter personal details on checkout page
    And :select same delivery address
		And : Select payment method as "Check" payment 
		And : Place the order
		    

    




