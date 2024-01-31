Feature: Adding Mobile Application And Web Application for Created Project In MobileWise


  Scenario Outline: Create Mobile And Web Applications

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output> <valid_username>
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <app_desc> Upload Logo and Click on Next
    And Update <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message>


    Examples:
      | username | password     | expected_output | valid_username | application_type | app_name                  | app_desc                       | themes_dropdown     | headings_dropdown | body_dropdown | toaster_message                         | suggestion_message        |
      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Custom Theme"      | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application "      | "This is required field!" |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Web Application"    | "Demo Application Description" | "Custom Theme"      | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application "      | "This is required field!" |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Blue Light"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Yellow Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Orange Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Deep Orange Light" | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Green Light"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Pink Light"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Teal Light"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Indigo Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "M3 Baseline Light" | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Blue Dark"         | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Yellow Dark"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Orange Dark"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Green Dark"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Pink Dark"         | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Teal Dark"         | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "M3 Baseline Dark"  | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Indigo Dark"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Deep Orange Dark"  | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Web Application"    | "Demo Application Description" | "Yellow Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Blue Light"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Yellow Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Orange Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Deep Orange Light" | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Green Light"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Pink Light"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Teal Light"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Indigo Light"      | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "M3 Baseline Light" | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Blue Dark"         | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Yellow Dark"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Orange Dark"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Green Dark"        | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Pink Dark"         | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Teal Dark"         | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "M3 Baseline Dark"  | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Indigo Dark"       | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Mobile Application" | "Demo Application Description" | "Deep Orange Dark"  | "Roboto"          | "Open Sans"   | "Sucessfully Created Application "      |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Web App "      | "Demo Web Application"    | "Demo Application Description" | "Yellow Light"      | "Roboto"          | "Open Sans"   | "This Application name already exists!" |                           |
#      | "dummy"  | "1234567890" | "Projects"      | "dummy"        | " Mobile App "   | "Demo Mobile Application" | "Demo Application Description" | "Pink Light"        | "Roboto"          | "Open Sans"   | "This Application name already exists!" |                           |
