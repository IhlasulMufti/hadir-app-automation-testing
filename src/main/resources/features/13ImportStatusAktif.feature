Feature: Import Status Aktif

#  TCC.Hadir.02.011 (Positive Case)
  Scenario: Download Template: Status Active, successfully completed
    Given Admin logged in with email and password
    When Admin navigates to the import menu page
    And Admin navigates to the import sub menu page
    Then Admin clicked the Download Template button and it was successful

#  TCC.Hadir.02.012 (Positive Case)
  Scenario: Import file according to the template
    Given Admin logged in with email and password
    When Admin navigates to the import menu page
    And Admin navigates to the import sub menu page
    Then Click choose valid file
    And Click the import button
    And The file was imported successfully

#    Examples:
#      | fileName               | message                    |
#      |DATA_STATUS_USER.xlsx   | Import file excel berhasil |


#  TCC.Hadir.02.013 (Negative Case)
  Scenario: Imported file does not match template
    Given Admin logged in with email and password
    When Admin navigates to the import menu page
    And Admin navigates to the import sub menu page
    Then Click choose invalid file
    And Click the import button
    And The file failed to import

#    Examples:
#      | fileName                     | message               |
#      |DATA_STATUS_USER_INVALID.xlsx | Berhasil import excel |

#  TCC.Hadir.02.014 (Negative Case)
  Scenario: Import without selecting a file
    Given Admin logged in with email and password
    When Admin navigates to the import menu page
    And Admin navigates to the import sub menu page
    Then Click the import button without file

#    Examples:
#      | fileName       | message               |
#      |                | Please select a file. |

#  TCC.Hadir.02.015 (Negative Case)
  Scenario: Import does not match the file format
    Given Admin logged in with email and password
    When Admin navigates to the import menu page
    And Admin navigates to the import sub menu page
    Then Click choose invalid format file
    And Click the import button
    And The format file failed to import

#    Examples:
#      | fileName             | message                                         |
#      | DATA_STATUS_USER.pdf | *File harus berupa file Excel (.xls atau .xlsx) |

#  TCC.Hadir.02.016 (Negative Case)
  Scenario: Import file with empty data
    Given Admin logged in with email and password
    When Admin navigates to the import menu page
    And Admin navigates to the import sub menu page
    Then Click choose empty data file
    And Click the import button
    And The empty data file failed to import

#    Examples:
#      | fileName                           | message               |
#      | DATA_STATUS_USER_EMPTY_DATA.xlsx   | Berhasil import excel |
