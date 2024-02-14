Feature: Page Module functionality in Mobile App Builder in Mobile-wise


  Scenario Outline: Verify The Default Pages in Pages Module and the Add Page Functionality

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Check Username of the User <username>
    And Create A Project
    And Clicked on the Project
    And Click on the <application_type>
    And Enter <app_name> <application_name_field_message> <app_desc> and Click next <themes_dropdown> <headings_dropdown> <body_dropdown> <suggestion_message> and Click on Next
    And  Validate Application Created <toaster_message> <app_name>
    And Verify Pages Module When Application Is opened <pages>
    And Verify <default_pages>
    And Add Page to The Application <page_name> <error_message> <entity_name> <entity_error_message> <edit_entity_name>
    And verify added page <page_name>
    And Edit added Page <edit_page_name> <page_name> <error_message> <entity_name> <entity_error_message> <edit_entity_name>
    Then Delete Added page <edit_page_name> <error_page_delete>



    Examples:
      | username | password     | expected_output | application_type | app_name            | app_desc                        | themes_dropdown | headings_dropdown | body_dropdown | toaster_message                   | suggestion_message        | application_name_field_message | pages   | default_pages                 | page_name  | edit_page_name | error_message                     | entity_name  | entity_error_message                              | edit_entity_name | error_page_delete         |
#     Positive Flow
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "New Page"    | "New Page 1"   | "Please fill the above textfield" | "Entity New" | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |
#      Empty Fields
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | ""         | "New Page 1"   | "Please fill the above textfield" | "Entity New" | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "New Page" | "New Page 1"   | "Please fill the above textfield" | ""           | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "New Page" | ""             | "Please fill the above textfield" | "Entity New" | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |
      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "New Page" | "New Page 1"   | "Please fill the above textfield" | "Entity New" | "Entity not found. Please create an entity first" | ""               | "Unable to Delete , Page" |
#Add & Edit page names with Existing names
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "Landing"     | "New Page 1"   | "Page name already exists"        | "Entity New" | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "New Page 1 " | "New Page 1"   | "Page name already exists"        | "Entity New" | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |
#Add & Edit Entity Name
#      | "dummy"  | "1234567890" | "Projects"      | " Mobile App "   | "Demo Mobile App  " | "Demo Application Description " | "Custom Theme"  | "Roboto Flex"     | "Roboto Flex" | "Sucessfully Created Application" | "This is required field!" | "Application name available."  | "Pages" | "Splash Screen,Login,Landing" | "New Page"    | "New Page 1"   | "Page name already exists"        | "Entity New" | "Entity not found. Please create an entity first" | "Entity New 1"   | "Unable to Delete , Page" |


