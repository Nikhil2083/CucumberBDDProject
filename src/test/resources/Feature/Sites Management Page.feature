
Feature: Sites Management Page

Scenario: TC0001 C5494460 Add new Cloud Site to the cloud and make sure that new site should be added
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on logoutmenu
And select My sites option from dropdown
And click on Add site button
And Enter Site Name and save
And Verified New Site added successfully using toast message "Site added successfully."


Scenario: TC0002 C5494461 Edit cloud site name and make sure that site name should be updated correctly
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
Then click on logoutmenu
And select My sites option from dropdown
And Search newly added site name under search field and click on Edit site option
Then Update Site Name and verified toast message: "Site updated successfully."


Scenario: TC0003 C5494462 Switch to the newly created site and make sure that cloud should be switched to the new site.
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
And Goto Switch site option
Then Select newly created site
And verified cloud should be switched to the new site.


Scenario: TC0004 C5494463 Delete newly created site and make sure that site should be deleted correctly
Then Page Title Should be "Deep Freeze Cloud"
Then Click on Computers Page
And Goto Switch site option
And Select Related Site
Then Click on Computers Page
Then click on logoutmenu
And select My sites option from dropdown
And Search newly added site name under search field and click on delete site option
And Verified site is deleted successfully





