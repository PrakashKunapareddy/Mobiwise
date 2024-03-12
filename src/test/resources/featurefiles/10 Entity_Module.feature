Feature: Entity Module functionality in Mobile App Builder in Mobile-wise

  Scenario Outline: Validate the functionality and Verify the Entities in Entity Module


    Given Entered a valid <username> <password>
    When  Clicked on the sign in button
    And  Validate login <expected_output>
    And Clicked on the Project
    And Click on the Mobile Application and Click On Entity Module Click on Add Entity button
    And Enter an <entity_names> and add <mapped_pages>
    And Add <related_entity> to the <entity_names>
    And Click on Update Association Button <new_entity_names>
    And Edit <entity_names> and delete Mapped pages <new_entity_names>
    And Delete Added Entity <new_entity_names>

    Examples:
      | username | password     | expected_output | entity_names  | related_entity | new_entity_names | mapped_pages    | Example                     |
      | "dummy"  | "1234567890" | "Projects"      | "New Entity"  | "dummy"        | "New Entity 1"   | "Landing_false" | "Possitive"                 |

      | "dummy"  | "1234567890" | "Projects"      | "New Entity1" | "dummy"        | "New Entity 1"   | "Landing_false" | "Existing Entity Name Add"  |
      | "dummy"  | "1234567890" | "Projects"      | ""            | "dummy"        | "New Entity 1"   | "Landing_false" | "Empty Entity Name Add"     |
      | "dummy"  | "1234567890" | "Projects"      | "New Entity"  | "dummy"        | "New Entity 1"   | "Landing_false" | "Existing Entity Name Edit" |
      | "dummy"  | "1234567890" | "Projects"      | "New Entity"  | "dummy"        | ""               | "Landing_false" | "Empty Entity Name Edit"    |

