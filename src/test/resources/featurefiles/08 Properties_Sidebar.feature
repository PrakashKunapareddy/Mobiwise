Feature: Add and Edit Properties for all Components


  Scenario Outline: Validation and Verification Of Properties Side Bar


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Create A Project
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> and Click next <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    Then Validate Application Created <toaster_message> <app_name>
    And Add Page to The Application <page_name> <entity_name>
    And Click on the Pages Module, Click on the <work_page> and click on the Add Component Button
    And Click on the <component_panel> and drag the <component> to the screen builder <offset_value_x> <offset_value_y>
    And Verify the <component> on the screen builder
    And Verify <component> sidebar and Validate Back button Functionality
    And Verify Panels in the Properties side bar <panels>
    And Edit <properties> Of the components in different panels and click on Update Component Button <panels> <values_comp> <component> <page_name> <work_page> <component_panel> <entity_name>




    Examples:
      | username | password     | expected_output | application_type | app_name      | application_name_field_message | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message        | toaster_message                    | component_panel                                                                                                   | component                                                                                                                                                                               | offset_value_x | offset_value_y | panels                                                                                                                                                                                                       | properties                                                                                                                                                                                                                                                                                                                                 | values_comp                                                                                                                                                                                                                                                                                              | page_name                    | entity_name  | work_page                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields,Navigation"                                                                                          | "Scanner,Text Field,Radio Button,Image,Navbar"                                                                                                                                          | "500"          | "0"            | "Scanner Property,Validation~Input Properties,Validation~Input Properties,Click Actions,Validation~Image Property,Validation~Button Styling,Click Actions,Nav Title Properties,Button Styling,Click Actions" | "Display Type,Label,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Title,Label,Top Margin,Select Action Type,Validation Type~Image,Top Margin,Select Action Type~Display Icon,Select Action Type,Title,Display Icon,Select Action Type"                                                    | "outlined,Barcode Scanner,20,Required_ ~outlined,First Name,text,Enter Name,20,Required_Error Message~Gender,Male-Female-NA_true-Other_false,20,Navigation_Page1,Required_Mandatory~D:\\MobileWise\\Logo\\logo2.webp,20,Navigation_page1~menu,Navigation_Page1,Homepage,true_logout_Navigation-Page1"    | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Navigation"                                                                                                      | "Navbar"                                                                                                                                                                                | "500"          | "0"            | "Button Styling,Click Actions,Nav Title Properties,Button Styling,Click Actions"                                                                                                                             | "Display Icon,Select Action Type,Title,Display Icon,Select Action Type"                                                                                                                                                                                                                                                                    | "menu,Navigation_Page1,HomePage,true_logout_Navigation-Page1"                                                                                                                                                                                                                                            | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Image,Text,Radio Button,Check Box"                                                                                                                                                     | "500"          | "0"            | "Image Property,Click Actions~Text Properties,Click Actions~Input Properties,Click Actions,Validation~Input Properties,Click Actions,Validation"                                                             | "Image,Top Margin,Select Action Type~Text,Position,Top Margin,Formatting Styles,Select Action Type~Title,Label,Top Margin,Select Action Type,Validation Type~Label,Top Margin,Select Action Type,Validation Type"                                                                                                                          | "D:\\MobileWise\\Logo\\logo2.webp,20,Navigation_Page1~Display Text,center,20,true-false-false-20,Navigation_Page1~Gender,Male-Female-NA_true-Other_false,20,Navigation_Page1,Required_Mandatory~Are You Happy,20,Navigation_Page1,Required_Mandatory"                                                    | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Text"                                                                                                                                                                                  | "500"          | "0"            | "Text Properties,Click Actions"                                                                                                                                                                              | "Text,Position,Top Margin,Formatting Styles,Select Action Type"                                                                                                                                                                                                                                                                            | "Display Text,center,20,true-false-false-20,Navigation_none"                                                                                                                                                                                                                                             | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Radio Button"                                                                                                                                                                          | "500"          | "0"            | "Input Properties,Click Actions,Validation"                                                                                                                                                                  | "Title,Label,Top Margin,Select Action Type,Validation Type"                                                                                                                                                                                                                                                                                | "Gender,Male_true-Female_true-NA_true-Other_false,20,Navigation_Page1,Required_Mandatory"                                                                                                                                                                                                                | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Check Box"                                                                                                                                                                             | "500"          | "0"            | "Input Properties,Click Actions,Validation"                                                                                                                                                                  | "Label,Top Margin,Select Action Type,Validation Type"                                                                                                                                                                                                                                                                                      | "Are You Happy,20,Navigation_Page1,Required_Mandatory"                                                                                                                                                                                                                                                   | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "File Picker"                                                                                                                                                                           | "500"          | "0"            | "File Properties,Validation"                                                                                                                                                                                 | "Display Type,Label,Top Margin,File Types,Max Size,Preview File,File Compression,Validation Type"                                                                                                                                                                                                                                          | "outlined,Upload File,20,PDF,100,true,false,Required"                                                                                                                                                                                                                                                    | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Text Field"                                                                                                                                                                            | "500"          | "0"            | "Input Properties,Validation"                                                                                                                                                                                | "Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type"                                                                                                                                                                                                                                                                      | "outlined,First Name,text,Enter Name,20,Maximum Length_20-Required_Mandatory"                                                                                                                                                                                                                            | "Page1,Page2,Page3,Add User" | "entity1"    | "Landing"                   |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Drop Down"                                                                                                                                                                             | "500"          | "0"            | "Input Properties,Validation,Data Source,Click Actions"                                                                                                                                                      | "Display Type,Label,Dropdown Type,Top Margin,Validation Type,Drop Down Type,Select Action Type"                                                                                                                                                                                                                                            | "outlined,Nationality,SingleSelect,20,Required_imp,Manual_India_Aus_England,Navigation_Page1"                                                                                                                                                                                                            | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Drop Down"                                                                                                                                                                             | "500"          | "0"            | "Input Properties,Validation,Data Source,Click Actions"                                                                                                                                                      | "Display Type,Label,Dropdown Type,Top Margin,Validation Type,Drop Down Type,Select Action Type"                                                                                                                                                                                                                                            | "outlined,Nationality,SingleSelect,20,Required_imp,API_,Navigation_Page1"                                                                                                                                                                                                            | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Media Upload"                                                                                                                                                                          | "500"          | "0"            | "Image/Video Properties,Validation"                                                                                                                                                                          | "Display Type,Label,Top Margin,Upload Type,Validation Type"                                                                                                                                                                                                                                                                                | "outlined,Upload Image,20,image_JPEG_1_true_true_true,Required"                                                                                                                                                                                                                                          | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Media Upload"                                                                                                                                                                          | "500"          | "0"            | "Image/Video Properties,Validation"                                                                                                                                                                          | "Display Type,Label,Top Margin,Upload Type,Validation Type"                                                                                                                                                                                                                                                                                | "outlined,Upload Video,20,video_Mp4_10_true_true_true,Required"                                                                                                                                                                                                                                          | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Date Picker"                                                                                                                                                                           | "500"          | "0"            | "Date Picker Properties,Validation"                                                                                                                                                                          | "Display Type,Label,Top Margin,Validation Type"                                                                                                                                                                                                                                                                                            | "outlined,Date Of Birth,20,dd/MM/yyyy,true,5,10,Required_mandatory"                                                                                                                                                                                                                                      | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"                                                                                                     | "Range Picker"                                                                                                                                                                          | "500"          | "0"            | "Range Picker Properties,Validation"                                                                                                                                                                         | "Display Type,Label,Top Margin,Select Date Format,MinDays,maxDays,Validation Type"                                                                                                                                                                                                                                                         | "outlined,Date From and To,20,dd/MM/yyyy,1,5,Required"                                                                                                                                                                                                                                                   | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Buttons"                                                                                                         | "Save"                                                                                                                                                                                  | "500"          | "0"            | "Button Styling,Click Actions"                                                                                                                                                                               | "Display Type,Text,Top Margin,Formatting Styles,Select Action Type"                                                                                                                                                                                                                                                                        | "filled,Submit,20,true-false-false-18,Navigation_Page1"                                                                                                                                                                                                                                                  | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"                                                                                                         | "Separator"                                                                                                                                                                             | "500"          | "0"            | "Separator Property"                                                                                                                                                                                         | "Thickness,Top Margin"                                                                                                                                                                                                                                                                                                                     | "100,50"                                                                                                                                                                                                                                                                                                 | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"                                                                                                         | "Geotag"                                                                                                                                                                                | "500"          | "0"            | "Geo Property,Validation"                                                                                                                                                                                    | "Label,Top Margin,Validation Type"                                                                                                                                                                                                                                                                                                         | "Live Location,20,Required"                                                                                                                                                                                                                                                                              | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"                                                                                                         | "Geofence"                                                                                                                                                                           | "500"          | "0"            | "Geofence Property,Validation"                                                                                                                                                                               | "Label,Top Margin,Select GeoFence Type,Select GeoFence Shape,Validation Type"                                                                                                                                                                                                                                                              | "Pole Location,20,walking,line,Required"                                                                                                                                                                                                                                                                 | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"                                                                                                         | "Address"                                                                                                                                                                               | "500"          | "0"            | "Address Properties,Validation"                                                                                                                                                                              | "Display Type,Label,PlaceHolder,Top Margin,Validation Type"                                                                                                                                                                                                                                                                                | "outlined,City Name,Enter Present City Name...,20,Required"                                                                                                                                                                                                                                              | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Add Ons"                                                                                                         | "Printer"                                                                                                                                                                               | "500"          | "0"            | "Printer Properties,Click Actions"                                                                                                                                                                           | "Display Type,Text,Top Margin,Select Action Type"                                                                                                                                                                                                                                                                                          | "filled,Print Details,20,Navigation_Page1"                                                                                                                                                                                                                                                             | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields,Display"                                                                                             | "Text Field,Text Field,Text Field,Text Field,Data List"                                                                                                                                 | "500"          | "0"            | "Input Properties,Validation~Input Properties,Validation~Input Properties,Validation~Input Properties,Validation~Data List Properties"                                                                       | "Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Data List Type,Entity,Card Design,Data List Display View" | "outlined,First Name,text,Enter Name,20,none~outlined,Middle Name,text,Enter Name,20,none~outlined,Last Name,text,Enter Name,20,none~outlined,Nick Name,text,Enter Name,20,none~Card,entity1,First Name_Last Name+Middle Name_Nick Name,First Name_true-Last Name_true-Middle Name_false-Nick Name_true" | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Display"                                                                                                         | "Data List"                                                                                                                                                                             | "500"          | "0"            | "Data List Properties"                                                                                                                                                                                       | "Data List Type,Entity,Card Design,Data List Display View"                                                                                                                                                                                                                                                                                 | "Card,entity1,First Name_Last Name@Middle Name_Nick Name,First Name_true-Last Name_true-Middle Name_false-Nick Name_true"                                                                                                                                                                                | "Page1"                      | "entity1"    | "Landing"                   |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Blue Light"    | "Roboto"          | "Arial"       | "This is required field!" | "Sucessfully Created Application " | "Buttons,Forms Fields,Navigation,Buttons,Forms Fields,Navigation,Buttons,Forms Fields,Add Ons,Navigation,Display" | "Save,Save,Image,Navbar,Save,Text Field,Text Field,Radio Button,Date Picker,Text Field,Text Field,Text Field,Navbar,Save,Check Box,Drop Down,Geotag,Separator,Address,Navbar,Data List" | "500"          | "0"            | "~Data List Properties"                                                                                                                                                                                      | "Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Display Type,Label,Data Type,PlaceHolder,Top Margin,Validation Type~Data List Type,Entity,Card Design,Data List Display View" | "outlined,First Name,text,Enter Name,20,none~outlined,Middle Name,text,Enter Name,20,none~outlined,Last Name,text,Enter Name,20,none~outlined,Nick Name,text,Enter Name,20,none~Card,entity1,First Name_Last Name+Middle Name_Nick Name,First Name_true-Last Name_true-Middle Name_false-Nick Name_true" | "Page1,Page2,Page3"          | "UserEntity" | "Landing,Page1,Page2,Page3" |






