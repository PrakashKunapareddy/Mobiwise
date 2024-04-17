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
      | username | password     | expected_output | application_type | app_name          | application_name_field_message                   | app_desc                                                                                 | themes_dropdown | headings_dropdown | body_dropdown | toaster_message                   | suggestion_message        | homepage_validation_text |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App" | "Application name available."                    | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo"            | "Application name already exists!"               | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "1234567890 "     | "Application name available."                    | "Demo Application Description Demo Application Description Demo Application Description" | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | ""                | "Application name must be atleast 3 characters." | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "D"               | "Application name must be atleast 3 characters." | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App"    | "Application name available."                    | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | ""                | "Application name must be atleast 3 characters." | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "Thi is required field!"  | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "D"               | "Application name must be atleast 3 characters." | "Demo Application Description"                                                           | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App0"   | "Application name available."                    | "Demo Application Description"                                                           | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App1"   | "Application name available."                    | "Demo Application Description"                                                           | "Yellow Light"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web App2"   | "Application name available."                    | "Demo Application Description"                                                           | "Green Light"   | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Projects"               |