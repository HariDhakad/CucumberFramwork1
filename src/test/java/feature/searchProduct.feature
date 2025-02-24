Feature: Search and placed the orders for products

@OffersPage
  Scenario Outline: search for product in both home and offers page
    Given User is on GreenCart Landing page
		When user searched with Shortname <Name> and extracted actual name of product
    Then user searched for <Name> shortname in offers page
    And validate product name in offers page matches with landing page

    Examples: 
      | Name |
      | Tom  |
      | Beet |
