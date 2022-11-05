Feature: End to End Testing to buy items from magneto website
  Description:The purpose of the test case is to get user details from background, registered the user and buy item from website
	
	Background: Generate random user
	Given I enter api endpoint url
	When I send api request
	Then I should get successful status code
	
	@SmokeTest
  Scenario: Registration and buy item from magneto website
    Given I navigate to home page
    Then Magneto Page is opened successfully
    And I click on Create Account option
    Then Registration page opened successfully
    And I enter all registration fields
    Then Registration completed successfully
    When I navigate to homepage
    And I select Item from Home page
    Then I select size, color and quantity
    And I click on add to cart icon
    Then verify item is added to cart successfully
    Then Go to cart and click on proceed to checkout
    And select to delivery address details
    Then Click on next button
    And Click on place and order
    Then verify order is placed successfully