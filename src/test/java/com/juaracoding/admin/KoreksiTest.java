package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.KoreksiPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class KoreksiTest {
    private static WebDriver driver;
    private ExtentTest extentTest;
   private static KoreksiPage koreksiPage = new KoreksiPage();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    ArrayList<String> tab;




    public KoreksiTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik button menu koreksi")
    public void klik_button_menu_koreksi(){
        koreksiPage.setSubMenuKoreksi();
        Utils.delay(2);
    }

    @And("Masukkan nama yang sesuai {string}")
    public void masukkan_nama_yang_sesuai(String nama){
        koreksiPage.setInputSearch(nama);
    }

    @And("Pilih start date yang sesuai {string}")
    public void pilih_start_date_yang_sesuai(String startdate){
        koreksiPage.setInputStartDate(startdate);
        Utils.delay(2);
    }

    @And("Pilih end date yang sesuai {string}")
    public void pilih_end_date_yang_sesuai(String enddate){
        koreksiPage.setInputEndDate(enddate);
    }

    @Then("Verifikasi terdapat data dengan nama dan tanggal yang sesuai")
    public void verifikasi_terdapat_data_dengan_nama_dan_tanggal_yang_sesuai(){
        Assert.assertEquals(koreksiPage.getTxt08Nov(),"08 Nov 2024");
        Assert.assertEquals(koreksiPage.getTxtUserQA(),"UserQA");
    }

    @Given("Masukkan nama yang valid")
    public void masukkan_nama_yang_valid(){
        koreksiPage.setInputSearch("Indra Gunawan");
        js.executeScript("window.scrollBy(-700,0)");
    }

    @And("Klik icon approval")
    public void klik_icon_approval(){
        Utils.delay(2);
        koreksiPage.setBtnApproval();
    }

    @And("Klik button setujui")
    public void klik_button_setujui(){
        koreksiPage.setBtnSetuju();
    }

    @Then("Verifikasi status karyawan")
    public void verifikasi_status_karyawan(){
        Assert.assertEquals(koreksiPage.getTxtApproved(),"APPROVED");
    }

    @Given("Masukkan nama yang valid {string}")
    public void masukkan_nama_yang_valid_(String nama) {
        koreksiPage.setInputSearch(nama);

    }

    @And("Klik button reject")
    public void klik_button_reject(){
        js.executeScript("window.scrollBy(-700,0)");
        Utils.delay(3);
        koreksiPage.setBtnReject();
    }

    @And("Masukkan Alasan reject")
    public void masukkan_alasan_reject(){
        koreksiPage.setInputAlasan("Data yang dikoreksi salah");
    }

    @And("Klik button tolak")
    public void klik_button_tolak(){
        koreksiPage.setBtnTolak();
        Utils.delay(2);
    }

    @Then("Verifikasi Status karyawan reject")
    public void verifikasi_status_karyawan_reject(){
            Assert.assertEquals(koreksiPage.getTxtReject(),"REJECT");
    }





}

