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
      | username | password     | expected_output | application_type | app_name      | application_name_field_message | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message        | toaster_message                    | work_page                   | component_panel                                                                                                   | component                                                                                                                                                                 | panels                  | properties                                                                                                                                                                                                                                                                                                                                 | values_comp                                                                                                                                                                                                                                                                                              | page_name           | entity_name  |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Blue Light"    | "Roboto"          | "Arial"       | "This is required field!" | "Sucessfully Created Application " | "Landing,Page1,Page2,Page3" | "Buttons,Form Fields,Navigation~Buttons,Form Fields,Navigation~Buttons,Form Fields,Add Ons,Navigation~Display" | "Save,Save,Image,Navbar~Save,Text Field,Text Field,Radio Button,Date Picker,Text Field,Text Field,Text Field~Save,Drop Down,Check Box,Geotag,Separator,Address~Data List" | "~Data List Properties" | "Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Data List Type,Entity,Card Design,Data List Display View" | "outlined,First Name,text,Enter Name,20,none~outlined,Middle Name,text,Enter Name,20,none~outlined,Last Name,text,Enter Name,20,none~outlined,Nick Name,text,Enter Name,20,none~Card,entity1,First Name_Last Name+Middle Name_Nick Name,First Name_true-Last Name_true-Middle Name_false-Nick Name_true" | "Page1,Page2,Page3" | "UserEntity" |

