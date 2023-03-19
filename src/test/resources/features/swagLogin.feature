Feature: Swag Lab login


Scenario: successful Login with username and password
	Given I am on the Sauce Demo Login Page
	When I fill the account information for account DtandardUser into the Username field and the Password filed
	And I click the Login Button
	Then I am redirected to the sauce Demo Main Page 
	And I vverify the App Logo Exists
	
	
Scenario: Failed Login
	Given I am on the sauce Demo Login Page
	When I filled account infromation for account LockedOutUser into the Username field and the password field
	And I clicked the login button
	Then I verify the error Message contains the text "Sorry, this user has been banned"
	Then I close chrome browser
	
	