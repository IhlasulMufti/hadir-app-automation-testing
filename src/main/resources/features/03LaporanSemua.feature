Feature: LaporanSemua

  Scenario Outline: Success view all report data by entering name, department, date
    Given I am logged in to the website with email "<email>" and password "<password>"
    And I headed to the report all page
    When I add name "<name>"
    And I add departement "<departemen>"
    And I add start date "<startDate>"
    And I add end date "<endDate>"
    And I click the search button
    Then I view all report data by entering name, department, date

    Examples:
     | email            | password    | name          |  departemen     | startDate   | endDate       |
     | admin@hadir.com  | admin@hadir | testerjuara   |  IT Programmer  | Nov 8, 2024 | Nov 11, 2024  |

 Scenario Outline: View all report data by not enter name, department, date
    Given I am logged in to the website with email "<email>" and password "<password>"
    And I headed to the report all page
    When I click on the search button
    Then I view all report data by not enter name, department, date

    Examples:
     | email            | password    |
     | admin@hadir.com  | admin@hadir |

    Scenario Outline: View report data by using Input unregistered name
      Given I am logged in to the website with email "<email>" and password "<password>"
      And I headed to the report all page
      When I added an unregistered name "<name>"
      And I click the search button
      Then I view all report data by entering name

      Examples:
        | email            | password    | name          |
        | admin@hadir.com  | admin@hadir | naruto        |

    Scenario Outline: View all report data by entering the start date and end date
      Given I am logged in to the website with email "<email>" and password "<password>"
      And I headed to the report all page
      When I input start date "<startDate>" and end date "<endDate>"
      And I click button save and search
      Then I view all report data by entering the start date and end date

      Examples:
        | email            | password    | startDate   | endDate       |
        | admin@hadir.com  | admin@hadir | Nov 8, 2024 | Nov 11, 2024  |

    Scenario Outline: Display all report data by entering a start date without an end date
      Given I am logged in to the website with email "<email>" and password "<password>"
      And I headed to the report all page
      And I add start date "<startDate>"
      And I click button save and search
      Then I Display all report data by entering a start date without an end date

      Examples:
        | email            | password    | startDate   |
        | admin@hadir.com  | admin@hadir | Nov 8, 2024 |

    Scenario Outline: Display all report data by entering end date without start date
      Given I am logged in to the website with email "<email>" and password "<password>"
      And I headed to the report all page
      And I click button datepicker
      And I add end date "<endDate>"
      And I click the search button
      Then Display all report data by entering end date without start date

      Examples:
        | email            | password    | endDate      |
        | admin@hadir.com  | admin@hadir | Nov 11, 2024 |

    Scenario Outline: Displays report data all with department and date input
      Given I am logged in to the website with email "<email>" and password "<password>"
      And I headed to the report all page
      And I add departement "<departemen>"
      And I add start date "<startDate>"
      And I add end date "<endDate>"
      And I click the search button
      Then Displays report data all with department and date input

      Examples:
        | email            | password    |  departemen     | startDate   | endDate       |
        | admin@hadir.com  | admin@hadir |  IT Programmer  | Nov 8, 2024 | Nov 11, 2024  |

      Scenario Outline: Entering dates is not formatted
        Given I am logged in to the website with email "<email>" and password "<password>"
        And I headed to the report all page
        And I add start date "<startDate>"
        And I add end date "<endDate>" and not save
        Then I see a warning emblem

        Examples:
          | email            | password    | startDate     | endDate      |
          | admin@hadir.com  | admin@hadir | Nov, 08 2024  | Nov, 11 2024 |

        Scenario Outline: Reset all inputs using the Reset button
          Given I am logged in to the website with email "<email>" and password "<password>"
          And I headed to the report all page
          And I click the reset button
          Then I see the All Reports page

          Examples:
            | email            | password    |
            | admin@hadir.com  | admin@hadir |