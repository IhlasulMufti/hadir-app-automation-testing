Feature: Login
  # Gunakan 'Scenario Outline' dan pakai step 'Given' di bawah ini untuk login dalam sekali step:
  # Given I am logged in with email "<email>" and password "<password>"
  # Contoh Scenario Outline:
  #
  #  Scenario Outline: test sekali login
  #    Given I am logged in with email "<email>" and password "<password>"
  #
  #    Examples:
  #      | email           | password    |
  #      | admin@hadir.com | admin@hadir |
  # -----------------------------------------------------------------------------------------

  Scenario Outline: Login with email and password valid
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page


    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

