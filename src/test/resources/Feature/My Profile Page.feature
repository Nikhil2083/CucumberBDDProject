Feature: My Profile Page


Scenario: TC0001 C5494572 Open My profile and update some fields (e.g. name, compnay name, job title, phone no. ) and save settings.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on logoutmenu
And Click on My Profile
And Enter First Name and Last Name
And Enter Job Title
And Enter Company Name and Phone Number
Then Click on Save
Then a popup toast message should appear as a 'Profile updated successfully'


Scenario: TC0002 C5494573 Open My profile and change password and save settings.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on logoutmenu
And Click on My Profile
And Set Password
Then Click on Save
Then a popup toast message should appear as 'Profile updated successfully'


Scenario: TC0003 C5494574 After password is changed logout and login with new password and make sure login should be successful.
Then Page Title Should be "Deep Freeze Cloud"
Then click on logoutmenu
And click on Logout
When Opens URL "https://www1.faronicsbeta.com/"
And Enters Email as "nikhilguravnkil@gmail.com"
And Click on NextButton
And Enter Password as "Aloha@123"
And Click on Login
Then Page Title Should be "Deep Freeze Cloud"


