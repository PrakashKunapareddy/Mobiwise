Feature: Functionality of Drag and Drop In Mobile Wise


  Scenario Outline: Drag and Drop Components


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Create A Project
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> and Click next <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message> <app_name>
    And Click on the Pages Module, Click on the <work_page> and click on the Add Component Button
    And Click on the <components_panel> and drag the <component> to the screen builder <offset_value_x> <offset_value_y>
    And Verify the <component> on the screen builder
    Then Delete The component from The Screen Builder <component>

    Examples:
      | username | password     | expected_output | application_type | app_name      | application_name_field_message | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message        | toaster_message                    | components_panel | component   | offset_value_x | offset_value_y | work_page |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Navigation"     | "Navbar"                                                                                        | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Scanner"                                                                                       | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Scanner,Image,Text,Check Box,File Picker,Image,Scanner,Image,Text,Check Box,File Picker,Image" | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Image"                                                                                         | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Text"                                                                                          | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Check Box"                                                                                     | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "File Picker"                                                                                   | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Media Upload"                                                                                  | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Date Picker"                                                                                   | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Radio Button"                                                                                  | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Drop Down"                                                                                     | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Range Picker"                                                                                  | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Text Field"                                                                                    | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Buttons"        | "Save"                                                                                          | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Separator"                                                                                     | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Geotag"                                                                                        | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Geofence"                                                                                      | "500"          | "0"            |     "Landing"      |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"        | "Address"                                                                                       | "500"          | "0"            |     "Landing"      |
#      | "sana@ui"  | "mobile@123" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Display"        | "Data List" | "500"          | "0"            | "Landing" |

