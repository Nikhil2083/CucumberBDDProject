Feature: Products install and uninstall using policy
@test
Scenario: C5494491 Enable WINSelect in assigned policy to the wksn and make sure that product installed on wksn and status updated on computers page.
Then Page Title Should be "Deep Freeze Cloud"
And Goto Switch site option
And Select Related Site
Then Click on Computers Page
Then Search Computer Name "WINDOWS-10-22H2"
And click on assigned policy name
Then Click on DeepFreeze Product- WINSELECT
Then Click on Enable product dropdown
And Enable DeepFreeze Product- WINSELECT
Then Click on Save button
And On Policy Update Preference window select- Notify the user immediately when the computer checks-in and restart after 2 minutes.
And On Policy Update Preference window click OK
Then Click on Computers Page
And check WINSELECT status indicator should be green
And Mouse hover on the WINSELECT status indicator


@test
Scenario: C5494474 Disable WINSelect product in assigned policy to the wksn and make sure that WINSelect is uninstalled on workstation and status updated on computers page.
Then Page Title Should be "Deep Freeze Cloud"
#And Goto Switch site option
#And Select Related Site
Then Click on Computers Page
Then Search Computer Name "WINDOWS-10-22H2"
And click on assigned policy name
Then Click on DeepFreeze Product- WINSELECT
Then Click on product dropdown
And Disable DeepFreeze Product- WINSELECT
Then Click on Save button
And On Policy Update Preference window select- Notify the user immediately when the computer checks-in and restart after 2 minutes.
And On Policy Update Preference window click OK
Then Click on Computers Page
And check WINSELECT status indicator should be grey
And Mouse hover on the WINSELECT status indicator














