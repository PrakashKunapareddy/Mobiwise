Feature: Adding Mobile Application And Web Application for Created Project In MobileWise


  Scenario Outline: Create Mobile And Web Applications

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Create A Project
    And Clicked on the Project
    And Click on Breadcrumb <homepage_validation_text>
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> Upload Logo and Click on Next
    And Update <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message> <app_name>


    Examples:
      | username | password     | expected_output | application_type | app_name             | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | toaster_message                   | suggestion_message        | application_name_field_message                   | homepage_validation_text |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  "  | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "1234567890  "       | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App"    | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name already exists!"               | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | ""                   | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name is required!"                  | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "D"                  | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name must be atleast 3 characters." | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App0"   | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App 1 " | "Demo Application Description" | "Yellow Light"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App 2 " | "Demo Application Description" | "Green Light"   | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App"       | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App"       | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name already exists!"               | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | ""                   | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "D"                  | "Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name is required!"                  | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App0"      | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App1"      | "Demo Application Description" | "Yellow Light"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
#      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App2"      | "Demo Application Description" | "Green Light"   | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."                    | "Projects"               |
