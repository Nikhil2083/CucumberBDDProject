@alltest
Feature: User Management Page

Scenario: TC0001 C5494603 Add new Cloud User in User Management page and verify user get added successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on current user
And Click on USER MANAGEMENT 
And on USER MANAGEMENT page click on Add User dropdown and select Add New User
Then On Add User popup window enter First Name:"Nikhil"
And Enter Last Name:"Automation"
Then Enter Email: "nikhil@sharklasers.com"
And Click OK
And New user added successfully


Scenario: TC0002 C5494604 Login with newly added Cloud User to DF Cloud and make sure login should be successful.
Then Page Title Should be "Deep Freeze Cloud"
Then open email destination: "https://www.guerrillamail.com"
And click forget me button on gurrilla page
Then Enter name: "Nikhil"
And click on set button
And  uncheck Scramble Address option
And click on the invitation email from deepfreeze
And Click on invite link for password change
Then On Set Password page enter New Password "Aloha@123"
Then Enter Confirm New Password "Aloha@123"
And Click on OK 
And Click on NextButton
And Enter Password as "Aloha@123"
And Click on SignIN
Then On My Profile page click on save button
Then Verified following user are logged in "nikhil@sharklasers.com"
Then Page Title Should be "Deep Freeze Cloud"


Scenario: TC0003 C5494605 Edit Cloud User (like name, lastname, permission) and make sure changes should be saved.
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And click on Logout
When Opens URL "https://www1.faronicsbeta.com/"
And Enters Email as "nikhilguravnkil@gmail.com"
And Click on NextButton
And Enter Password as "Aloha@123"
And Click on Login
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And Click on USER MANAGEMENT 
And I click on Search and look for the newly created user
And I click on Edit button
Then I update the First Name and Last Name
And I change the Permission
And I click on the Update button
Then a popup toast message should appear as '"Nikhil2" user updated successfully'


Scenario: TC0004 C5494606 Disable Cloud User and make sure cloud login for disabled cloud user should be fail.
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And Click on USER MANAGEMENT 
And I click on Search and look for the newly created user
And I click on Edit button
And I click on disabled checkbox
And I click on the Update button
Then a popup toast message should appear as '"Nikhil2" user updated successfully'
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And click on Logout
When Opens URL "https://www1.faronicsbeta.com/"
And Enters Email as "nikhil@sharklasers.com"
And Click on NextButton
And Enter Password as "Aloha@123"
And Click on Login
And verified following error message is appeared "Your account is currently disabled. Please contact your system administrator."


Scenario: TC0005 C5494607 Delete Cloud User and make sure cloud login for deleted user should be fail.
When Opens URL "https://www1.faronicsbeta.com/"
And Enters Email as "nikhilguravnkil@gmail.com"
And Click on NextButton
And Enter Password as "Aloha@123"
And Click on Login
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And Click on USER MANAGEMENT 
And I click on Search and look for the newly created user
And I click on delete X button and delete user
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And click on Logout
When Opens URL "https://www1.faronicsbeta.com/"
And Enters Email as "nikhil@sharklasers.com"
And Click on NextButton
And Enter Password as "Aloha@123"
And Click on Login
And verified following error message is appeared not able to login "Your login attempt has failed. The username or password may be incorrect. Please contact us at "


 

