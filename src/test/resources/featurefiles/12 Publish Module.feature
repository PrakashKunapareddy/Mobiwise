Feature: Publish Module Check



  Scenario Outline: Verify Publish Module by navigating to Pages Module and Changing Properties of components

    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the Project
    And Click on the Mobile Application and Click On Page panel
    And Click on Publish Module and click on publish apk button
    And Click on pages Module and click on Landing Page And Add Component and delete the Component
    And Click on Publish Module and click on publish apk button
#    And Click on the data List and edit properties <values_comp>

    Examples:
      | username | password     | expected_output | values_comp                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
      | "dummy"  | "1234567890" | "Projects"      | "outlined,View Users,18,true-false-false-15,Navigation_Page3~filled,Add Users,18,true-false-false-15,Navigation_Page1~D:\\MobileWise\\Logo\\logo2.webp,20,none_none~menu,Navigation_Page1,Homepage,false_logout_Navigation-Page1%filled,Next,16,true-false-false-18,Navigation_Page2~outlined,Contact Number,text,Enter Phone Number,16,Maximum Length_20-Required_Mandatory~outlined,Email Address,text,Enter Email Address,16,Maximum Length_20-Required_Mandatory~Gender,Male-Female-NA_true-Other_false,16,Navigation_Page1,Required_Mandatory~outlined,Date Of Birth,16,Required_mandatory~outlined,Nick name,text,Enter Phone Number,16,Maximum Length_20-none~outlined,Last name,text,Enter Phone Number,16,Maximum Length_20-Required_Mandatory~outlined,First Name,text,Enter Name,16,Maximum Length_20-Required_Mandatory%filled,Submit,16,true-false-false-18,Navigation_Landing~Agree Terms & Conditions,16,none_Page1,Required_Mandatory~outlined,Nationality,SingleSelect,16,Required_imp,Manual_India_Aus_England,none~Live Location,16,none_none~3,16~outlined,Address,Enter Present Address..,16,none_none%Card,UserEntity,First Name_Last name@Date Of Birth_Gender,First Name_true-Last Name_true-Date Of Birth_true-Nick Name_true-Gender_true-Nationality_true-Address_true-Gender_false" |


