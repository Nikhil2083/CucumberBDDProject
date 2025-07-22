Feature: User Management Page
@test
Scenario: TC0001 C5494603 Add new Cloud User in User Management page and verify user get added successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on current user
And Click on USER MANAGEMENT 
And on USER MANAGEMENT page click on Add User dropdown and select Add New User
Then On Add User popup window enter First Name:"Nikhil"
And Enter Last Name:"Automation"
Then Enter Email: "Nikhil@sharklasers.com"
And Click OK
And New user added successfully

 

@test
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
  Then Verified following user are logged in "Nikhil@sharklasers.com"
   