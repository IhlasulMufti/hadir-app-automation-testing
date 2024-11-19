package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.ImportAbsenPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class ImportAbsenTest {

    private static WebDriver driver;
    private static ImportAbsenPage importAbsenPage;
    private static ExtentTest extentTest;
    private static String fileName;

    public ImportAbsenTest(){
        importAbsenPage = new ImportAbsenPage();
        this.driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Admin Login and open Import Menu")
    public void navigate_to_Hadir(){
        driver.get("https://magang.dikahadir.com/authentication/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@hadir.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin@hadir");
        //Utils.delay(5);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Utils.delay(5);
        importAbsenPage.clickTabImportMenu();
        extentTest.log(LogStatus.PASS,"Admin Login and open Import Menu");
    }
    @When("Admin open Import Absen Menu")
    public void admin_open_import_absen_menu(){
        importAbsenPage.clickImportAbsenMenu();
        extentTest.log(LogStatus.PASS,"Admin open Import Absen Menu");
    }
    @And("Admin click Choose File {string}")
    public void admin_click_choose_file(String fileName){
        this.fileName = fileName;
        if (!fileName.isBlank()) {
            importAbsenPage.uploadFile(System.getProperty("user.dir") + "/src/main/resources/UploadFile/" + fileName);
        }
        extentTest.log(LogStatus.PASS,"Admin click Choose File "+fileName);

    }
    @And("Admin click Import button")
    public void admin_click_import_button(){
        importAbsenPage.clickImportBtn();
        extentTest.log(LogStatus.PASS,"Admin click Import button");
    }
    @Then("Admin see error message {string}")
    public void admin_see_error_message(String errorMessage){
        Utils.delay(3);
        String extFile = fileName.substring(fileName.lastIndexOf(".") + 1);
        if(extFile.equals("xls") || extFile.equals("xlsx")){
            Assert.assertEquals(importAbsenPage.getImportFileMessage(),errorMessage);
        }else if(extFile.equals("")){
            Assert.assertEquals("true",driver.findElement(By.xpath("//input[@id='selfie']")).getAttribute("required"));
        }else{
            System.out.println(errorMessage);
            Assert.assertEquals(importAbsenPage.getErrInvalidFormatFile(),errorMessage);
        }
        extentTest.log(LogStatus.PASS,"Admin see error message "+errorMessage);
    }

    @And("Admin click Download Template Button")
    public void Admin_click_Download_Template_Button(){
        importAbsenPage.clickDownloadTemplateBtn();
        Utils.delay(10);
    }

    @Then("Template Successfully Downloaded")
    public void template_successfully_downloaded(){
        String downloadPath = "C:/Users/Halamadrid/Downloads";
        String templateName = "DATA_ABSEN_HADIR";
        Assert.assertTrue(isFileDownloaded(downloadPath,templateName));
    }
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                System.out.println(dirContents[i].getName());
                return true;
            }
        }
        return false;
    }

    @Then("Admin see success message {string}")
    public void admin_see_success_message(String successMessage){
        //Utils.delay(5);
        Assert.assertEquals(importAbsenPage.getImportFileMessage(),successMessage);
        extentTest.log(LogStatus.PASS,"Admin see error message "+successMessage);
    }
}
