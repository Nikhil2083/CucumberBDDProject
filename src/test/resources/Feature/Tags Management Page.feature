
Feature: Tags Management Page
@lol
Scenario: TC0001 C5494618 Add Tickets tag in Tag Management page and make sure ticket tag should be added successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click Tags Management tab
#Then On Tag Management page click on Add Tickets
And Enter Ticket Tag under Add Ticket Tag text failed and save- "Test1"
Then check ticket tag is added successfully.
Then Click on Computers Page


Scenario: TC0002 C5494619 Delete added ticket tag in tag management page and make sure ticket tag should be deleted successfully.
#Then Click Tags Management tab
Then check ticket tag is added successfully.
And click on delete X tab
And Are you sure you wish to delete the tag, click on Delete
Then Check Entered Ticket Tag is deleted properly
Then Click on Computers Page


Scenario: TC0003 C5494620 Add tag in tag management page and make sure tag should be added successfully.Then Page Title Should be "Deep Freeze Cloud"
Then Page Title Should be "Deep Freeze Cloud"
Then Click Tags Management tab
Then Click on Add Tags
And Enter Tag name under Add Tag text failed and save- "Test1"
Then check Tag is added successfully.
Then Click on Computers Page


Scenario: TC0004 C5494621 Delete added tag in tag management page and make sure tag should be deleted successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click Tags Management tab
And click on delete X tab on Normal Tag
And Are you sure you wish to delete the tag normal, click on Delete
Then Check Entered Normal Tag is deleted properly
Then Click on Computers Page


Scenario: TC0005 C5494622 Add any Location tag in tag management page and make sure tag should be added successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click Tags Management tab
Then Click on Add Location Tags
And Enter Location Tag name under Add Location Tag text failed and save- "Test1"
Then check Location Tag is added successfully.
Then Click on Computers Page


Scenario: TC0006 C5494623 Delete added location tag in tag management page and make sure tag should be deleted successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click Tags Management tab
And click on delete X tab on Location Tag
And Are you sure you wish to delete the tag Location, click on Delete
Then Check Entered Location Tag is deleted properly


