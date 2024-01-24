Feature: Login Functionality for MobiWise SuperAdmin Login

  As a SuperAdmin of MobiWise
  SuperAdmin should be able to login into the account
  and can access the account related features of SuperAdmin

  Scenario Outline: Successful Login with valid username and password
    Given Entered a valid SuperAdmin <username> <password>
    When  Clicked on the sign in button
    Then  Validate login <expected_output>

    Examples:
      | username           | password          | expected_output                 |
      | "superadmin"       | "mobilewise@123"  | "Projects"                      |
      | "Mobilewise@123"   | "mobiwise@123   " | "Invalid username or password." |
      | "Invalid Username" | "invalidPassword" | "Invalid username or password." |
      | "ABCD"             | "abcd"            | "Invalid username or password." |
      | "super@admin"      | "1234567890"      | "Invalid username or password." |
      | "super"            | "mobiwise@123   " | "Invalid username or password." |
      | "admin"            | "invalidPassword" | "Invalid username or password." |
      | "vassar"           | "ssjkjss122"      | "Invalid username or password." |
      | "abc@gmail.com"    | "1234567890"      | "Invalid username or password." |