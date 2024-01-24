Feature: Adding Project Functionality for MobiWise Application

  Scenario Outline: Create a Project

    Given Entered a valid SuperAdmin <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on Create Project Button
    And Enter <project_name> <project_description>
    And  Clicked on save button
    Then Validate new project module
    Then Edit Created Project <new_project_name> <new_project_description>

    Examples:
      | username | password     | expected_output | project_name | project_description | new_project_name | new_project_description |
      | "dummy"  | "1234567890" | "Projects"      | "Demo"       | "Demo Description"  | "New Demo"       | "New Demo Description"  |
