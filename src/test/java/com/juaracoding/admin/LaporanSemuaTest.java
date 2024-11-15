package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.LaporanSemuaPage;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LaporanSemuaTest {

    private  static WebDriver driver;

    private static ExtentTest extentTest;

    private static LoginPage loginPage = new LoginPage();

    private static LaporanSemuaPage laporanSemuaPage = new LaporanSemuaPage();

    public LaporanSemuaTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am logged in to the website with email {string} and password {string}")
    public void i_am_logged_in_to_the_website_with_email_password(String email, String password){
        Utils.delay(3);
        driver.get(Constants.ADMIN_URL);
        loginPage.loginUser(email, password);
        Utils.delay(3);
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I am logged in to the website with email "+email+" and password "+password);
    }

    @And("I headed to the report all page")
    public void i_headed_to_the_report_all_page(){
        laporanSemuaPage.setLaporanMenuBar();
        laporanSemuaPage.setLaporanSemuaList();
        Utils.delay(3);
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        extentTest.log(LogStatus.PASS, "I headed to the report all page");
    }

    @When("I add name {string}")
    public void i_add_name(String name){
        laporanSemuaPage.setInputSearch(name);
        Utils.delay(3);
        extentTest.log(LogStatus.PASS, "i add name "+name);
    }

    @And("I add departement {string}")
    public void i_add_departement(String departemen){
        laporanSemuaPage.setBtnFilterBy();
        laporanSemuaPage.setInputUnit(departemen);
        laporanSemuaPage.setBtnTerapkan();
        extentTest.log(LogStatus.PASS, "I add departement " +departemen);
    }

    @And("I add start date {string}")
    public void i_add_start_date(String startDate){
        laporanSemuaPage.setBtnDatePicker();
        laporanSemuaPage.setInputStartDate(startDate);
        extentTest.log(LogStatus.PASS, "i add start date " + startDate);
    }

    @And("I add end date {string}")
    public void i_add_end_date(String endDate){
        laporanSemuaPage.setInputEndDate(endDate);
        laporanSemuaPage.setBtnDatePickerSave();
        extentTest.log(LogStatus.PASS, "I add end date "+endDate);
    }

    @And("I click the search button")
    public void i_click_the_search_button(){
        laporanSemuaPage.setBtnSearch();
        extentTest.log(LogStatus.PASS, "I click the search button");
    }

    @Then("I view all report data by entering name, department, date")
    public void i_view_all_report_data_by_entering_name_department_date(){
        Utils.delay(3);
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(laporanSemuaPage.getTxtTabelNameKaryawan(), "NAMA KARYAWAN");
        Assert.assertEquals(laporanSemuaPage.getTxtNamaKaryawan(), "testerjuara");
        extentTest.log(LogStatus.PASS, "I view all report data by entering name, departement, date");
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button(){
        laporanSemuaPage.setBtnSearch();
    }

    @Then("I view all report data by not enter name, department, date")
    public void i_view_all_report_data_by_not_enter_name_department_date(){
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(laporanSemuaPage.getTxtTabelNameKaryawan(), "NAMA KARYAWAN");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/laporan/all");
    }

    @When("I added an unregistered name {string}")
    public void i_added_an_unregistered_name(String name) {
        laporanSemuaPage.setInputSearch(name);
        Utils.delay(3);
        extentTest.log(LogStatus.PASS, "i added an unregistered name " + name);
    }

    @Then("I view all report data by entering name")
    public void i_view_all_report_data_by_entering_name(){
        Utils.delay(3);
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/laporan/all?fullname=naruto");
        extentTest.log(LogStatus.PASS, "I view all report data by entering name");
    }

    @When("I input start date {string} and end date {string}")
    public void i_input_start_date_and_end_date(String startDate, String endDate){
        Utils.delay(3);
        laporanSemuaPage.setBtnDatePicker();
        laporanSemuaPage.setInputStartDate(startDate);
        laporanSemuaPage.setInputEndDate(endDate);
        extentTest.log(LogStatus.PASS, "I input start date "+startDate+" and end date "+endDate);
    }

    @And("I click button save and search")
    public void i_click_button_save_and_search(){
        laporanSemuaPage.setBtnDatePickerSave();
        laporanSemuaPage.setBtnSearch();
        extentTest.log(LogStatus.PASS, "I click button save and search");
    }

    @Then("I view all report data by entering the start date and end date")
    public void i_view_all_report_data_by_entering_the_start_date_and_end_date(){
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(laporanSemuaPage.getTxtNamaKaryawan(), "testerjuara");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/laporan/all?start_date=2024-11-08&end_date=2024-11-11");
        extentTest.log(LogStatus.PASS, "I view all report data by entering the start date and end date");
    }

    @Then("I Display all report data by entering a start date without an end date")
    public void display_all_report_data_by_entering_a_start_date_without_an_end_date(){
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(laporanSemuaPage.getTxtNamaKaryawan(), "testerjuara");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/laporan/all?start_date=2024-11-08&end_date=2024-11-08");
        extentTest.log(LogStatus.PASS, "I Display all report data by entering a start date without an end date");
    }

    @And("I click button datepicker")
    public void i_click_button_date_picker(){
        laporanSemuaPage.setBtnDatePicker();
        laporanSemuaPage.setInputDateClear();
        extentTest.log(LogStatus.PASS, "I click button datepicker");
    }

    @Then("Display all report data by entering end date without start date")
    public void display_all_report_data_by_entering_end_date_without_start_date(){
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(laporanSemuaPage.getTxtNamaKaryawan(), "testerjuara");
        extentTest.log(LogStatus.PASS, "Display all report data by entering end date without start date");
    }

    @Then("Displays report data all with department and date input")
    public void displays_report_data_all_with_department_and_date_input(){
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(laporanSemuaPage.getTxtNamaKaryawan(), "testerjuara");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/laporan/all?job_departement_id=72aafd87-9909-49bc-9e7c-5e6d52f1f437&start_date=2024-11-08&end_date=2024-11-11");
        extentTest.log(LogStatus.PASS, "Displays report data all with department and date input");
    }

    @And("I add end date {string} and not save")
    public void i_add_end_date_and_not_save(String endDate){
        laporanSemuaPage.setInputEndDate(endDate);
        extentTest.log(LogStatus.PASS, "I add end date "+endDate+"and not save");
    }

    @Then("I see a warning emblem")
    public void i_see_a_warning_emblem(){
        Assert.assertEquals(laporanSemuaPage.getTxtWarningDate(),"⚠");
        extentTest.log(LogStatus.PASS, "I see a warning emblem");
    }

    @And("I click the reset button")
    public void i_click_the_reset_button(){
        laporanSemuaPage.setBtnReset();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I click the reset button");
    }

    @Then("I see the All Reports page")
    public void i_see_the_all_reports_page(){
        Assert.assertEquals(laporanSemuaPage.getTxtSemua(), "Semua");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magang.dikahadir.com/laporan/all");
        extentTest.log(LogStatus.PASS, "I see the All Reports page");
    }
}
