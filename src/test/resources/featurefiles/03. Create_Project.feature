Feature: Adding Project Functionality for MobiWise Application

  Scenario Outline: Create a Project

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on Create Project Button
    And Save button should be in Disable mode by default
    And Enter <project_name> <project_description> <error_message> <error_message_image>
    And  Clicked on save button or Enter in keyboard <error_message>
    And Validate new project module <project_name>
    And Edit Created Project name <project_name> <new_project_name> <error_message> <new_project_description> <error_message_image>
    And Edit Created Project description <project_name> <new_project_name> <new_project_description> <error_message> <error_message_image>
    Then Click on Delete Icon and Click on No button or ESC on Keyboard <new_project_name> <project_name>
    Then Click on Delete Icon and Click on Yes button or ESC on Keyboard <new_project_name> <project_name>



    Examples:
      | username | password     | expected_output | project_name | project_description    | new_project_name | new_project_description | error_message                       | error_message_image                                                                                                        |
      | "dummy"  | "1234567890" | "Projects"      | "Demo"       | "Demo Description"     | "New Demo"       | "New Demo Description"  | ""                                  | "The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app." |
      | "dummy"  | "1234567890" | "Projects"      | ""           | "New Demo Description" | "New Demo1"      | "new description"       | "Project name is required."         | "The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app." |
      | "dummy"  | "1234567890" | "Projects"      | "Project 10" | "Demo Description"     | "New Project"    | "New Demo Description"  | "This project name already exists!" | "The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app." |
      | "dummy"  | "1234567890" | "Projects"      | ""      | "Demo Description"     | ""               | "Description"           | "Project name is required."         | "The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app." |
      | "dummy"  | "1234567890" | "Projects"      | "Demo3"      | ""                     | "Project 10"     | ""                      | "This project name already exists!" | "The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app." |






