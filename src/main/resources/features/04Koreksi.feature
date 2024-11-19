#Feature: Koreksi
#
#   # TCC.Hadir.01.036 #PositiveCase
#  Scenario Outline: Verifikasi data koreksi dengan input tanggal yang sesuai
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Select start date "Nov 07, 2024" and end date "Nov 09, 2024"
#    And Click save button
#    And Click search button
#    Then Verify the date displayed same as selected date
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#   # TCC.Hadir.01.037 #PositiveCase
#  Scenario Outline: Verifikasi data koreksi dengan input nama dan input tanggal yang sesuai
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Input name "UserQA"
#    When Select start date "Nov 07, 2024" and end date "Nov 09, 2024"
#    And Click save button
#    And Click search button
#    Then Verify the date displayed same as selected date
#    Then Verify the name displayed same as input name
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#   # TCC.Hadir.01.038 #NegativeCase
#  Scenario Outline: Menampilkan data koreksi dengan tidak mengisi tanggal yang sesuai
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Select start date "Nov 20, 2024" and end date "Nov 21, 2024"
#    And Click save button
#    And Click search button
#    Then Verify no data is displayed
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.039 #NegativeCase
#  Scenario Outline: Menampilkan data koreksi dengan input nama yang tidak sesuai, tetapi tanggal valid
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Input name "testerjuara"
#    When Select start date "Nov 07, 2024" and end date "Nov 09, 2024"
#    And Click save button
#    And Click search button
#    Then Verify no data is displayed
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#   # TCC.Hadir.01.040 #NegativeCase
#  Scenario Outline: Menampilkan data koreksi dengan input nama yang sesuai, tetapi tanggal tidak valid
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Input name "UserQA"
#    When Select start date "Nov 20, 2024" and end date "Nov 21, 2024"
#    And Click save button
#    And Click search button
#    Then Verify no data is displayed
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.041 #PositiveCase
#  Scenario Outline: Menampilkan data koreksi dengan input nama departemen menggunakan filter By Unit
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Click filter icon
#    When Click search department
#    And Input Unit name
#    And Click terapkan button
#    Then Verify "UNIT" is displayed
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.042 #NegativeCase
#  Scenario Outline: Menampilkan data koreksi dengan tidak memilih departemen menggunakan filter By Unit
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    When Click filter icon
#    Then Verify terapkan button is not clickable
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.043 #PositiveCase
#  Scenario Outline: Approval koreksi absen yang diajukan
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    And Click approved button
#    Then Verify approval is success
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.044 #PositiveCase
#  Scenario Outline: Reject koreksi absen yang diajukan
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    And Click reject button
#    And Input alasan reject
#    Then Verify rejected is success
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.045 #PositiveCase
#  Scenario Outline: Ubah tampilkan row per page menjadi 5
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    And Change view to 5 rows
#    Then Verify table display 5 rows
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.046 #PositiveCase
#  Scenario Outline: Ubah tampilkan row per page menjadi 25
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    And Change view to 25 rows
#    Then Verify table display 25 rows
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#    # TCC.Hadir.01.047 #NegativeCase
#  Scenario Outline: Reject koreksi absen yang diajukan tanpa mengisi alasan
#    Given I am logged in with email "<email>" and password "<password>"
#    When Click laporan button
#    When Click koreksi button
#    And Click reject button
#    And Click tolak button
#    Then Verify rejected is failed
#
#    Examples:
#      | email           | password    |
#      | admin@hadir.com | admin@hadir |
#
#
#
#
