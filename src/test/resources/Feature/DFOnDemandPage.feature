Feature: DF On Demand Page

Scenario: TC0001 C5494582 Select online wksn and run Restart action from DFOD page and verify task executed successfully.
Then Click on Computers Page
#And Switch site to related site
Then Click On DF On Demand Page
And Search Computer Name by there name and select it
And Perform Restart action and check Task Status from Task Status Page
And Verified selected machine is restarted properly on Task Status Page

@TC
Scenario: TC0002 C5494583 Select online wksn and run DF Thawed action from DFOD page and verify task executed successfully. (Verify DF status updated correctly)
Then Click On DF On Demand Page
And Search Computer Name by there name and select it
And Perform Reboot Thawed Action and check Task Status from Task Status Page
And Check selected machine is Reboot Thawed properly on Task Status Page
And Verified on DFOD Page DF status updated correctly Frozen to Thawed
  