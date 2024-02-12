Feature: Themes Module functionality in Mobile App Builder in Mobile-wise


  Scenario Outline: Validate the Breadcrumb functionality and Verify the Themes in Themes Module and the Themes functionality

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Check Username of the User <username>
    And Create A Project
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> and Click next <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    And  Validate Application Created <toaster_message> <app_name>
    And Verify BreadCrumb <expected_output>
    And Click on the Themes Module
    And Verify Themes <themes_change> and Click on Apply Button and Reset Button <toaster_message_themes_apply>





    Examples:
      | username | password     | expected_output | application_type | app_name            | app_desc                        | themes_dropdown | headings_dropdown | body_dropdown | toaster_message                   | suggestion_message        | application_name_field_message | themes_change | toaster_message_themes_apply |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pink Light"  | "Applied Sucessfully"        |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Teal Light"  | "Applied Sucessfully"        |
