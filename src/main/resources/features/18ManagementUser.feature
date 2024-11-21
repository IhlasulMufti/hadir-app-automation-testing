Feature: Management User

  Scenario Outline: Displays a list of user data by name
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    And I went to the management user page
    When I add name "<name>"
    And I click the search button
    Then I view list of user data by name

    Examples:
      | email            | password    | name          |
      | admin@hadir.com  | admin@hadir | testerjuara   |

  Scenario Outline: Search users by name with punctuation input
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    And I went to the management user page
    When I add name "<name>"
    And I click the search button
    Then I view list of user data by punctuation input

    Examples:
      | email            | password    | name           |
      | admin@hadir.com  | admin@hadir | tester&Juara   |