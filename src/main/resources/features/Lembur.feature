Feature: Menu Lembur Negative and Positif Test

   # ----------- START NEGATIVE TEST ---------------

  Scenario: Menampilkan data laporan Lembur dengan memasukkan nama, departement dan tanggal yang tidak sesuai
    Given Klik button menu laporan
    When Klik button menu lembur
    And Masukkan nama yang tidak sesuai2
    And Klik button date
    And Pilih start date yang tidak sesuai2
    And Pilih end date yang tidak sesuai2
    And klik button save date
    And Klik button filter
    And Pilih unit yang tidak sesuai2
    And Klik button Terapkan
    And Klik button search
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    Then Klik button batal

  Scenario: Menampilkan data Lembur dengan memilih tanggal start date yang tidak sesuai
    Given Klik button date
    When Pilih start date yang tidak sesuai2
    And Pilih end date yang sesuai2
    And klik button save date
    Then Klik button search