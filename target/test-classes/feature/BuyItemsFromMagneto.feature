Feature: End to End Testing to buy items from magneto website
  Description:The purpose of the test case is to get user details from background, registered the user and buy item from website
	
	Background: Generate random user
	Given I enter api endpoint url
	When I send api request
	Then I should get successful status code
	
  Scenario: Registration to magneto website
    Given I navigate to home page
    Then Magneto Page is opened successfully
    And Click on Create Account option
    Then Registration page opened successfully