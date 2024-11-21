Feature: Import Cuti

#  positive
  Scenario: Download Tamplate import cuti, successfully completed
    Given Admin login page
    When Admin import menu
    And Admin to go to the import sub menu
    Then Admin click the Download Template button

#    positive
  Scenario: Import file according to the template
    Given Admin login page
    When Admin import menu
    And Admin to go to the import sub menu
    Then Admin click Browser valid file
    And Admin click the import button
    And The file was import successfully

#    negative
  Scenario: Failing to import leave data due to incorrect file format
    Given Admin login page
    When Admin import menu
    And Admin to go to the import sub menu
    Then Admin import the file invalid format
    And Admin click the import button
    And Admin should see the error message Invalid file format

#    negative
  Scenario: Failing to import leave data due to incorrect file template
    Given Admin login page
    When Admin import menu
    And Admin to go to the import sub menu
    Then Admin import the file
    And Admin click the import button
    And Admin should see the error message Invalid file template

#  negative
  Scenario: Attempting to import leave data without selecting a file
    Given Admin login page
    When Admin import menu
    And Admin to go to the import sub menu
    Then Admin click the Import button without selecting a file

#  negative
  Scenario: Attempting to import leave data from an empty file
    Given Admin login page
    When Admin import menu
    And Admin to go to the import sub menu
    Then Admin import the file empty
    And Admin click the import button
    Then Admin should see the error message File cannot be empty

