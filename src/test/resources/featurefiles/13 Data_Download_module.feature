Feature: Data Download Module functionality in Mobile App Builder in Mobile-wise

  Scenario Outline: Validate the functionality and Verify the Data Downloaded Module


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the Project
    And Click on the Mobile Application and Click On Data Download Module
    And Click On the Entity DropDown and Select <entity>
    And Click on the Submission DropDown and Select <submission_type>
    And Click on the Download Data button <error_message>

    Examples:
      | username | password     | expected_output | entity       | submission_type             | error_message                   |
      | "dummy"  | "1234567890" | "Projects"      | "Userentity" | "Custom,2024/3/6-2025/12/8" | "There is no data to download!" |
      | "dummy"  | "1234567890" | "Projects"      | "Userentity" | "Today"                     | "There is no data to download!" |
      | "dummy"  | "1234567890" | "Projects"      | "Userentity" | "Last Month"                | "There is no data to download!" |
      | "dummy"  | "1234567890" | "Projects"      | "Userentity" | "Last Week"                 | "There is no data to download!" |


