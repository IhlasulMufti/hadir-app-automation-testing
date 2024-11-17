package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.LemburPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LemburTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LemburPage lemburPage = new LemburPage();

    public LemburTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Klik button menu laporan")
    public void klik_button_menu_laporan(){
        lemburPage.setMenuLaporan();
    }
    @When("Klik button menu lembur")
    public void klik_button_menu_lembur(){
        lemburPage.setSubMenuLembur();
    }
    @And("Masukkan nama yang tidak sesuai2")
    public void masukkan_nama_yang_tidak_sesuai2(){
        Utils.delay(2);
        lemburPage.setInputSearchInvalid("Elva");
        Utils.delay(1);
    }
    @And("Pilih start date yang tidak sesuai2")
    public void pilih_start_date_yang_tidak_sesuai2(){
        lemburPage.setInputStartDate("Aug 17, 2024");
        Utils.delay(1);
    }
    @And("Pilih end date yang tidak sesuai2")
    public void pilih_end_date_yang_tidak_sesuai2(){
        lemburPage.setInputEndDate("Aug 20, 2024");
        Utils.delay(1);
    }
    @And("Pilih unit yang tidak sesuai2")
    public void pilih_unit_yang_tidak_sesuai2(){
        lemburPage.setInputFilterInvalid("Tiket");
        Utils.delay(2);
    }

    @And("Pilih end date yang sesuai2")
    public void pilih_end_date_yang_sesuai2(){
        Utils.delay(1);
        lemburPage.setInputEndDate("Aug 18,2024");
        Utils.delay(1);
    }

}
