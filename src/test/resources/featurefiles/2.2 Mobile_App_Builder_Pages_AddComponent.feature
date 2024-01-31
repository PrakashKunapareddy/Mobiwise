Feature: Adding Mobile Application And Web Application for Created Project In MobileWise


  Scenario Outline: Create Mobile And Web Applications

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output> <valid_username>
    And Clicked on the Project
    And Click on the Mobile Application
    And Enter <app_name> <app_desc> Upload Logo and Click on Next
    And Update <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message>
    And Click on the Pages Module, Click on the Landing Page and click on the Add Component Button
    And Click on the <components_panel> and drag the <component> to the screen builder
    Then Verify the <component> on the screen builder

    Examples:
      | username | password     | expected_output | valid_username | app_name                  | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message                 | toaster_message           | components_panel | component |
      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | "Demo Mobile Application" | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application " | "This is required field!" | "Buttons"        | "Save"    |
