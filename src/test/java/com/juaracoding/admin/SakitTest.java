package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.SakitPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SakitTest {
    private static WebDriver driver;
    private ExtentTest extentTest;
    private static SakitPage sakitNegative01Page = new SakitPage();

    public SakitTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("klik button menu laporan")
    public void klik_button_menu_laporan(){
        Utils.delay(1);
        sakitNegative01Page.setMenuLaporan();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"klik button menu laporan");
    }

    @When("klik button menu sakit")
    public void klik_button_menu_sakit(){
        Utils.delay(1);
        sakitNegative01Page.setSubMenuSakit();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"klik button menu sakit\"");
    }

    @And("Masukkan nama yang tidak ada")
    public void masukkan_nama_yang_tidak_ada(){
        Utils.delay(1);
        sakitNegative01Page.setInputSearchInvalid("Ahmad");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Masukkan nama yang tidak ada");
    }
    @And("Pilih start date yang tidak ada")
    public void pilih_start_date_yang_tidak_ada(){
        Utils.delay(1);
        sakitNegative01Page.setInputStartDate("Jan 12, 2024");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Pilih start date yang tidak ada");
    }
    @And("Pilih end date yang tidak ada")
    public void pilih_end_date_yang_tidak_ada(){
        Utils.delay(1);
        sakitNegative01Page.setInputEndDate("Aug 13, 2024");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Pilih end date yang tidak ada");
    }
    @And("klik button save date")
    public void klik_button_save_date(){
        Utils.delay(1);
        sakitNegative01Page.setBtnSaveDate();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"klik button save date");
    }
    @And("Klik button filter")
    public void klik_button_filter(){
        Utils.delay(1);
        sakitNegative01Page.setBtnFilter();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Klik button filter");
    }
    @And("Pilih unit yang tidak ada")
    public void pilih_unit_yang_tidak_ada(){
        Utils.delay(1);
        sakitNegative01Page.setInputFilterInvalid("BCA");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Pilih unit yang tidak ada");
    }
    @And("Klik button Terapkan")
    public void klik_button_terapkan(){
        sakitNegative01Page.setBtnTerapkan();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Klik button Terapkan");

    }
    @And("Klik button search")
    public void klik_button_search(){
        sakitNegative01Page.setBtnSearch();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Klik button search");
    }
    @And("Klik button reset")
    public void klik_button_reset(){
        sakitNegative01Page.setBtnReset();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Klik button reset");
    }
    @And("Klik button clear filter")
    public void klik_button_clear_filter(){
        sakitNegative01Page.setBtnClearFilter();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Klik button clear filter");
    }
    @And("Klik button batal")
    public void klik_button_batal(){
        sakitNegative01Page.setBtnBatalFilter();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Klik button batal");
    }

    @Then("Verifikasi tidak terdapat data record")
    public void verifikasi_tidak_terdapat_data_record(){
        Assert.assertTrue(sakitNegative01Page.setDataRecordEmpty());
        extentTest.log(LogStatus.PASS,"Verifikasi tidak terdapat data record");
    }

    @When("Klik button date")
    public void Klik_button_date(){
        sakitNegative01Page.setBtnDate();
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Klik button date");
    }

    @And("Pilih end date yang sesuai")
    public void pilih_end_date_yang_sesuai(){
        sakitNegative01Page.setInputEndDate("Apr 05, 2024");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Pilih end date yang sesuai");
    }
    @And("Pilih start date yang sesuai")
    public void pilih_start_date_yang_sesuai(){
        sakitNegative01Page.setInputStartDate("Apr 05, 2024");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Pilih start date yang sesuai");
    }

    @And("Pilih unit yang sesuai")
    public void pilih_unit_yang_sesuai(){
        sakitNegative01Page.setInputFiltervalid("AMEX");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"Pilih unit yang sesuai");
    }
    @Given("Masukkan nama yang sesuai")
    public void masukkan_nama_yang_sesuai(){
        sakitNegative01Page.setInputSearchValid("Alif Irfan Zuhdi");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Masukkan nama yang sesuai");
    }
    @Given("Masukkan nama yang sesuai2")
    public void masukkan_nama_yang_sesuai2(){
        sakitNegative01Page.setInputSearchValid2("Elva");
        Utils.delay(1);
        extentTest.log(LogStatus.PASS,"Masukkan nama yang sesuai2");
    }
    @Then("Verifikasi terdapat data record")
    public void verifikasi_terdapat_data_record(){
        Assert.assertFalse(sakitNegative01Page.setDataRecordEmpty());
        Assert.assertEquals(sakitNegative01Page.recordDateDetail(),"05 Apr 2024 - 05 Apr 2024");
        Assert.assertEquals(sakitNegative01Page.recordNameDetail(),"Elva");
        extentTest.log(LogStatus.PASS,"Verifikasi terdapat data record");
    }
    @When("Klik button download")
    public void klik_button_download(){
        Utils.delay(1);
        sakitNegative01Page.setBtnDownload();
        extentTest.log(LogStatus.PASS,"Klik button download");
    }
    @Then("Kembali ke tab awal")
    public void kembali_ke_tab_awal(){
        sakitNegative01Page.backTab();
        extentTest.log(LogStatus.PASS,"Kembali ke tab awal");
    }

}
