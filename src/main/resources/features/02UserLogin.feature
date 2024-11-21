Feature: User Login

  # TCC.Hadir.01.060
  Scenario Outline: Login with email and password valid
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should be redirected to dashboard page for absent

    Examples:
      | email               | password |
      | testuser1@gmail.com | 12345678 |

  # TCC.Hadir.01.070
  Scenario Outline: Account log out verification
    Given I am logged in with email "<email>" and password "<password>" for absent
    When I click sidebar menu
    And I click log out button for absent
    Then I should be redirected to login page for absent

    Examples:
      | email               | password |
      | testuser1@gmail.com | 12345678 |

  # TCC.Hadir.01.061 - TCC.Hadir.01.062
  # TCC.Hadir.01.065 - TCC.Hadir.01.067
  Scenario Outline: Login with email and password invalid
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then Error with message "<error_message>" will appear

    Examples:
      | email                | password    | error_message                      |
      | invalid@hadir.com    | admin@hadir | Akun tidak ditemukan               |
      | notactive2@gmail.com | 12345678    | Pendaftaran akun belum di aktivasi |
      |                      |             | Akun tidak ditemukan               |
      |                      | 12345678    | Akun tidak ditemukan               |
      | testuser1@gmail.com  |             | Email atau password salah          |
      | testuser1@gmail.com  | invalid     | Email atau password salah          |

  # TCC.Hadir.01.063, TCC.Hadir.01.064, TCC.Hadir.01.078
  Scenario Outline: Login with invalid format email
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then Failed to login and still in the login page "<url>"

    Examples:
      | email                | password | url                                      |
      | testuser1gmail.com   | 12345678 | https://magang.dikahadir.com/absen/login |
      | test@user1@gmail.com | 12345678 | https://magang.dikahadir.com/absen/login |
      | ahay@gmailcom        | 12345678 | https://magang.dikahadir.com/absen/login |

  # TCC.Hadir.01.068
  Scenario Outline: Password masking verification when entering password
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    Then Password value is hidden

    Examples:
      | email              | password |
      | testuser1gmail.com | 12345678 |

  # TCC.Hadir.01.069
  Scenario Outline: Disable password masking
    Given I am on the login page for absent
    When I enter email "<email>" and password "<password>"
    And I click hidden password button
    Then Password value revealed

    Examples:
      | email              | password |
      | testuser1gmail.com | 12345678 |