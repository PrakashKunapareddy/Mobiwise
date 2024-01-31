Feature: Adding Project Functionality for MobiWise Application

  Scenario Outline: Create a Project

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output> <valid_username>
    And Clicked on Create Project Button
    And Save button should be in Disable mode by default
    And Enter <project_name> <project_description> <error_message>
    And  Clicked on save button or Enter in keyboard <project_name> <error_message>
    And Validate new project module <project_name> <error_message>
    And Edit Created Project name <project_name> <new_project_name> <error_message>
    And Edit Created Project description <project_name> <new_project_name> <new_project_description> <error_message>
    Then Click on Delete Icon and Click on No button or ESC on Keyboard <new_project_name>
    Then Click on Delete Icon and Click on Yes button or ESC on Keyboard <new_project_name>



    Examples:
      | username | password     | expected_output | valid_username | project_name | project_description    | new_project_name | new_project_description | error_message                       |
      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | "Demo"       | "Demo Description"     | "New Demo"       | "New Demo Description"  | "This project name already exists!"                                  |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | "New Demo"   | "New Demo Description" | ""               | ""                      | "This project name already exists!" |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | ""           | "Demo Description"     | ""               | ""                      | " Project name is required."        |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | "New Demo1"  | ""                     | "New Demo"       | ""                      | "This project name already exists!" |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | "Demo"       | "Demo Description"     | ""               | "New Demo Description"  | " Project name is required."        |




