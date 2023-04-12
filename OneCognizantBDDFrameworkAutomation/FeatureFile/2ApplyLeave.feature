@ApplyLeave
Feature: This feature is about applying leave

  Scenario: this scenario is to apply leave
    Given User again refreshing the browser to go main page
    When User is navigating to TruTime and selecting it
    And User is clicking  Apply Leave Option and new window is opening
    And after switching to new window user is selecting date to apply leave
    And user is selecting type of leave and adding comments
    Then user can now able to save|submit the leave request
