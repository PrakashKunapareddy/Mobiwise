Feature: Adding Mobile Application And Web Application for Created Project In MobileWise


  Scenario Outline: Drag and Drop Components


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Create A Project
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> and Click next <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message> <app_name>
    And Click on the Pages Module, Click on the Landing Page and click on the Add Component Button
    And Click on the <components_panel> and drag the <component> to the screen builder
    Then Verify the <component> on the screen builder

    Examples:
      | username | password     | expected_output | application_type | app_name      | application_name_field_message | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message        | toaster_message                    | components_panel | component      |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Navigation"     | "Navbar"       |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Scanner"      |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Image"        |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Text"         |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Check Box"    |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "File Picker"  |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Image Picker" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Date Picker"  |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Radio Button" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Drop Down"    |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Range Picker" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Text Field"   |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Buttons"        | "Save"         |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Separator"    |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Geotag"       |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Address"      |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Display"        | "Data List"    |

