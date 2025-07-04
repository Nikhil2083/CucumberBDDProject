Feature: DeepFreezeSuite

  Scenario: TC001 Successful Login with Valid Credentials
    Given Launch Chrome Browser
    When Opens URL "https://www1.faronicsbeta.com/"
    And Enters Email as "nikhilg@alohatechnologydev.com"
    And Click on NextButton
    And Enter Password as "Aloha@123"
    And Click on Login
    Then Page Title Should be "Deep Freeze Cloud"
    Then click on logoutmenu
    And click on Logout
    And Close browser
    
    
     Scenario Outline: TC002 Successful Login with Valid Credentials DDT
    Given Launch Chrome Browser
    When Opens URL "https://www1.faronicsbeta.com/"
    And Enters Email as "<emails>"
    And Click on NextButton
    And Enter Password as "<passwords>"
    And Click on Login
    Then Page Title Should be "Deep Freeze Cloud"
    Then click on logoutmenu
    And click on Logout
    And Close browser
    

    Examples: 
      | emails                         | passwords |
      | nikhilg@alohatechnologydev.com | Aloha@123 |
      | Nikhilgurav@gmail.com		   | Aloha@123 |
 