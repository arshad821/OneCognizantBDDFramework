@TruTime
Feature: This feature is about TruTime

  @fill_single_trutime_scenario
  Scenario: This scenario is to fill TruTime
    Given user can navigate to onecognizant.com in browser
    When user need to search for TruTime and select it
    And user need to select particular date
    And user need to fill all topup details
    Then user should able to submit it now

  @recalling_filled_trutime_scenario
  Scenario: This scenario is to recall TruTime
    Given user is navigating back to main page
    When user is searching for TruTime and selecting
    And user need to select date which is alread filled
    Then user can select recall option and submit it

  @fill_multipledate_trutime_scenario
  Scenario: This scenario is to fill multiple date trutime
    Given user is again navigating back to main page
    When user again searching for TruTime and selecting it
    And user need to select multiple date topup
    And user need to fill all topup details again
    Then user can able to submit/cancel it now
