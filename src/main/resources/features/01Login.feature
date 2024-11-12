Feature: Login
  Scenario Outline: Login with email and password valid
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |