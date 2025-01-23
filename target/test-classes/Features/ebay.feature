Feature: Ebay Add to cart functionality 
@login

  Scenario: Verify ebay site is logged in and book is added to the cart
   Given user launch ebay site
   When user enter book in the search box
   Then user click search button 
   Then User select first book option
   And click add to cart button
   And verify count has been added to the cart
   
  