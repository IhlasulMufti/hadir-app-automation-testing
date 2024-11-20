package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.LemburPage;
import com.juaracoding.pages.admin.SakitPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jshell.execution.Util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;

public class LemburTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static SakitPage sakitPage = new SakitPage();
    private static LemburPage lemburPage = new LemburPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    ArrayList<String> tab;




    public LemburTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Klik button menu laporan")
    public void klik_button_menu_laporan(){
        lemburPage.setMenuLaporan();
        extentTest.log(LogStatus.PASS,"Klik button menu laporan");
    }
    @When("Klik button menu lembur")
    public void klik_button_menu_lembur(){
        lemburPage.setSubMenuLembur();
        extentTest.log(LogStatus.PASS,"Klik button menu lembur");
    }
    @And("Masukkan nama invalid {string}")
    public void masukkan_nama_invalid(String nama){
        Utils.delay(2);
        lemburPage.setInputSearchInvalid(nama);
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Masukkan nama invalid {string}");
    }
    @And("Masukkan departement invalid {string}")
    public void masukkan_departement_invalid(String departement){
        lemburPage.setInputFilterInvalid(departement);
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Masukkan departement invalid {string}");
    }
    @And("Masukkan start date invalid {string}")
    public void masukkan_start_date_invalid(String startdate){
        lemburPage.setInputStartDate(startdate);
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Masukkan start date invalid {string}");
    }
    @And("Masukkan end date invalid {string}")
    public void masukkan_end_date_invalid(String enddate){
        lemburPage.setInputEndDate(enddate);
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Masukkan end date invalid {string}");
    }

    @Then("Verifikasi tidak terdapat data record lembur")
    public void verifikasi_tidak_terdapat_data_record_lembur(){
        Assert.assertEquals(lemburPage.getTxtDataEmpty(),"0-0 of 0");
        extentTest.log(LogStatus.PASS,"Verifikasi tidak terdapat data record lembur");
    }

    @Given("Masukkan nama valid {string}")
    public void masukkan_nama_valid(String nama){
        lemburPage.setInputSearchValid(nama);
        extentTest.log(LogStatus.PASS,"Masukkan nama valid {string}");
    }

    @When("Masukkan departement valid {string}")
    public void masukkan_departement_valid(String departement){
        lemburPage.setInputFiltervalid(departement);
        extentTest.log(LogStatus.PASS,"\"Masukkan departement valid {string}");
    }

    @Given("Klik button export")
    public void klik_button_export(){
        lemburPage.setBtnExport();
        Utils.delay(3);
        extentTest.log(LogStatus.PASS,"Klik button export");
    }
    @Then("peringatan Harap isi tanggal terlebih dahulu")
    public void peringatan_harap_isi_tanggal_terlebih_dahulu(){
        Assert.assertEquals(lemburPage.getTxtAlertExport(),"Harap isi tanggal terlebih dahulu");
        Utils.delay(3);
        extentTest.log(LogStatus.PASS,"peringatan Harap isi tanggal terlebih dahulu");
    }

    @Then("Verifikasi terdapat data record lembur")
    public void verifikasi_terdapat_data_record_lembur(){
        js.executeScript("window.scrollBy(0,500)");
        Assert.assertTrue(lemburPage.getTxtJmlDataRow().contains(lemburPage.getTxtUnitTotal()));
        Utils.delay(2);
        js.executeScript("window.scrollBy(0,-500)");
        extentTest.log(LogStatus.PASS,"Verifikasi terdapat data record lembur");
    }

    @Then("Verifikasi terdapat data record lembur menggunakan nama")
    public void verifikasi_terdapat_data_record_lembur_menggunakan_nama(){
        js.executeScript("window.scrollBy(0,500)");
        Assert.assertTrue(lemburPage.getTxtJmlDataRow().contains(lemburPage.getTxtUnitTotal()));
        Utils.delay(2);
        js.executeScript("window.scrollBy(0,-500)");
        extentTest.log(LogStatus.PASS,"Verifikasi terdapat data record lembur menggunakan nama");
    }

    @Then("Verifikasi record data filter by unit")
    public void verifikasi_record_data_filter_by_unit(){
        Assert.assertTrue(lemburPage.getTxtTabelUnit().contains("UNIT"));
        js.executeScript("window.scrollBy(0,700)");
        Assert.assertTrue(lemburPage.getTxtJmlDataRow().contains(lemburPage.getTxtUnitTotal()));
        Utils.delay(2);
        js.executeScript("window.scrollBy(0,-700)");
        extentTest.log(LogStatus.PASS,"Verifikasi record data filter by unit");

    }

    @And("Klik button view pada OT ATTACHMENT")
    public void klik_button_view_pada_OT_ATTACHMEN(){
        Utils.delay(1);
        lemburPage.setBtnView();
        tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Utils.delay(3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://api-dev.dikahadir.com/uploads/2bb42155389c27277e217f1a72a7e0d5354d74b6724fb3ac9bd72554d0a82f0a.jpeg");
        extentTest.log(LogStatus.PASS,"Klik button view pada OT ATTACHMENT");
    }

    @Then("Verifikasi link image view")
    public void verifikasi_link_image_view(){
        driver.switchTo().window(tab.get(0));
        Utils.delay(2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://magang.dikahadir.com/laporan/overtime?fullname=husain");
        extentTest.log(LogStatus.PASS,"Verifikasi link image view");
    }

    @And("Klik button aksi pada kolom tabel aksi")
    public void klik_button_aksi_pada_kolom_tabel_aksi(){
        lemburPage.setBtnAksi();
        extentTest.log(LogStatus.PASS,"Klik button aksi pada kolom tabel aksi");
    }
    @And("Klik button cancel request")
    public void klik_button_cancel_request(){
        Utils.delay(2);
        lemburPage.setBtnCancelRequest();
        extentTest.log(LogStatus.PASS,"Klik button cancel request");
    }
    @Then("Verifikasi cancel ubah data degan url")
    public void verifikasi_cancel_ubah_data_degan_url(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://magang.dikahadir.com/laporan/overtime?fullname=husain");
        Utils.delay(5);
        driver.navigate().refresh();
        extentTest.log(LogStatus.PASS,"Verifikasi status request");
    }
    @When("Masukkan start date valid {string}")
    public void masukkan_start_date_valid(String startdate){
        lemburPage.setInputStartDate(startdate);
        Utils.delay(3);
        extentTest.log(LogStatus.PASS,"Masukkan start date valid {string}");
    }
    @And("Masukkan end date valid {string}")
    public void masukkanEndDateValid(String enddate) {
        lemburPage.setInputEndDate(enddate);
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Masukkan end date valid {string}");
    }

    @Then("Verifikasi data export lembur")
    public void verifikasi_data_export_lembur(){
        Utils.delay(3);
        try {
            Assert.assertTrue(lemburPage.fileExport());
        } catch (Exception e) {
            System.out.println("File tidak tersedia");
        }

        extentTest.log(LogStatus.PASS,"Verifikasi data export lembur");
    }

    @And("Klik rows per page")
    public void klik_rows_per_page(){
        lemburPage.setBtnRowsPerPage();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Klik rows per page");
    }
    @And("Klik rows number 25")
    public void klik_rows_number_25(){
        lemburPage.setBtnRowsPerPage25();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Klik rows number 25");
    }

    @Then("Verifikasi jumlah rows per page 25")
    public void verifikasi_jumlah_rows_per_page_25(){
        js.executeScript("window.scrollBy(0,700)");
        Assert.assertEquals(lemburPage.getTxtRows(),"1-25 of 61");
        extentTest.log(LogStatus.PASS,"Verifikasi jumlah rows per page 25");

    }
    @And("Klik rows number 10")
    public void klik_rows_number_10(){
        lemburPage.setBtnRowsPerPage10();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Klik rows number 10");
    }
    @Then("Verifikasi jumlah rows per page 10")
    public void verifikasi_jumlah_rows_per_page_10(){
        js.executeScript("window.scrollBy(0,700)");
        Assert.assertEquals(lemburPage.getTxtRows(),"1-10 of 61");
        extentTest.log(LogStatus.PASS,"Verifikasi jumlah rows per page 10");

    }

    @And("Klik rows number 5")
    public void klik_rows_number_5(){
        lemburPage.setBtnRowsPerPage5();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Klik rows number 5");
    }
    @Then("Verifikasi jumlah rows per page 5")
    public void verifikasi_jumlah_rows_per_page_5(){
        js.executeScript("window.scrollBy(0,700)");
        Assert.assertEquals(lemburPage.getTxtRows(),"1-5 of 61");
        extentTest.log(LogStatus.PASS,"Verifikasi jumlah rows per page 5");
    }

}
