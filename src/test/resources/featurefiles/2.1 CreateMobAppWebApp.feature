Feature: Adding Mobile Application And Web Application for Created Project In MobileWise


  Scenario Outline: Create Mobile And Web Applications

    Given Entered a valid SuperAdmin <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <app_desc> Upload Logo and Click on Next
    And Update <themes_dropdown> <headings_dropdown> <body_dropdown> and Click on Next
    Then Validate Application Created <toaster_message>


    Examples:
      | username | password     | expected_output | application_type | app_name                   | themes_dropdown | headings_dropdown | body_dropdown | app_desc                       | toaster_message                         |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile Application"  | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Demo Application Description" | "Sucessfully Created Application "      |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo1 Mobile Application" | "Pink Light"    | "Roboto"          | "Open Sans"   | "Demo Application Description" | "Sucessfully Created Application "      |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web Application"     | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Demo Application Description" | "Sucessfully Created Application "      |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web Application"     | "Yellow Light"  | "Roboto"          | "Open Sans"   | "Demo Application Description" | "Sucessfully Created Application "      |
      | "dummy"  | "1234567890" | "Projects"      | " Web App "      | "Demo Web Application"     | "Yellow Light"  | "Roboto"          | "Open Sans"   | "Demo Application Description" | "This Application name already exists!" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile Application"  | "Pink Light"    | "Roboto"          | "Open Sans"   | "Demo Application Description" | "This Application name already exists!" |
