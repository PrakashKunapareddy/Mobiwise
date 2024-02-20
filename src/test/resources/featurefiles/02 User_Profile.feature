Feature: UserProfile functionality in Mobile-wise


  Scenario Outline: Change Password, Logout and verify Username in User Profile

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Check Username of the User <username>
    And Verify userprofile options <list_option1> <list_option2>
    And Update password <new_password> <confirm_password> and click Submit <new_password_error_message> <confirm_password_error> <password_suggestion_message>
    And Verify Successful Password Change <toaster_message>
    And Login again with New Password <username> <new_password> <expected_output>
    Then Validate Logout action <verify_logout>

    Examples:
      | username  | password       | expected_output | new_password    | confirm_password | verify_logout         | list_option1      | list_option2 | new_password_error_message                                                 | confirm_password_error   | password_suggestion_message                                                                                                                               | toaster_message                 |
      | "prakash" | "MobiWise@123" | "Projects"      | "MobiWise@123"  | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements"  | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobiWiseeeee"  | "mobiWiseeeee"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobiwiseeeee"  | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "Mobi"          | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobi"          | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobiWiseeeee1" | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobiwiseeeee1" | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobiWiseeeee@" | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "mobiwiseeeee@" | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "1234567890"    | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "@@@@@@@@@@@"   | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "WRONGPASSWORD" | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "1234567890"    | "MobiWise@123"   | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | ""              | "MobiWise"       | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
      | "prakash" | "MobiWise@123" | "Projects"      | "MobiWise@123"  | "MobiWise"       | "Sign In to Continue" | "Change Password" | "Logout"     | "The password you entered doesn't meet the minimum security requirements." | "Password doesn’t match" | "Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 3 Passwords." | "Password changed successfully" |
