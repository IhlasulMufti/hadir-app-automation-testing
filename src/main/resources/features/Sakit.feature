Feature: Menu Sakit Negative and Positif

  # ----------- START NEGATIVE TEST ---------------

  Scenario: Menampilkan data laporan Sakit dengan memasukkan nama, departement dan tanggal yang tidak ada
    Given klik button menu laporan
    When klik button menu sakit
    And Masukkan nama yang tidak ada
    And Klik button date
    And Pilih start date yang tidak ada
    And Pilih end date yang tidak ada
    And klik button save date
    And Klik button filter
    And Pilih unit yang tidak ada
    And Klik button Terapkan
    And Klik button search
    Then Verifikasi tidak terdapat data record
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal

  Scenario: Menampilkan data Sakit dengan memilih tanggal start date yang tidak ada
    Given klik button menu sakit
    When Klik button date
    And Pilih start date yang tidak ada
    And Pilih end date yang sesuai
    And klik button save date
    And Klik button search
    Then Verifikasi tidak terdapat data record

    Scenario: Menampilkan data Sakit dengan memilih tanggal end date yang tidak ada
      Given klik button menu sakit
      When Klik button date
      And Pilih start date yang sesuai
      And Pilih end date yang tidak ada
      And klik button save date
      And Klik button search
      Then Verifikasi tidak terdapat data record

    Scenario: Menampilkan data Sakit dengan filter yang sesuai dan nama yang tidak ada
      Given Klik button reset
      When Klik button filter
      And Pilih unit yang sesuai
      And Klik button Terapkan
      And Masukkan nama yang tidak ada
      And Klik button search
      Then Verifikasi tidak terdapat data record
      And Klik button reset
      And Klik button filter
      And Klik button clear filter
      And Klik button batal

    # ----------- END NEGATIVE TEST -----------


    # ----------- START POSITIVE TEST -----------


    Scenario: Menampilkan data Sakit dengan tidak memilih filter departement
      Given Masukkan nama yang sesuai2
      When Klik button date
      And Pilih start date yang sesuai
      And Pilih end date yang sesuai
      And klik button save date
      And Klik button search
      Then Verifikasi terdapat data record
      And Klik button reset

    Scenario: Menampilkan data sakit input nama lalu pilih filter dengan tidak input tanggal Start Date dan tanggal End date yang sesuai
      Given Masukkan nama yang sesuai2
      When Klik button filter
      And Pilih unit yang sesuai
      And Klik button Terapkan
      And Klik button search
      Then Verifikasi terdapat data record
      And Klik button reset
      And Klik button filter
      And Klik button clear filter
      And Klik button batal

    Scenario: Menampilkan data sakit hanya dengan input nama yang sesuai di kolom search
      Given Masukkan nama yang sesuai2
      When Klik button search
      Then Verifikasi terdapat data record
      And Klik button reset

    Scenario: Menampilkan data sakit dengan input nama, input start date dan end date dan piih filter yang sesuai
      Given Masukkan nama yang sesuai2
      When Klik button date
      And Pilih start date yang sesuai
      And Pilih end date yang sesuai
      And klik button save date
      And Klik button filter
      And Pilih unit yang sesuai
      And Klik button Terapkan
      And Klik button search
      Then Verifikasi terdapat data record
      And Klik button reset
      And Klik button filter
      And Klik button clear filter
      And Klik button batal

  Scenario Outline: Menampilkan data unit dengan pilih departement
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    And Klik button search
    Then Kolom unit tidak ditemukan
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement   |
      | AMEX MERCHANT |


  Scenario: Menampilkan Bukti sakit pada kolom foto
    Given Masukkan nama yang sesuai2
    When Klik button search
    And Klik button view
    Then Verifikasi display foto
    And Klik button reset

  Scenario: Mendownload bukti sakit
    Given Masukkan nama yang sesuai2
    When Klik button search
    And Klik button download
    Then Kembali ke tab awal
    And Klik button reset



  Scenario: Menampilkan data sakit dengan next page
    Given Klik button next page
    Then Verifikasi data next page


    # --------------- END POSITIVE TEST -------------