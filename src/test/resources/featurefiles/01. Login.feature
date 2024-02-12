Feature: Login Functionality for MobiWise SuperAdmin Login

  As a SuperAdmin of MobiWise
  SuperAdmin should be able to login into the account
  and can access the account related features of SuperAdmin

  Scenario Outline: Successful Login with valid username and password
    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>

    Examples:
      | username           | password          | expected_output       |
      | "dummy"            | "1234567890"      | "Projects"            |
      | "Invalid Username" | "invalidPassword" | "Invalid Username!"   |
      | "dummy"            | "abcd"            | "Incorrect Password!" |
      | ""                 | "abcd"            | "Invalid Username!"   |
      | "ABCD"             | ""                | "Invalid Username!"   |
      | ""                 | ""                | "Invalid Username!"   |

