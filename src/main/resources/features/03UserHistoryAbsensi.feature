Feature: History Absensi

  Scenario Outline: Visit the attendance history view via the attendance button
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent
    And I click Absensi
    Then I should be redirect to attendance history

    Examples:
      | email                 | password |
      | testerjuara@rocket.com| 12345678 |

  Scenario Outline: Return to the home view
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent
    And I click Absensi
    Then I should be redirect to attendance history
    And Return to the home view

    Examples:
      | email                  | password |
      | testerjuara@rocket.com | 12345678 |