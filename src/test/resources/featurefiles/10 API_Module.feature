Feature: API Module functionality in Mobile App Builder in Mobile-wise

  Scenario Outline: Validate the functionality and Verify the API Module


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the Project
    And Click on the Mobile Application and Click On API Module
