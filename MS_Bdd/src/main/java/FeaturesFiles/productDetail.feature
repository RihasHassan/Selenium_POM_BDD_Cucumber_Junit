Feature: ProductDetails Check

  Background: User is on Product listing page
    Given user is alreday on homePage
    When user clicks on WomensTab
    Then user sorts products based on average rating
    Then user is on womens product listing page
    Then user clicks on first product on listing

  Scenario: ProductDetail in productDetailPage
    Then user is on product detail page and then verifying the product details


  Scenario: ProductDetail in cartPage
    Then user increase the quantity of the product
    Then user clicks on add to cart
    When user clicks on view cart
    Then user is on cart page and then verifying the product details
    Then user clicks on change adress
    Then user enters address details and then clicks on update
    Then user clicks on proceed to check out button
    
   
