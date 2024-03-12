Feature: Settings Module functionality in Mobile App Builder in Mobile-wise

  Scenario Outline: Validate the functionality and Verify the Settings Module


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the <project>
    And Click On the <mobile_app> and Click on the Settings Module
    And Verify <mobile_app> and Click on the Edit Button
    And Enter <new_mobile_name> and <description> and Validate Description Count And Edit Logo
    And Click On Save Changes Button And Verify BreadCrumb and Mobile App Name And Heading <new_mobile_name>

    Examples:
      | username | password     | expected_output | project  | mobile_app | new_mobile_name | description            |
      | "dummy"  | "1234567890" | "Projects"      | "Sample" | "Demo"     | "New Demo"      | "New Demo Description" |
