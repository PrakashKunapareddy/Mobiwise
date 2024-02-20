Feature: Properties of components in Mobile Wise


  Scenario Outline: Validation and Verification Of Properties Side Bar


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
    And Verify the <component> on the screen builder
    And Verify <component> sidebar and Validate Back button Functionality
    And Verify Panels in the Properties side bar <panels>
    And Edit <properties> Of the components in different panels and click on Update Component Button <panels> <values>
    Then Verify the Components Properties





    Examples:
      | username | password     | expected_output | application_type | app_name      | application_name_field_message | app_desc                       | themes_dropdown | headings_dropdown | body_dropdown | suggestion_message        | toaster_message                    | components_panel | component | panels                        | properties                                      | values                               |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile" | "Application name available."  | "Demo Application Description" | "Pink Light"    | "Roboto Flex"     | "Roboto Flex" | "This is required field!" | "Sucessfully Created Application " | "Form Fields"    | "Scanner" | "Scanner Property,Validation" | "Display Type,Label,Top Margin,Validation Type" | "filled,Barcode Scanner,20,Required" |
