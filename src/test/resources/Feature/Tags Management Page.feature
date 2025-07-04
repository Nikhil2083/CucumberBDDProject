Feature: Tags Management Page
@test
Scenario: C5494618 Add Tickets tag in Tag Management page and make sure ticket tag should be added successfully.
Then Page Title Should be "Deep Freeze Cloud"
Then Click Tags Management tab
Then On Tag Management page click on Add Tickets
And Enter Ticket Tag under Add Ticket Tag text failed and save- "Test1"
Then check ticket tag is added successfully.

@test
Scenario: C5494619 Delete added ticket tag in tag management page and make sure ticket tag should be deleted successfully.
Then check ticket tag is added successfully.
And click on delete X tab
And Are you sure you wish to delete the tag, click on Delete
Then Check Entered Ticket Tag is deleted properly


