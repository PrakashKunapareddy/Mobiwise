Feature: Delete Project functionality in Landing page

  Scenario Outline: Validate the functionality and Verify the Settings Module


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Delete the <project>


    Examples:
      | username | password     | expected_output | project  |
      | "dummy"  | "1234567890" | "Projects"      | "Sample" |

