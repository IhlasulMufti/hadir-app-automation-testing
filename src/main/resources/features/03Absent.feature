Feature: Absent
  # TCC.Hadir.01.071, TCC.Hadir.01.079
  Scenario Outline: Successful clocking in (selfie)
    Given I am logged in with email "<email>" and password "<password>" for absent
    When I click clocking in button
    And I click camera button to take selfie
    And I verify the clock is correct with the current time
    And I input the absence type
    And I input a message "<note>" in the appropriate note
    And I click clocking in button for submit absent
    And I scroll to find history section
    Then Verify the absent information are correct and appear on the history page include note "<note>"
    And History page display a selfie photo

    Examples:
      | email               | password | note                          |
      | testuser4@gmail.com | 12345678 | absen masuk selfie pakai note |
      | testuser5@gmail.com | 12345678 |                               |

  # TCC.Hadir.01.072, TCC.Hadir.01.080
  Scenario Outline: Successful clocking in (non-selfie)
    Given I am logged in with email "<email>" and password "<password>" for absent
    When I click clocking in button
    And I verify the clock is correct with the current time
    And I input the absence type
    And I input a message "<note>" in the appropriate note
    And I click clocking in button for submit absent
    And I scroll to find history section
    Then Verify the absent information are correct and appear on the history page include note "<note>"

    Examples:
      | email                   | password | note                              |
      | noselfieuser3@gmail.com | 12345678 | absen masuk non-selfie pakai note |
      | noselfieuser4@gmail.com | 12345678 |                                   |

  # TCC.Hadir.01.073
  Scenario Outline: Unable to clock in when already clocked in on the same day
    Given I am logged in with email "<email>" and password "<password>" for absent
    When I click clocking in button
    Then Verify that the clocking in button is not found

    Examples:
      | email                   | password |
      | noselfieuser3@gmail.com | 12345678 |

  # TCC.Hadir.01.074, TCC.Hadir.01.081
  Scenario Outline: Successful clocking out
    Given I am logged in with email "<email>" and password "<password>" for absent
    When I scroll to find history section
    And I click Keluar button
    And I verify the clock is correct with the current time
    And I input a message "<note>" in the clocking out note
    And I click clocking out button for submit absent
    Then Verify the absent information are correct and appear on the history page include note "<note>"

    Examples:
      | email                   | password | note                              |
      | noselfieuser3@gmail.com | 12345678 | absen masuk non-selfie pakai note |
      | noselfieuser4@gmail.com | 12345678 |                                   |