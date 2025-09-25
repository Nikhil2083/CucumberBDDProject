@allTC
@Regression
Feature: Home Page(Download Cloud Agent)

#Background: Common Steps for all scenarios
   
  Scenario: C5494555 Download Windows installer and make sure it should be downloaded correctly.
    Then Page Title Should be "Deep Freeze Cloud"
  #  And click on Policy tab
   # And click on Add Policy button
 #   And Select policy type Deep Freeze Windows
#    And Enter Policy Name as "Test"
  #  And Select DEEP FREEZE Product
  #  And Click for Enable DeepFreeze Product
  #  And Select Deep Freeze setting as "2"
  #  And Save the policy
    And Click on Download Agent
    And Select newly created policy from Policy: dropdown
    And Select download type "Download the installer to install on any computer."
    Then Click on Download button
    And Windows installer downloaded successfully

  Scenario: C5494556 Download MSI installer and make sure it should be downloaded correctly.
    And Click on Download Agent
   Then Select newly created policy from Policy: dropdown
    And Select MSI download type "Download MSI installer to deploy via Active Directory."
    Then Click on Download button
    And MSI installer downloaded successfully
 
  Scenario: C5494557 Download Deployment Utility and make sure it should be downloaded correctly.
    And Click on Download Agent
   Then Select newly created policy from Policy: dropdown
    And Select Deployment Utility type "Download the Deployment Utility to detect and install on any computer."
    Then Click on Download button
    And Deployment Utility downloaded successfully
 
  Scenario: C5494558 Download Full installer and make sure it should be downloaded correctly.
    And Click on Download Agent
   Then Select newly created policy from Policy: dropdown
    And Select Full Installer type "Download the full installer to save bandwidth (for large deployments)."
    Then Click on Download button for download Full Installer
    And Full Installer downloaded successfully
       
  Scenario: C5494559 Download Server Policy installer and make sure it should be downloaded correctly.
  And Click on Download Agent
  Then Select downloader type- Windows Server
  Then Click on Download button
  And Windows Server Installer downloaded successfully
  
  Scenario: C5494560Download Mac Policy installer and make sure it should be downloaded correctly.
 And Click on Download Agent
  Then Select downloader type- Mac
  Then Click on Download button
  And Mac Installer downloaded successfully

 
 
 

 
 