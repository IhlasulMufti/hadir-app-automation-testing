package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.ImportStatusAktifPage;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ImportStatusAktifTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static ImportStatusAktifPage importStatusAktifPage = new ImportStatusAktifPage();

    public ImportStatusAktifTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Admin logged in with email and password")
    public void Admin_logged_in_with_email_and_password(){
        driver.get("https://magang.dikahadir.com/authentication/login");
        driver.get(Constants.ADMIN_URL);
        loginPage.loginUser("admin@hadir.com", "admin@hadir");
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "Admin logged in with email and password");
    }

    @When("Admin navigates to the import menu page")
    public void Admin_navigates_to_the_import_menu_page(){
        importStatusAktifPage.setBtnMenuImportStatusAktif();
        extentTest.log(LogStatus.PASS, "Admin navigates to the import menu page");
    }

    @And("Admin navigates to the import sub menu page")
    public void Admin_navigates_to_the_import_sub_menu_page(){
        importStatusAktifPage.setBtnSubMenuImportStatusAktif();
        extentTest.log(LogStatus.PASS, "Admin navigates to the import sub menu page");
    }

    @Then("Admin clicked the Download Template button and it was successful")
    public void Admin_clicked_the_Download_Template_button_and_it_was_successful(){
        importStatusAktifPage.setBtnDownloadTemplateStatusAktif();
        extentTest.log(LogStatus.PASS, "Admin clicked the Download Template button and it was successful");
    }

    @Then("Click choose valid file")
    public void Click_choose_valid_file(){
        importStatusAktifPage.addFileValid("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER.xlsx");
        extentTest.log(LogStatus.PASS, "Click choose valid file");
    }

    @And("Click the import button")
    public void I_click_the_import_button(){
        importStatusAktifPage.setBtnImportStatusAktif();
        extentTest.log(LogStatus.PASS, "Click the import button");
    }

    @And("The file was imported successfully")
    public void The_file_was_imported_successfully(){
        Assert.assertEquals(importStatusAktifPage.getTxtValidasi(), "Berhasil import excel");
        extentTest.log(LogStatus.PASS,"The file was imported successfully");
    }

    @Then("Click choose invalid file")
    public void Click_choose_invalid_file(){
        importStatusAktifPage.addFileInvalid("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER_INVALID.xlsx");
        extentTest.log(LogStatus.PASS, "Click choose invalid file");
    }

    @And("The file failed to import")
    public void The_file_failed_to_import(){
        Assert.assertEquals(importStatusAktifPage.getTxtValidasi(),"Berhasil import excel");
        extentTest.log(LogStatus.FAIL, "The file failed to import");
    }

    @Then("Click the import button without file")
    public void Click_the_import_button_without_file(){
        importStatusAktifPage.setBtnImportStatusAktif();
        Assert.assertEquals(driver.getCurrentUrl(),"https://magang.dikahadir.com/imports/import-status-aktif");
        extentTest.log(LogStatus.PASS, "Click the import button without file");
    }

    @Then("Click choose invalid format file")
    public void Click_choose_invalid_format_file(){
        importStatusAktifPage.addFileFormatInvalid("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER.pdf");
        extentTest.log(LogStatus.PASS, "Click choose invalid format file");
    }

    @And("The format file failed to import")
    public void The_format_file_failed_to_import(){
        Assert.assertEquals(importStatusAktifPage.getTxtValidasi(),"*File harus berupa file Excel (.xls atau .xlsx)");
        extentTest.log(LogStatus.PASS, "The format file failed to import");
    }

    @Then("Click choose empty data file")
    public void Click_choose_empty_data_file(){
        importStatusAktifPage.addFileEmptyData("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STATUS_USER_EMPTY_DATA.xlsx");
        extentTest.log(LogStatus.FAIL, "Click choose empty data file");
    }

    @And("The empty data file failed to import")
    public void The_empty_data_file_failed_to_import(){
        Assert.assertEquals(importStatusAktifPage.getTxtValidasi(),"Berhasil import excel");
        extentTest.log(LogStatus.FAIL, "The empty data file failed to import");
    }

}