Feature: Izin Off

   # TCC.Hadir.01.048 #PositiveCase
  Scenario Outline: Verifikasi data izin off dengan input tanggal yang sesuai
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Select start date "Nov 07, 2024" and end date "Nov 09, 2024"
    And Click save button
    And Click search button
    Then Verify the date displayed same as selected date

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

   # TCC.Hadir.01.049 #PositiveCase
  Scenario Outline: Verifikasi data izin off dengan input nama dan input tanggal yang sesuai
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Input name "UserQA"
    When Select start date "Nov 07, 2024" and end date "Nov 09, 2024"
    And Click save button
    And Click search button
    Then Verify the date displayed same as selected date
    Then Verify the name displayed same as input name

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

   # TCC.Hadir.01.050 #NegativeCase
  Scenario Outline: Menampilkan data izin off dengan tidak mengisi tanggal yang sesuai
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Select start date "Nov 20, 2024" and end date "Nov 21, 2024"
    And Click save button
    And Click search button
    Then Verify no data is displayed

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.051 #NegativeCase
  Scenario Outline: Menampilkan data izin off dengan input nama yang tidak sesuai, tetapi tanggal valid
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Input name "testerjuara"
    When Select start date "Nov 07, 2024" and end date "Nov 09, 2024"
    And Click save button
    And Click search button
    Then Verify no data is displayed

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

   # TCC.Hadir.01.052 #NegativeCase
  Scenario Outline: Menampilkan data izin off dengan input nama yang sesuai, tetapi tanggal tidak valid
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Input name "UserQA"
    When Select start date "Nov 20, 2024" and end date "Nov 21, 2024"
    And Click save button
    And Click search button
    Then Verify no data is displayed

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.053 #PositiveCase
  Scenario Outline: Menampilkan data izin off dengan input nama departemen menggunakan filter By Unit
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Click filter icon
    When Click search department
    And Input Unit name
    And Click terapkan button
    Then Verify "UNIT" is displayed

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.054 #NegativeCase
  Scenario Outline: Menampilkan data izin off dengan tidak memilih departemen menggunakan filter By Unit
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    When Click filter icon
    Then Verify terapkan button is not clickable

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.055 #NegativeCase
  Scenario Outline: Approval izin off yang diajukan dengan atasan berbeda
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    And Click aksi button
    And Click approval izin off
    And Click setujui button on the alert message
    Then Verify approval izin off is failed because different boss

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.056 #NegativeCase
  Scenario Outline: Reject izin off yang diajukan dengan atasan berbeda
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    And Click aksi button
    And Click reject izin off
    And Input dengan alasan reject and click tolak
    Then Verify rejected izin off is failed because different boss

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.057 #PositiveCase
  Scenario Outline: Ubah tampilkan row per page menjadi 5
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    And Change view to 5 rows
    Then Verify table display 5 rows

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.058 #PositiveCase
  Scenario Outline: Ubah tampilkan row per page menjadi 25
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    And Change view to 25 rows
    Then Verify table display 25 rows

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |

    # TCC.Hadir.01.059 #NegativeCase
  Scenario Outline: Reject izin off yang diajukan tanpa mengisi alasan
    Given I am logged in with email "<email>" and password "<password>"
    When Click laporan button
    When Click izin off button
    And Click aksi button
    And Click reject izin off
    And Click tolak without alasan
    Then Verify rejected izin off is failed

    Examples:
      | email           | password    |
      | admin@hadir.com | admin@hadir |




