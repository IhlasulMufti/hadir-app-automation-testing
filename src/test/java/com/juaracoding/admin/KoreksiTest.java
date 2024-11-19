package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.KoreksiPage;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class KoreksiTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static KoreksiPage koreksiPage = new KoreksiPage();

    private String expectedStartDate;
    private String expectedEndDate;
    private String expectedName;
    private int totalApprovedBefore;
    private int totalRejectBefore;


    public KoreksiTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Click laporan button")
    public void click_laporan_button() {
        koreksiPage.setLaporanBtn();
        extentTest.log(LogStatus.PASS, "CLick laporan button");
    }

    @When("Click koreksi button")
    public void click_koreksi_button() {
        Utils.delay(2);
        koreksiPage.setKoreksiBtn();
        extentTest.log(LogStatus.PASS, "click koreksi button");
    }

    @When("Select start date {string} and end date {string}")
    public void select_start_date_and_end_date(String startDate, String endDate) {
        expectedStartDate = startDate;
        expectedEndDate = endDate;

        koreksiPage.setStartDateBtn();
        koreksiPage.setDateValid(startDate, endDate);
        extentTest.log(LogStatus.PASS, "Select start date and end date");
    }

    @And("Click save button")
    public void click_save_button() {
        koreksiPage.setSaveBtn();
        extentTest.log(LogStatus.PASS, "CLick save button");
    }


    @And("Click search button")
    public void click_search_button() {
        koreksiPage.setSearchBtn();
        extentTest.log(LogStatus.PASS, "CLick search button");
    }

    @Then("Verify the date displayed same as selected date")
    public void verify_the_date_displayed_same_as_selected_date() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDate startDate = LocalDate.parse(expectedStartDate, inputFormatter);
        LocalDate endDate = LocalDate.parse(expectedEndDate, inputFormatter);

        koreksiPage.getAllDisplayedDates().forEach(date ->
                Assert.assertTrue(!date.isBefore(startDate) && !date.isAfter(endDate),
                        "Tanggal " + date + " tidak dalam rentang yang dipilih."));
        extentTest.log(LogStatus.PASS, "Verify the displayed same as selected date");
    }

    @When ("Input name {string}")
    public void input_name(String name) {
        expectedName = name;
        koreksiPage.setNameValid(name);
        extentTest.log(LogStatus.PASS, "Input name");
    }

    @Then ("Verify the name displayed same as input name")
    public void verify_the_name_displayed_same_as_input_name() {
        List<String> displayedNames = koreksiPage.getAllDisplayedNames();
        displayedNames.forEach(displayedName -> {
            Assert.assertEquals(displayedName.trim(), expectedName.trim(),
                    "Nama yang ditampilkan: " + displayedName + " tidak sesuai dengan nama yang diinputkan.");
        });
        extentTest.log(LogStatus.PASS, "Verify the name displayed same as input name");
    }

    @Then("Verify no data is displayed")
    public void verify_no_data_is_displayed() {
        int rowCount = koreksiPage.getTableRowCount();
        Assert.assertEquals(rowCount, 0, "Tabel menampilkan data padahal seharusnya tidak ada data.");
        extentTest.log(LogStatus.PASS, "Verify no data displayed");
    }

    @When ("Click filter icon")
    public void click_filter_icon() {
        koreksiPage.setFilterBtn();
        extentTest.log(LogStatus.PASS, "Click filter icon");
    }

    @When ("Click search department")
    public void click_search_department() {
        koreksiPage.clickSearchDepartment();
        extentTest.log(LogStatus.PASS, "Click search department");
    }

    @And ("Input Unit name")
    public void input_unit_name() {
        koreksiPage.setSearchDepartment("Amex");
        extentTest.log(LogStatus.PASS, "Input unit name");
    }

    @And("Click terapkan button")
    public void click_terapkan_button() {
        koreksiPage.setTerapkanBtn();
        extentTest.log(LogStatus.PASS, "Click terapkan button");
    }

    @Then("Verify {string} is displayed")
    public void verify_unit_is_displayed(String UNIT) {
        Assert.assertEquals(koreksiPage.setVerifyUnit(), UNIT, "UNIT Not Found!");
        extentTest.log(LogStatus.PASS, "Verify unit is displayed");
    }

    @Then("Verify terapkan button is not clickable")
    public void verify_terapkan_button_is_not_clickable() {
        Assert.assertTrue(koreksiPage.isButtonDisabled(), "Verify terapkan button is not clickable");
    }

    @And("Click approved button")
    public void click_approved_button() {
        totalApprovedBefore = koreksiPage.setVerifyApproval();
        koreksiPage.setApprovalBtn();
        koreksiPage.setSetujuiBtn();
        extentTest.log(LogStatus.PASS, "Click approved button");
    }

    @Then("Verify approval is success")
    public void verify_approval_is_success() {
        System.out.println(totalApprovedBefore);
        Assert.assertEquals(koreksiPage.setVerifyApproval(), (totalApprovedBefore+1), "Approval failed");
        extentTest.log(LogStatus.PASS, "Verify approval is success");
    }

    @And("Click reject button")
    public void click_reject_button() {
        totalRejectBefore = koreksiPage.setVerifyApproval();
        koreksiPage.setRejectBtn();
        extentTest.log(LogStatus.PASS, "Click reject button");
    }

    @And("Input alasan reject")
    public void input_alasan_reject() {
        koreksiPage.clickInputAlasan();
        koreksiPage.setInputAlasan("Data yang dikoreksi salah");
        koreksiPage.setTolakBtn();
        extentTest.log(LogStatus.PASS, "Input alasan");
    }

    @Then("Verify rejected is success")
    public void verify_rejected_is_success() {
        System.out.println(totalRejectBefore);
        Assert.assertEquals(koreksiPage.setVerifyReject(), (totalRejectBefore+1), "Reject failed");
        extentTest.log(LogStatus.PASS, "Verify rejected is success");
    }

    @And("Change view to 5 rows")
    public void change_view_to_5_rows() {
        koreksiPage.setChangeRows();
        extentTest.log(LogStatus.PASS, "Change view to 5 row");
    }

    @Then("Verify table display 5 rows")
    public void verify_table_display_5_rows() {
        Utils.delay(2);
        int rowCount = koreksiPage.getDisplayedRowCount();
        Assert.assertEquals(rowCount, 5, "Tabel tidak menampilkan 5 row.");
        extentTest.log(LogStatus.PASS, "Verify table display 5 rows");
    }

    @And("Change view to 25 rows")
    public void change_view_to_25_rows() {
        koreksiPage.setChangeRows25();
        extentTest.log(LogStatus.PASS, "Change view to 5 row");
    }

    @Then("Verify table display 25 rows")
    public void verify_table_display_25_rows() {
        Utils.delay(2);
        int rowCount = koreksiPage.getDisplayedRowCount();
        Assert.assertEquals(rowCount, 25, "Tabel tidak menampilkan 25 row.");
        extentTest.log(LogStatus.PASS, "Verify table display 25 rows");
    }

    @And("Click tolak button")
    public void click_tolak_button() {
        koreksiPage.setTolakBtn();
        extentTest.log(LogStatus.PASS, "Click tolak button");
    }

    @Then("Verify rejected is failed")
    public void verify_rejected_is_failed() {
        Assert.assertEquals(koreksiPage.isAlasanRequired(), "true", "Verify rejected is failed because input is required");
        extentTest.log(LogStatus.PASS, "Verify rejected is failed");
    }

}

