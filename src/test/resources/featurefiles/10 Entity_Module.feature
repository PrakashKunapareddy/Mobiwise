Feature: Entity Module functionality in Mobile App Builder in Mobile-wise

  Scenario Outline: Validate the functionality and Verify the Entities in Entity Module


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the Project
    And Click on the Mobile Application and Click On Entity Module

    Examples:
      | username | password     | expected_output |
      | "dummy"  | "1234567890" | "Projects"      |
