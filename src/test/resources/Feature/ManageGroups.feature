@test
Feature: Manage Groups

Scenario: Verify Add Groups button display on manage group page.
Then Page Title Should be "Deep Freeze Cloud"
And Click on Groups Page
Then Verify Add Groups button is displayed on manage groups page. 

Scenario: Once clicking on Add Groups button ,add group dialog launched.
And Click on Groups Page
And Click on Add Groups button
Then Verify that Add Groups dialog is launched
  
  
Scenario: Verify group with empty name can not be created.
Then click on ADD button
And verify that group with empty name can not be created 

 