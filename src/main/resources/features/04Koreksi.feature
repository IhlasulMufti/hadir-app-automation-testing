Feature: Koreksi

  Scenario Outline: Menampilkan data koreksi dengan input nama dan tanggal yang sesuai
    Given Klik button menu laporan
    When Klik button menu koreksi
    And Masukkan nama yang sesuai "<nama>"
    And Klik button date
    And Pilih start date yang sesuai "<startdate>"
    And Pilih end date yang sesuai "<enddate>"
    And klik button save date
    And Klik button search
    Then Verifikasi terdapat data dengan nama dan tanggal yang sesuai
    And Klik button reset

    Examples:
       | nama     | startdate     | enddate |
       |          | Nov 07, 2024  | Nov 09, 2024 |
       |UserQA    | Nov 07, 2024  | Nov 09, 2024 |

  Scenario: Approval koreksi absen yang diajukan
    Given Masukkan nama yang valid
    When Klik button search
    And Klik icon approval
    And Klik button setujui
    Then Verifikasi status karyawan
    And Klik button reset



  # negative test
  Scenario Outline: Reject koreksi absen yang diajukan
    Given Masukkan nama yang valid "<nama>"
    When  Klik button date
    And Masukkan start date valid "<startdate>"
    And Masukkan end date valid "<enddate>"
    And klik button save date
    And Klik button search
    And Klik button reject
    And Masukkan Alasan reject
    And Klik button tolak
    Then Verifikasi Status karyawan reject
    And Klik button reset 

    Examples:
      | nama                 | startdate     | enddate      |
      | Hadir SQA Testing 1  | Feb 14, 2025  | Feb 17, 2025 |