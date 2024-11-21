Feature: Import Status Aktif

#  TCC.Hadir.02.017 (Positive Case)
  Scenario: Download Template: Struktur User, successfully completed
    Given Admin login with email and password
    When Admin navigates to the import menu page Struktur User
    And Admin navigates to the import sub menu page Struktur User
    Then Admin clicked the Download Template Struktur User button and it was successful

#  TCC.Hadir.02.018 (Positive Case)
  Scenario: Import file according to the template Struktur User
    Given Admin login with email and password
    When Admin navigates to the import menu page Struktur User
    And Admin navigates to the import sub menu page Struktur User
    Then Click choose valid file Struktur User
    And Click the import button Struktur User
    And The file was imported successfully Struktur User

#    Examples:
#      | fileName                 | message               |
#      |DATA_STRUKTUR.USER.xlsx   | Berhasil import excel |


#  TCC.Hadir.02.019 (Negative Case)
  Scenario: Imported file does not match template Struktur User
    Given Admin login with email and password
    When Admin navigates to the import menu page Struktur User
    And Admin navigates to the import sub menu page Struktur User
    Then Click choose invalid file Struktur User
    And Click the import button Struktur User
    And The file failed to import Struktur User

#    Examples:
#      | fileName                       | message               |
#      |DATA_STRUKTUR_USER_INVALID.xlsx | Berhasil import excel |

#  TCC.Hadir.02.020 (Negative Case)
  Scenario: Import without selecting a file Struktur User
    Given Admin login with email and password
    When Admin navigates to the import menu page Struktur User
    And Admin navigates to the import sub menu page Struktur User
    Then Click the import button without file Struktur User

#    Examples:
#      | fileName       | message               |
#      |                | Please select a file. |

#  TCC.Hadir.02.021 (Negative Case)
  Scenario: Import does not match the file format Struktur User
    Given Admin login with email and password
    When Admin navigates to the import menu page Struktur User
    And Admin navigates to the import sub menu page Struktur User
    Then Click choose invalid format file Struktur User
    And Click the import button Struktur User
    And The format file failed to import Struktur User

#    Examples:
#      | fileName               | message                                         |
#      | DATA_STRUKTUR_USER.pdf | *File harus berupa file Excel (.xls atau .xlsx) |

#  TCC.Hadir.02.022 (Negative Case)
  Scenario: Import file with empty data Struktur User
    Given Admin login with email and password
    When Admin navigates to the import menu page Struktur User
    And Admin navigates to the import sub menu page Struktur User
    Then Click choose empty data file Struktur User
    And Click the import button Struktur User
    And The empty data file failed to import Struktur User

#    Examples:
#      | fileName                             | message               |
#      | DATA_STRUKTUR_USER_EMPTY_DATA.xlsx   | Berhasil import excel |