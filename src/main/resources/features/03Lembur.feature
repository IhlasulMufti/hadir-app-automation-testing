Feature: Menu Lembur Negative and Positif Test

   # ----------- START NEGATIVE TEST ---------------

  Scenario Outline: Menampilkan data laporan Lembur dengan memasukkan nama, departement dan tanggal yang tidak sesuai
    Given Klik button menu laporan
    When Klik button menu lembur
    And Masukkan nama invalid "<nama>"
    And Klik button filter
    And Masukkan departement invalid "<departement>"
    And Klik button Terapkan
    And Klik button date
    And Masukkan start date invalid "<startdate>"
    And Masukkan end date invalid "<enddate>"
    And klik button save date
    And Klik button search
    Then Verifikasi tidak terdapat data record lembur
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
#
    Examples:
      | nama    | departement | startdate    | enddate      |
      | invalid | Finance     | Nov 20, 2024 | Nov 21, 2024 |


  Scenario Outline: Menampilkan data Lembur dengan memilih tanggal yang tidak sesuai
    Given Klik button date
    When Masukkan start date invalid "<startdate>"
    And Masukkan end date invalid "<enddate>"
    And klik button save date
    And Klik button search
    Then Verifikasi tidak terdapat data record lembur
    And Klik button reset
    Examples:
        | startdate    | enddate      |
        | Nov 21, 2024 | Nov 24, 2024 |


  Scenario Outline: Menampilkan data Lembur dengan nama sesuai dan memilih tanggal yang tidak sesuai
    Given Masukkan nama valid "<nama>"
    When Klik button date
    And Masukkan start date invalid "<startdate>"
    And Masukkan end date invalid "<enddate>"
    And klik button save date
    And Klik button search
    Then Verifikasi tidak terdapat data record lembur
    And Klik button reset
    Examples:
     | nama   | startdate    | enddate      |
     | kazama | Nov 25, 2024 | Nov 27, 2024 |


  Scenario Outline: Menampilkan data lembur dengan filter yang sesuai dan nama yang tidak sesuai
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    And Masukkan nama invalid "<nama>"
    And Klik button search
    Then Verifikasi tidak terdapat data record lembur
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement   | nama    |
      | IT Programmer | Invalid |

  Scenario: Export data Lembur dengan tidak memasukkan start date dan end date
    Given Klik button export
    Then peringatan Harap isi tanggal terlebih dahulu

        # ------------ END NEGATIVE TEST ----------------


        # ------------ START POSITIF TEST -----------------

  Scenario Outline: Menampilkan data Lembur input nama lalu pilih filter dengan tidak input tanggal Start Date dan tanggal End date yang sesuai
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    And Masukkan nama invalid "<nama>"
    And Klik button search
    Then Verifikasi terdapat data record lembur
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement       | nama |
      | IT Programmer     | kazama |

  Scenario Outline: Menampilkan data Lembur hanya dengan input nama yang sesuai di kolom search
    Given Masukkan nama invalid "<nama>"
    When Klik button search
    Then Verifikasi terdapat data record lembur menggunakan nama
    And Klik button reset
    Examples:
      | nama          |
      | Daffa Zakaria |

  Scenario Outline: Menampilkan data Lembur dengan menggunakan filter By Unit
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    Then Verifikasi record data filter by unit
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement |
      | amex        |

  Scenario Outline: Menampilkan OT ATTACHMENT pada salah satu data
    Given Masukkan nama valid "<nama>"
    When Klik button search
    And Klik button view pada OT ATTACHMENT
    Then Verifikasi link image view
    And Klik button reset
    Examples:
      | nama   |
      | husain |

  Scenario Outline: Cancel ubah atasan user yang request pada kolom aksi di data lembur
    Given Masukkan nama valid "<nama>"
    When Klik button search
    And Klik button aksi pada kolom tabel aksi
    And Klik button cancel request
    Then Verifikasi cancel ubah data degan url
    And Klik button reset
    Examples:
      | nama   |
      | husain |

  Scenario Outline: Menampilkan data lebih banyak dengan rows per page 25
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    And Klik button search
    And Klik rows per page
    And Klik rows number 25
    Then Verifikasi jumlah rows per page 25
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement   |
      | IT Programmer |

  Scenario Outline: Menampilkan data lebih banyak dengan rows per page 10
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    And Klik button search
    And Klik rows per page
    And Klik rows number 10
    Then Verifikasi jumlah rows per page 10
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement   |
      | IT Programmer |

  Scenario Outline: Menampilkan data lebih banyak dengan rows per page 5
    Given Klik button filter
    When Masukkan departement valid "<departement>"
    And Klik button Terapkan
    And Klik button search
    And Klik rows per page
    And Klik rows number 5
    Then Verifikasi jumlah rows per page 5
    And Klik button reset
    And Klik button filter
    And Klik button clear filter
    And Klik button batal
    Examples:
      | departement   |
      | IT Programmer |

  Scenario Outline: Exsport Data lembur dengan mengisi start date dan end date
    Given Klik button date
    When Masukkan start date valid "<startdate>"
    And Masukkan end date valid "<enddate>"
    And klik button save date
    And Klik button search
    And Klik button export
    Then Verifikasi data export lembur
    And Klik button reset
    Examples:
      | startdate     | enddate      |
      | Nov 29, 2024  | Nov 30, 2024 |










