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

  # TCC.Hadir.01.001
  Scenario Outline: Login with email and password valid
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

  # TCC.Hadir.01.012
  Scenario Outline: Account log out verification
    Given I am logged in with email "<email>" and password "<password>"
    When I click user profile
    And I click log out button
    Then I should be redirected to login page

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

  # TCC.Hadir.01.002, TCC.Hadir.01.003,
  # TCC.Hadir.01.006 - TCC.Hadir.01.009
  Scenario Outline: Login with email and password invalid
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then Error with message "<error_message>" will appear

    Examples:
      | email               | password    | error_message                      |
      | invalid@hadir.com   | admin@hadir | Akun tidak ditemukan               |
      | notactive@gmail.com | 12345678    | Pendaftaran akun belum di aktivasi |
      |                     |             | Akun tidak ditemukan               |
      |                     | admin@hadir | Akun tidak ditemukan               |
      | admin@hadir.com     |             | Email atau password salah          |
      | admin@hadir.com     | invalid     | Email atau password salah          |

  # TCC.Hadir.01.004 - TCC.Hadir.01.005, TCC.Hadir.01.077
  Scenario Outline: Login with invalid format email
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then Failed to login and still in the login page "<url>"

    Examples:
      | email             | password    | url                                               |
      | adminhadir.com    | admin@hadir | https://magang.dikahadir.com/authentication/login |
      | adm@in@hadir.com  | admin@hadir | https://magang.dikahadir.com/authentication/login |
      | ahay@gmailcom     | 12345678    | https://magang.dikahadir.com/authentication/login |

  # TCC.Hadir.01.010
  Scenario Outline: Password masking verification when entering password
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    Then Password value is hidden

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

  # TCC.Hadir.01.011
  Scenario Outline: Disable password masking
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click hidden password button
    Then Password value revealed

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |