Feature: Test out restaurant billing system.
		 Try variety of permutations of Subtotal, Arrangement inputs for testing restaurant billing system.


  	Scenario: Adding order for a subtotal 1000 Standard arrangement
  
    Given I go to app create page at 'http://localhost:8080/#/create'
    
    When I create an order for customer name 'Case 1' having 'Standard' arrangment and a Subtotal 1000
    
    Then I see an ouput of Discount 0 , having GST 50 and a Total 1050
    
    
    Scenario: Adding order for a subtotal 3000 Standard arrangement
  
    Given I go to app create page at 'http://localhost:8080/#/create'
    
    When I create an order for customer name 'Case 2' having 'Standard' arrangment and a Subtotal 3000
    
    Then I see an ouput of Discount 100 , having GST 145 and a Total 3045
    
    
    Scenario: Adding order for a subtotal 10000 Outdoor arrangement
  
    Given I go to app create page at 'http://localhost:8080/#/create'
    
    When I create an order for customer name 'Case 3' having 'Outdoor' arrangment and a Subtotal 10000
    
    Then I see an ouput of Discount 1300 , having GST 1566 and a Total 11566
    
    
    Scenario: Adding order for a subtotal 0 Standard arrangement
  
    Given I go to app create page at 'http://localhost:8080/#/create'
    
    When I create an order for customer name 'Case 4' having 'Standard' arrangment and a Subtotal 0
    
    Then I see an ouput of Discount 0 , having GST 0 and a Total 0
    
    