Feature: Dashboard

  Scenario Outline: Successfully go to the dashboard page
    Given I am on the login page
    When I enter a valid email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirect to dashboard page
    Examples:
    | email             | password      |
    | admin@hadir.com   | admin@hadir   |
