Feature: Aturan Cuti Scenario
  Scenario Outline: Add new Aturan Cuti with Valid Data
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Tambahkan Aturan Cuti
    And Admin input Aturan Cuti Name with value "<aturanCutiName>"
    And Admin input Eligible Pengaturan Cuti Bulan with value "<eligiblePengaturanCuti>"
    And Admin select Tanggal Batas Sisa Cuti with value "<tanggalBatasSisaCuti>"
    And Admin select Bulan Batas Sisa Cuti dengan value "<bulanBatasSisaCuti>"
    And Admin input Maksimal Sisa Cuti dengan value "<maksimalSisaCuti>"
    And Admin input Jumlah Bulan Kerja Sisa Cuti dengan value "<jumlahBulanKerjaSisaCuti>"
    And Admin click Tambahkan button
    Then Admin see success message aturan cuti "<successMessage>"

    Examples:
      |aturanCutiName |eligiblePengaturanCuti|tanggalBatasSisaCuti|bulanBatasSisaCuti|maksimalSisaCuti|jumlahBulanKerjaSisaCuti|successMessage|
      |Aturan Cuti November|1               |1                   |12                 |3               |1                       |Sukses Membuat Aturan Cuti|

  Scenario Outline: Search Aturan Cuti
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    Then Admin see "<aturanCutiName>"

    Examples:
      |aturanCutiName|
      |Aturan Cuti November|

  Scenario: Show 5 Data Aturan Cuti per Page and Check Next Page Button
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin scroll down and make sure Aturan Cuti have more than 5 data
    And Admin choose Rows per Page with value 5
    And Admin make sure only show 5 Aturan Cuti
    And Admin click Next Page button
    Then Admin make sure change to next page

  Scenario Outline: Check Reset Button
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click Reset button
    Then Admin make sure search column is empty and show all data

    Examples:
      |aturanCutiName|
      |Aturan Cuti November|

  Scenario Outline: Check Close Button on Tambahkan Aturan Cuti Page
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Tambahkan Aturan Cuti
    And Admin input Aturan Cuti Name with value "<aturanCutiName>"
    And Admin click Tutup button
    And Admin click Tambahkan Aturan Cuti
    Then Admin make sure there is no previous data "<aturanCutiName>"

    Examples:
      |aturanCutiName|
      |Aturan Cuti November|

  Scenario Outline: Edit Aturan Cuti November
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click three dots on the right side and click Edit
    And Admin input Aturan Cuti Name with value "<newAturanCutiName>"
    And Admin click Simpan button
    Then Admin see success message aturan cuti "<successMessage>"

    Examples:
      |aturanCutiName |newAturanCutiName|successMessage|
      |Aturan Cuti November|Aturan Cuti Desember|Sukses Mengubah Aturan Cuti|

  Scenario Outline: View and Add Detail Aturan Cuti Desember
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click three dots on the right side and click View
    And Admin click Tambahkan Detail Aturan Cuti
    And Admin input Minimal Bulan Bekerja with value "<minimalBulanBekerja>"
    And Admin input Total Cuti with value "<totalCuti>"
    And Admin click Tambahkan button
    Then Admin see success message aturan cuti "<successMessage>"

    Examples:
      |aturanCutiName |minimalBulanBekerja|totalCuti|successMessage|
      |Aturan Cuti Desember|1             |10       |Sukses Membuat Detail Aturan Cuti|

  Scenario Outline: Edit Detail Aturan Cuti Desember
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click three dots on the right side and click View
    And Admin click three dots on the right side and click Edit for Detail
    And Admin input Minimal Bulan Bekerja with value "<minimalBulanBekerja>"
    And Admin input Total Cuti with value "<totalCuti>"
    And Admin click Simpan button
    Then Admin see success message aturan cuti "<successMessage>"

    Examples:
      |aturanCutiName |minimalBulanBekerja|totalCuti|successMessage|
      |Aturan Cuti Desember|3             |12       |Sukses Mengubah Detail Aturan Cuti|

  Scenario Outline: Delete Detail Aturan Cuti Desember
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click three dots on the right side and click View
    And Admin click three dots on the right side and click Delete for Detail
    And Admin click Hapus button
    Then Admin see success message aturan cuti "<successMessage>"

    Examples:
      |aturanCutiName |successMessage|
      |Aturan Cuti Desember|Berhasil Menghapus Detail Aturan Cuti|

  Scenario Outline: Invalid Form Aturan Cuti Scenario
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Tambahkan Aturan Cuti
    And Admin input Aturan Cuti Name with value "<aturanCutiName>"
    And Admin input Eligible Pengaturan Cuti Bulan with value "<eligiblePengaturanCuti>"
    And Admin select Tanggal Batas Sisa Cuti with value "<tanggalBatasSisaCuti>"
    And Admin select Bulan Batas Sisa Cuti dengan value "<bulanBatasSisaCuti>"
    And Admin input Maksimal Sisa Cuti dengan value "<maksimalSisaCuti>"
    And Admin input Jumlah Bulan Kerja Sisa Cuti dengan value "<jumlahBulanKerjaSisaCuti>"
    And Admin click Tambahkan button
    Then Admin see error message form Aturan Cuti "<errorAturanCutiMessage>"

    Examples:
      |aturanCutiName |eligiblePengaturanCuti|tanggalBatasSisaCuti|bulanBatasSisaCuti|maksimalSisaCuti|jumlahBulanKerjaSisaCuti|errorAturanCutiMessage|
      | |1               |1                   |1                 |1               |1                       |Nama aturan cuti harus diisi!|
      |Aturan Cuti Test Negative|1               |                   |1                 |1               |1                       |Tanggal batas sisa cuti harus diisi!|
      |Aturan Cuti Test Negative|1               |1                   |                 |1               |1                       |Bulan Batas Sisa Cuti harus diisi!|

  Scenario Outline: Invalid Submit Aturan Cuti Scenario
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Tambahkan Aturan Cuti
    And Admin input Aturan Cuti Name with value "<aturanCutiName>"
    And Admin input Eligible Pengaturan Cuti Bulan with value "<eligiblePengaturanCuti>"
    And Admin select Tanggal Batas Sisa Cuti with value "<tanggalBatasSisaCuti>"
    And Admin select Bulan Batas Sisa Cuti dengan value "<bulanBatasSisaCuti>"
    And Admin input Maksimal Sisa Cuti dengan value "<maksimalSisaCuti>"
    And Admin input Jumlah Bulan Kerja Sisa Cuti dengan value "<jumlahBulanKerjaSisaCuti>"
    And Admin click Tambahkan button
    Then Admin see error message Aturan Cuti "<errorAturanCutiMessage>"

    Examples:
      |aturanCutiName |eligiblePengaturanCuti|tanggalBatasSisaCuti|bulanBatasSisaCuti|maksimalSisaCuti|jumlahBulanKerjaSisaCuti|errorAturanCutiMessage|
      |Aturan Cuti Test Negative|-1               |1                   |1                 |1               |1                       |must be greater than or equal to 0|
      |Aturan Cuti Test Negative|1               |1                   |1                 |-1               |1                       |must be greater than or equal to 0|
      |Aturan Cuti Test Negative|1               |1                   |1                 |1               |-1                       |must be greater than or equal to 0|
      |aaadihadapi semakin besar seiring dengan pesatnya perkembangan teknologi yang menuntut inovasi, adaptasi, dan ketahanan dari individu maupun organisasi, tetap ada keyakinan bahwa kreativitas dan kolaborasi manusia akan mengatasi hambatan-hambatan tersebut.|1               |1                   |1                 |1               |1                       |Data too long for column 'name' at row 1|
      |Aturan Cuti Desember|1               |1                   |12                 |3               |1                       |Redundant Aturan Cuti|

  Scenario Outline: Invalid Detail Aturan Cuti Desember
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click three dots on the right side and click View
    And Admin click Tambahkan Detail Aturan Cuti
    And Admin input Minimal Bulan Bekerja with value "<minimalBulanBekerja>"
    And Admin input Total Cuti with value "<totalCuti>"
    And Admin click Tambahkan button
    Then Admin see error message Detail Aturan Cuti "<errorDetailAturanCutiMessage>"

    Examples:
      |aturanCutiName |minimalBulanBekerja|totalCuti|errorDetailAturanCutiMessage|
      |Aturan Cuti Desember|             |1       |Jumlah minimal bulan kerja harus diisi, minimal 0|
      |Aturan Cuti Desember|1             |       |Jumlah Total Cuti harus diisi, minimal 0|
      |Aturan Cuti Desember|-1             |1       |total_month_greater must be greater than or equal to 0|
      |Aturan Cuti Desember|1             |-1       |total_leave must be greater than or equal to 0|

  Scenario Outline: Delete Aturan Cuti Desember
    Given Admin click dropdwon menu Management
    When Admin clik sub menu Aturan Cuti
    And Admin click Search column
    And Admin input "<aturanCutiName>"
    And Admin click Search button
    And Admin click three dots on the right side and click Delete
    And Admin click Hapus button
    Then Admin see success message aturan cuti "<successMessage>"

    Examples:
      |aturanCutiName |successMessage|
      |Aturan Cuti Desember|Berhasil Menghapus Aturan Cuti|