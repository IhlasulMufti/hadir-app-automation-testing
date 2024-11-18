Feature: Koreksi Absen

  Scenario Outline: Visit the view to the correction page
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent
    And i click attendance correction
    Then I should be redirect to correction page

    Examples:
      | email                  | password |
      | testerjuara@rocket.com | 12345678 |

  Scenario Outline: Applying for attendance with the appropriate data
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent
    And i click attendance correction
    Then I should be redirect to correction page
    And I click Request Correction
    And I choose a date and time
    And I choose attendance type
    And I click button request
    Then I see data correction page

    Examples:
      | email                  | password |
      | testerjuara@rocket.com | 12345678 |

  Scenario Outline: Applying for attendance without filling in data
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent
    And i click attendance correction
    Then I should be redirect to correction page
    And I click Request Correction
    And I click button request
    Then I see warning

    Examples:
      | email                  | password |
      | testerjuara@rocket.com | 12345678 |

  Scenario Outline: Return to the home absent view
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent
    And i click attendance correction
    And I click button back
    Then I see home absent view

    Examples:
      | email                  | password |
      | testerjuara@rocket.com | 12345678 |