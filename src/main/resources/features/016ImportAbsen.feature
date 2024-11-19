Feature: Import Absen Hadir
  Scenario Outline: Invalid Import File Absen Hadir Scenario
    Given Admin Login and open Import Menu
    When Admin open Import Absen Menu
    And Admin click Choose File "<fileName>"
    And Admin click Import button
    Then Admin see error message "<errorMessage>"
    Examples:
      |fileName|errorMessage|
      |                            |Please select a file.       |
      |OtherThanTemplate.xlsx|Tidak Berhasil Import                                  |
      |InvalidHeader.xlsx    |Tidak Berhasil Import                                  |
      |InvalidNIK.xlsx       |Tidak Berhasil Import                                  |
      |InvalidName.xlsx      |Tidak Berhasil Import                                  |
      |FutureDate.xlsx       |Tidak Berhasil Import                                  |
      |InvalidFormatDate.xlsx|Tidak Berhasil Import                                  |
      |ClockInMoreThanClockOut.xlsx|Tidak Berhasil Import                            |
      |Dummy.pdf|*File harus berupa file Excel (.xls atau .xlsx)|

  Scenario: Download Template Absen Hadir Scenario
    Given Admin Login and open Import Menu
    When Admin open Import Absen Menu
    And Admin click Download Template Button
    Then Template Successfully Downloaded


  Scenario Outline: Valid Import File Absen Hadir Scenario
    Given Admin Login and open Import Menu
    When Admin open Import Absen Menu
    And Admin click Choose File "<fileName>"
    And Admin click Import button
    Then Admin see success message "<successMessage>"
    Examples:
      |fileName|successMessage|
      |DATA_ABSEN_HADIR.xlsx|Berhasil import excel|
