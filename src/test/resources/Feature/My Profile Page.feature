Feature: My Profile Page

@test
Scenario: TC0001 C5494572 Open My profile and update some fields (e.g. name, compnay name, job title, phone no. ) and save settings.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on logoutmenu
And Click on My Profile
And Enter First Name and Last Name
And Enter Job Title
And Enter Company Name and Phone Number
Then Click on Save
Then a popup toast message should appear as 'Profile updated successfully'

@test
Scenario: TC0002 C5494573 Open My profile and change password and save settings.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on logoutmenu
And Click on My Profile
And Set Password
Then Click on Save
Then a popup toast message should appear as 'Profile updated successfully'





