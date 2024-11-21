package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.ImportCutiPage;
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

public class ImportCutiTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static ImportCutiPage importCutiPage = new ImportCutiPage();

    public ImportCutiTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Admin login page")
    public void Admin_login_page(){
        driver.get("https://magang.dikahadir.com/authentication/login");
        driver.get(Constants.ADMIN_URL);
        loginPage.loginUser("admin@hadir.com", "admin@hadir");
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "Admin login page");
        Utils.delay(3);
    }

    @When("Admin import menu")
    public void Admin_import_menu(){
        importCutiPage.setBtnMenuImport();
        extentTest.log(LogStatus.PASS, "Admin import menu");
    }

    @And("Admin to go to the import sub menu")
    public void Admin_to_go_to_the_import_sub_menu(){
        importCutiPage.setImportCuti();
        extentTest.log(LogStatus.PASS, "Admin to go to the import sub menu");
    }

    @Then("Admin click the Download Template button")
    public void Admin_click_the_Download_Template_button(){
        importCutiPage.setBtnDownloadTemplate();
        extentTest.log(LogStatus.PASS, "Admin click the Download Template button");
    }

    @Then("Admin click Browser valid file")
    public void Admin_click_Browser_valid_file(){
        importCutiPage.addTemplateCuti("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\Template_Cuti_Hadir.xlsx");
        extentTest.log(LogStatus.PASS, "Admin click Browser valid file");
    }

    @And("Admin click the import button")
    public void Admin_click_the_import_button(){
        importCutiPage.setBtnImport();
        extentTest.log(LogStatus.PASS, "Admin Click the import button");
    }

    @And("The file was import successfully")
    public void The_file_was_import_successfully(){
        Assert.assertEquals(importCutiPage.getTxtPesan(),"Gagal import excel");
        extentTest.log(LogStatus.FAIL,"The file was import successfully");
    }

    @Then("Admin import the file invalid format")
    public void Admin_import_the_file_invalid_format(){
        importCutiPage.addFileFormatInvalidPDF("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\Template_Cuti_Hadir.pdf");
        extentTest.log(LogStatus.PASS, "Admin import the file invalid format");
    }

    @And("Admin should see the error message Invalid file format")
    public void Admin_should_see_the_error_message_Invalid_file_format(){
        Assert.assertEquals(importCutiPage.getTxtPesan(),"Gagal import excel");
        extentTest.log(LogStatus.PASS, "Admin should see the error message Invalid file format");
    }

    @Then("Admin click the Import button without selecting a file")
    public void Admin_click_the_Import_button_without_selecting_a_file(){
        importCutiPage.setBtnImport();
        extentTest.log(LogStatus.PASS, "Admin click the Import button without selecting a file");
        Utils.delay(2);
    }


    @Then("Admin import the file")
    public void Admin_import_the_file(){
        importCutiPage.addFileInvalidTemplate("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\Tidak_Sesuai_Template.xlsx");
        extentTest.log(LogStatus.PASS,"Admin import the file");
    }

    @And("Admin should see the error message Invalid file template")
    public void Admin_should_see_the_error_message_Invalid_file_template(){
        Assert.assertEquals(importCutiPage.getTxtPesan(),"Berhasil import excel");
        extentTest.log(LogStatus.FAIL, "Admin should see the error message Invalid file template");
    }

    @Then("Admin import the file empty")
    public void Admin_import_the_file_empty(){
        importCutiPage.addKosong("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\EMPTY.xlsx");
        extentTest.log(LogStatus.PASS, "Admin import the file empty");
    }

    @And("Admin should see the error message File cannot be empty")
    public void Admin_should_see_the_error_message_File_cannot_be_empty(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://magang.dikahadir.com/imports/import-absen-cuti");
        extentTest.log(LogStatus.FAIL, "Admin should see the error message File cannot be empty");
    }

}