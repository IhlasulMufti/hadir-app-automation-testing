package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.AturanCutiPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AturanCutiTest {
    private static WebDriver driver;
    private static AturanCutiPage aturanCutiPage;
    private static ExtentTest extentTest;
    private static String fileName;
    private String minimalBulanBekerja,totalCuti;

    public AturanCutiTest(){
        aturanCutiPage = new AturanCutiPage();
        this.driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Admin click dropdwon menu Management")
    public void admin_click_management_menu(){driver.get("https://magang.dikahadir.com/authentication/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@hadir.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin@hadir");
        //Utils.delay(5);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        aturanCutiPage.clickManagamentMenu();
        extentTest.log(LogStatus.PASS,"Admin click dropdwon menu Management");
    }
    @When("Admin clik sub menu Aturan Cuti")
    public void admin_click_aturan_cuti(){
        aturanCutiPage.clickAturanCutiMenu();
        extentTest.log(LogStatus.PASS,"Admin clik sub menu Aturan Cuti");
    }
    @And("Admin click Tambahkan Aturan Cuti")
    public void admin_click_tambahka_aturan_cuti(){
        aturanCutiPage.clickTambahAturanCutiBtn();
        extentTest.log(LogStatus.PASS,"Admin click Tambahkan Aturan Cuti");
    }
    @And("Admin input Aturan Cuti Name with value {string}")
    public void admin_input_aturan_cuti_name(String aturanCutiName){
        aturanCutiPage.setNamaAturanCuti(aturanCutiName);
        extentTest.log(LogStatus.PASS,"Admin input Aturan Cuti Name with value "+aturanCutiName);
    }
    @And("Admin input Eligible Pengaturan Cuti Bulan with value {string}")
    public void admin_input_eligible_pengaturan_cuti(String eligiblePengaturanCuti){
        aturanCutiPage.setEligibleAturanCuti(eligiblePengaturanCuti);
        extentTest.log(LogStatus.PASS,"Admin input Eligible Pengaturan Cuti Bulan with value "+eligiblePengaturanCuti);
    }
    @And("Admin select Tanggal Batas Sisa Cuti with value {string}")
    public void admin_select_tanggal_batas_sisa_cuti(String tanggalBatasSisaCuti){
        aturanCutiPage.setTanggalBatasSisaCuti(tanggalBatasSisaCuti);
        extentTest.log(LogStatus.PASS,"Admin select Tanggal Batas Sisa Cuti with value "+tanggalBatasSisaCuti);
    }
    @And("Admin select Bulan Batas Sisa Cuti dengan value {string}")
    public void admin_select_bulan_batas_sisa_cuti(String bulanBatasSisaCuti){
        aturanCutiPage.setBulanBatasSisaCuti(bulanBatasSisaCuti);
        extentTest.log(LogStatus.PASS,"Admin select Bulan Batas Sisa Cuti dengan value "+bulanBatasSisaCuti);
    }
    @And("Admin input Maksimal Sisa Cuti dengan value {string}")
    public void admin_select_maksimal_sisa_cuti(String maksimalSisaCuti){
        aturanCutiPage.setMaksimalSisaCuti(maksimalSisaCuti);
        extentTest.log(LogStatus.PASS,"Admin input Maksimal Sisa Cuti dengan value "+maksimalSisaCuti);
    }
    @And("Admin input Jumlah Bulan Kerja Sisa Cuti dengan value {string}")
    public void admin_input_jumlah_bulan_kerja_sisa_cuti(String jumlahBulanKerjaSisaCuti){
        aturanCutiPage.setJumlahBulanKerjaSisaCuti(jumlahBulanKerjaSisaCuti);
        extentTest.log(LogStatus.PASS,"Admin input Jumlah Bulan Kerja Sisa Cuti dengan value "+jumlahBulanKerjaSisaCuti);
    }
    @And("Admin click Tambahkan button")
    public void admin_click_button_tambahkan(){
        //Utils.delay(5);
        aturanCutiPage.clickTambahkanBtn();
        extentTest.log(LogStatus.PASS,"Admin click Tambahkan button");
    }
    @Then("Admin see success message aturan cuti {string}")
    public void admin_see_success_message(String successMessage){
        //Utils.delay(2);
        Assert.assertEquals(aturanCutiPage.getActionMessage(),successMessage);
        extentTest.log(LogStatus.PASS,"Admin see success message aturan cuti "+successMessage);
    }
    @And("Admin click Search column")
    public void admin_click_search_column(){
        aturanCutiPage.clickSearchColumn();
        extentTest.log(LogStatus.PASS,"Admin click Search column");
    }
    @And("Admin input {string}")
    public void admin_serach_aturan_cuti_name(String aturanCutiName){
        aturanCutiPage.searchValue(aturanCutiName);
        extentTest.log(LogStatus.PASS,"Admin input "+aturanCutiName);
    }
    @And("Admin click Search button")
    public void admin_click_search_button(){
        aturanCutiPage.clickSearchBtn();
        extentTest.log(LogStatus.PASS,"Admin click Search button");
    }
    @Then("Admin see {string}")
    public void admin_see_aturan_cuti(String aturanCutiName){
        //Utils.delay(3);
        Assert.assertTrue(aturanCutiPage.getAturanCutiData().contains(aturanCutiName));
        extentTest.log(LogStatus.PASS,"Admin see {string}");
    }
    @And("Admin scroll down and make sure Aturan Cuti have more than 5 data")
    public void admin_make_sure_aturan_cuti(){
        Assert.assertTrue(aturanCutiPage.getCountAturanCutiData()>5);
        extentTest.log(LogStatus.PASS,"Admin scroll down and make sure Aturan Cuti have more than 5 data");
    }
    @And("Admin choose Rows per Page with value 5")
    public void admin_choose_rows_five(){
        Utils.delay(3);
        aturanCutiPage.clickRowsPerPage();
        Utils.delay(3);
        aturanCutiPage.rowsPerPage("5");
        extentTest.log(LogStatus.PASS,"Admin choose Rows per Page with value 5");
    }
    @And("Admin make sure only show 5 Aturan Cuti")
    public void admin_make_sure_only_show_five_aturan_cuti(){
        Assert.assertEquals(aturanCutiPage.getCountAturanCutiData(),5);
        extentTest.log(LogStatus.PASS,"Admin make sure only show 5 Aturan Cuti");
    }
    @And("Admin click Next Page button")
    public void admin_click_next_page_button(){
        aturanCutiPage.clickGoToNextPage();
        extentTest.log(LogStatus.PASS,"Admin click Next Page button");
    }
    @Then("Admin make sure change to next page")
    public void admin_make_sure_change_to_next_page(){
        Assert.assertTrue(driver.getCurrentUrl().contains("page=2"));
        extentTest.log(LogStatus.PASS,"Admin make sure change to next page");
    }
    @And("Admin click Reset button")
    public void admin_click_reset_button(){
        aturanCutiPage.clickResetBtn();
        extentTest.log(LogStatus.PASS,"Admin click Reset button");
    }
    @Then("Admin make sure search column is empty and show all data")
    public void admin_make_sure_search_column_is_empty(){
        Assert.assertEquals(aturanCutiPage.getSearchColumnValue(),"");
        extentTest.log(LogStatus.PASS,"Admin make sure search column is empty and show all data");
    }
    @And("Admin click Tutup button")
    public void admin_click_tutup_button(){
        aturanCutiPage.clickTutupBtn();
        extentTest.log(LogStatus.PASS,"Admin click Tutup button");
    }
    @Then("Admin make sure there is no previous data {string}")
    public void admin_make_sure_form_is_empty(String aturanCutiName){
        Assert.assertNotEquals(aturanCutiPage.getNameAturanCuti(),aturanCutiName);
        extentTest.log(LogStatus.PASS,"Admin make sure there is no previous data {string}");
    }
    @And("Admin click three dots on the right side and click Edit")
    public void admin_click_edit_button(){
        aturanCutiPage.clickMoreAction();
        aturanCutiPage.clickEditActionAturanCuti();
        extentTest.log(LogStatus.PASS,"Admin click three dots on the right side and click Edit");
    }
    @And("Admin click Simpan button")
    public void admin_click_simpan_button(){
        //Utils.delay(5);
        aturanCutiPage.clickSimpanBtn();
        extentTest.log(LogStatus.PASS,"Admin click Simpan button");
    }
    @Then("Admin see error message form Aturan Cuti {string}")
    public void admin_see_error_message_form_aturan_cuti(String errorMessage){
        Assert.assertEquals(aturanCutiPage.getFormMessage(),errorMessage);
        extentTest.log(LogStatus.PASS,"Admin see error message form Aturan Cuti "+errorMessage);
    }
    @Then("Admin see error message Aturan Cuti {string}")
    public void admin_see_error_message_aturan_cuti(String errorMessage){
        Assert.assertEquals(aturanCutiPage.getActionMessage(),errorMessage);
        extentTest.log(LogStatus.PASS,"Admin see error message Aturan Cuti "+errorMessage);
    }
    @Then("Admin see error message Detail Aturan Cuti {string}")
    public void admin_see_error_message_detail_aturan_cuti(String errorMessage){
        if(minimalBulanBekerja.isBlank()||Integer.parseInt(minimalBulanBekerja)<0){
            Assert.assertEquals(aturanCutiPage.getMinimalBulanBekerjaErrorMessage(),errorMessage);
        }
        if(totalCuti.isBlank()||Integer.parseInt(totalCuti)<0){
            Assert.assertEquals(aturanCutiPage.getTotalCutiErrorMessage(),errorMessage);
        }
        //Assert.assertEquals(aturanCutiPage.getFormMessage(),errorMessage);
        extentTest.log(LogStatus.PASS,"Admin see error message Detail Aturan Cuti "+errorMessage);
    }
    @And("Admin click three dots on the right side and click View")
    public void admin_click_view_button(){
        aturanCutiPage.clickMoreAction();
        aturanCutiPage.clickViewActionAturanCuti();
        extentTest.log(LogStatus.PASS,"Admin click three dots on the right side and click View");
    }
    @And("Admin click Tambahkan Detail Aturan Cuti")
    public void admin_click_tambahkan_detail_aturan_cuti(){
        aturanCutiPage.clickTambahkanDetailAturanCuti();
        extentTest.log(LogStatus.PASS,"Admin click Tambahkan Detail Aturan Cuti");
    }
    @And("Admin input Minimal Bulan Bekerja with value {string}")
    public void admin_input_minimal_bulan_bekerja(String minimalBulanBekerja){
        this.minimalBulanBekerja=minimalBulanBekerja;
        aturanCutiPage.setMinimalBulanBekerja(minimalBulanBekerja);
        extentTest.log(LogStatus.PASS,"Admin input Minimal Bulan Bekerja with value "+minimalBulanBekerja);
    }
    @And("Admin input Total Cuti with value {string}")
    public void admin_input_total_cuti(String totalCuti){
        this.totalCuti=totalCuti;
        aturanCutiPage.setTotalCuti(totalCuti);
        extentTest.log(LogStatus.PASS,"Admin input Total Cuti with value "+totalCuti);
    }
    @And("Admin click three dots on the right side and click Edit for Detail")
    public void admin_click_view_then_edit_detail(){
        Utils.delay(10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        aturanCutiPage.waitTableData();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector(\"div[class$='MuiTableContainer-root css-1dfrqi4']\").scrollLeft=300");
        aturanCutiPage.clickMoreAction();
        //Utils.delay(10);
        aturanCutiPage.clickEditActionDetailAturanCuti();
        extentTest.log(LogStatus.PASS,"Admin click three dots on the right side and click Edit for Detail");
    }
    @And("Admin click three dots on the right side and click Delete for Detail")
    public void admin_click_view_then_delete_detail(){
        Utils.delay(10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        aturanCutiPage.waitTableData();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector(\"div[class$='MuiTableContainer-root css-1dfrqi4']\").scrollLeft=300");
        aturanCutiPage.clickMoreAction();
        //Utils.delay(10);
        aturanCutiPage.clickDeleteActionDetailAturanCuti();
        extentTest.log(LogStatus.PASS,"Admin click three dots on the right side and click Delete for Detail");
    }
    @And("Admin click Hapus button")
    public void admin_click_hapus_button(){
        aturanCutiPage.clickHapusBtn();
        extentTest.log(LogStatus.PASS,"Admin click Hapus button");
    }
    @And("Admin click three dots on the right side and click Delete")
    public void admin_click_action_delete(){
        aturanCutiPage.clickMoreAction();
        aturanCutiPage.clickDeleteActionAturanCuti();
        extentTest.log(LogStatus.PASS,"Admin click three dots on the right side and click Delete");
    }


}
