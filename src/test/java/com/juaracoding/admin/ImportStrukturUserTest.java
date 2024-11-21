package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.ImportStrukturUserPage;
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

public class ImportStrukturUserTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static ImportStrukturUserPage importStrukturUserPage = new ImportStrukturUserPage();

    public ImportStrukturUserTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Admin login with email and password")
    public void Admin_login_with_email_and_password(){
        Utils.delay(2);
        driver.get("https://magang.dikahadir.com/authentication/login");
        driver.get(Constants.ADMIN_URL);
        loginPage.loginUser("admin@hadir.com", "admin@hadir");
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "Admin login with email and password");
    }

    @When("Admin navigates to the import menu page Struktur User")
    public void Admin_navigates_to_the_import_menu_page_Struktur_User(){
        importStrukturUserPage.setBtnMenuImportStrukturUser();
        extentTest.log(LogStatus.PASS, "Admin navigates to the import menu page Struktur User");
    }

    @And("Admin navigates to the import sub menu page Struktur User")
    public void Admin_navigates_to_the_import_sub_menu_page_Struktur_User(){
        importStrukturUserPage.setBtnSubMenuImportStrukturUser();
        extentTest.log(LogStatus.PASS, "Admin navigates to the import sub menu page Struktur User");
    }

    @Then("Admin clicked the Download Template Struktur User button and it was successful")
    public void Admin_clicked_the_Download_Template_Struktur_User_button_and_it_was_successful(){
        importStrukturUserPage.setBtnDownloadTemplateStrukturUser();
        extentTest.log(LogStatus.PASS, "Admin clicked the Download Template button and it was successful Struktur User");
    }

    @Then("Click choose valid file Struktur User")
    public void Click_choose_valid_file_StrukturUser(){
        importStrukturUserPage.addFileValid("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER.xlsx");
        extentTest.log(LogStatus.PASS, "Click choose valid file Struktur User");
    }

    @And("Click the import button Struktur User")
    public void I_click_the_import_button_Struktur_User(){
        importStrukturUserPage.setBtnImportStrukturUser();
        extentTest.log(LogStatus.PASS, "Click the import button Struktur User");
    }

    @And("The file was imported successfully Struktur User")
    public void The_file_was_imported_successfully_Struktur_User(){
        Assert.assertEquals(importStrukturUserPage.getTxtValidasi(), "Berhasil import excel");
        extentTest.log(LogStatus.PASS,"The file was imported successfully Struktur User");
    }

    @Then("Click choose invalid file Struktur User")
    public void Click_choose_invalid_file_Struktur_User(){
        importStrukturUserPage.addFileInvalid("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER_INVALID.xlsx");
        extentTest.log(LogStatus.PASS, "Click choose invalid file Struktur User");
    }

    @And("The file failed to import Struktur User")
    public void The_file_failed_to_import_Struktur_User(){
        Assert.assertEquals(importStrukturUserPage.getTxtValidasi(),"Gagal import file karena template tidak sesuai");
        extentTest.log(LogStatus.FAIL, "The file failed to import Struktur User");
    }

    @Then("Click the import button without file Struktur User")
    public void Click_the_import_button_without_file_Struktur_User(){
        importStrukturUserPage.setBtnImportStrukturUser();
        extentTest.log(LogStatus.PASS, "Click the import button without file Struktur User");
    }

    @Then("Click choose invalid format file Struktur User")
    public void Click_choose_invalid_format_file_Struktur_User(){
        importStrukturUserPage.addFileFormatInvalid("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER.pdf");
        extentTest.log(LogStatus.PASS, "Click choose invalid format file Struktur User");
    }

    @And("The format file failed to import Struktur User")
    public void The_format_file_failed_to_import_Struktur_User(){
        Assert.assertEquals(importStrukturUserPage.getTxtValidasi(),"*File harus berupa file Excel (.xls atau .xlsx)");
        extentTest.log(LogStatus.PASS, "The format file failed to import Struktur User");
    }

    @Then("Click choose empty data file Struktur User")
    public void Click_choose_empty_data_file_Struktur_User(){
        importStrukturUserPage.addFileEmptyData("C:\\Juara Coding\\sqa batch 18\\hadir-app\\hadir-app-automation-testing\\src\\main\\resources\\uploadFile\\DATA_STRUKTUR_USER_EMPTY_DATA.xlsx");
        extentTest.log(LogStatus.FAIL, "Click choose empty data file Struktur User");
    }

    @And("The empty data file failed to import Struktur User")
    public void The_empty_data_file_failed_to_import_Struktur_User(){
        Assert.assertEquals(importStrukturUserPage.getTxtValidasi(),"Gagal import file karena Field kosong");
        extentTest.log(LogStatus.FAIL, "The empty data file failed to import Struktur User");
    }
}
