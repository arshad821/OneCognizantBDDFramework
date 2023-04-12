@cognizantLearn
Feature: This feature is about Cognizant LEARN

  @citywise_courses_scenario
  Scenario: This scenario is to get details about courses in citywise
    Given user can navigate back home page..
    When user can search for Cognizant LEARN and select it
    And user can select Self dropdown and select location calender
    And user can now select required cities
    Then user can now navigate to newlyopened window and capture the required informations.

  @search_bar_scenario
  Scenario: This scenario is about search bar in cognizant learn
    Given user can again navigating again to home......
    When user again searching Cognizant LEARN and again select it
    And user can now select dropdown and select required options
    And user can select search_bar and type required details
    And user can now select required courses/video
    Then user can now see the course_details and capture if need

  @timeline/library_options_scenario
  Scenario: This scenario is to explore cognizant learn
    Given user is navigating to onecognizant.com in browser
    When user need to search for Cognizant LEARN and select it
    And user can  select timeline/library options now
    Then user can now see all the required details

  @capturing_profile_scenario
  Scenario: This scenario is to get profile
    Given user can navigating again to home page....
    When user can search for Cognizant LEARN
    And user can click profile picture
    And user can click profile details option
    Then user can now view/capture profile detatils
