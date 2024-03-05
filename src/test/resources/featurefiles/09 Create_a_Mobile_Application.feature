Feature: Create a Mobile Application in Mobile Builder


  Scenario Outline: Build a project "Registration Form for Mobile Wise"


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Create A Project
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> and Click next <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message> <app_name>
    And Click on the Pages Module, Click on the desired <work_page> and click on the Add Component Button <component_panel> <component> <properties> <panels> <values_comp> <page_name> <entity_name>



    Examples:
      | username | password     | expected_output | application_type | app_name      | application_name_field_message | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message        | toaster_message                    | work_page                   | component_panel                  | component         | panels                                                                                   | properties                                                                                                                                                                | values_comp                                                                                                                                                               | page_name           | entity_name  |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Blue Light"    | "Roboto"          | "Arial"       | "This is required field!" | "Sucessfully Created Application " | "Landing,Page1,Page2,Page3" | "Buttons,Form Fields,Navigation" | "Save,Save,Image" | "Button Styling,Click Actions~Button Styling,Click Actions~Image Property,Click Actions" | "Display type,Text,Top Margin,Formatting Styles,Select Action Type~Display type,Text,Top Margin,Formatting Styles,Select Action Type~Image,Top Margin,Select Action Type" | "filled,View Users,16,true-false-false-18,Navigation_Page3~filled,Add Users,16,true-false-false-18,Navigation_Page1~D:\\MobileWise\\Logo\\logo2.webp,16,Navigation_Page1" | "Page1,Page2,Page3" | "UserEntity" |

