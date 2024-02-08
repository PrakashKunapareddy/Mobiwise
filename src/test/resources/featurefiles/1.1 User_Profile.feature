Feature: UserProfile functionality in Mobile-wise


  Scenario Outline: Change Password, Logout and verify Username in User Profile

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output> <valid_username>
    And Check Username of the User <username>
    And Verify userprofile options <list_option1> <list_option2>
    And Update password <new_password> <confirm_password> and click Submit <new_password_error_message> <confirm_password_error> <password_suggestion_message>
    And Verify Successful Password Change <toaster_message>
    Given Entered a valid <username> <new_password>
    When  Clicked on the sign in button
    And  Validate login <expected_output> <valid_username>
    Then Validate Logout action <verify_logout>

    Examples:
      | username  | password | expected_output | new_password   | confirm_password | valid_username | verify_logout         | list_option1      | list_option2 | new_password_error_message                                                | confirm_password_error   | password_suggestion_message                                                                                                                               | toaster_message                   |
      | "prakash" | "123456" | "projects"      | "MobiWise@123" | "MobiWise@123"   | "prakash"      | "Sign In to Continue" | "Change Password" | " Logout "   | "The password you entered doesn't meet the minimum security requirements" | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 5 Passwords." | " Password changed successfully " |