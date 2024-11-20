package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.KehadiranPage;
import com.juaracoding.pages.admin.LoginPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KehadiranTest {
    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static KehadiranPage kehadiranPage = new KehadiranPage();

    public KehadiranTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Then("I select the laporan menu")
    public void i_navigate_to_the_laporan_menu(){
        kehadiranPage.setLaporanBtn();
        extentTest.log(LogStatus.PASS,"I select the laporan menu");
    }

    @And("I select the kehadiran submenu")
    public void i_select_the_kehadiran_submenu(){
        Utils.delay(2);
        kehadiranPage.setKehadiranBtn();
        extentTest.log(LogStatus.PASS,"I select the kehadiran submenu");
    }

    @And("I enter name in the employee name field")
    public void i_enter_name_in_the_employee_name_field(){
        Utils.delay(2);
        kehadiranPage.setName("kazama");
        extentTest.log(LogStatus.PASS,"I enter name in the employee name field");
    }

    @And("I select the start date")
    public void i_select_the_start_date(){
        kehadiranPage.setDateButton();
        Utils.delay(2);
        kehadiranPage.clearStartDate();
        kehadiranPage.getInputStartDate("Nov 20,2024");
        extentTest.log(LogStatus.PASS,"I select the start date");
    }

    @And("I select the end date")
    public void i_select_the_end_date(){
        kehadiranPage.clearEndDate();
        Utils.delay(2);
        kehadiranPage.getInputEndDate("Nov 20, 2024");
        Utils.delay(2);
        kehadiranPage.getSaveButton();
        extentTest.log(LogStatus.PASS,"I select the end date");
    }

    @And("I click the filter button")
    public void i_click_the_filter_button(){
        Utils.delay(2);
        kehadiranPage.getFilterButton();
        extentTest.log(LogStatus.PASS,"I click the filter button");
    }

    @And("I select the departement from the department dropdown")
    public void i_select_the_department_from_the_department_dropdown(){
        Utils.delay(2);
        kehadiranPage.setJobDepartment("IT Programmer");
        extentTest.log(LogStatus.PASS,"I select the departement from the department dropdown");
    }

    @And("I click the terapkan button")
    public void i_click_the_terapkan_button(){
        Utils.delay(2);
        kehadiranPage.getTerapkanButton();
        extentTest.log(LogStatus.PASS,"I click the terapkan button");
    }

    @And("I click the search button")
    public void i_click_the_search_button(){
        Utils.delay(2);
        kehadiranPage.getSearchButton();
        extentTest.log(LogStatus.PASS,"I click the search button");
    }

    @Then("I should see the attendance data for the employee within the date range for the department")
    public void i_should_see_the_attendance_data_for_the_employee_within_the_date_range_for_the_department(){
        Utils.delay(2);
        Assert.assertEquals(kehadiranPage.getTxtValid(),"kazama");
        extentTest.log(LogStatus.PASS,"I should see the attendance data for the employee within the date range for the department");
    }

    @And("I enter wrong name in the employee name field")
    public void i_enter_wrong_name_in_the_employee_name_field(){
        Utils.delay(2);
        kehadiranPage.setName("Berry Prima");
        extentTest.log(LogStatus.PASS,"I enter wrong name in the employee name field");
    }

    @And("I select the wrong start date")
    public void i_enter_the_wrong_start_date(){
        Utils.delay(2);
        kehadiranPage.setDateButton();
        Utils.delay(2);
        kehadiranPage.clearStartDate();
        kehadiranPage.getInputStartDate("Nov 30,2024");
        extentTest.log(LogStatus.PASS,"I select the wrong start date");
    }

    @And("I select the wrong end date")
    public void i_select_the_wrong_end_date(){
        kehadiranPage.clearEndDate();
        Utils.delay(2);
        kehadiranPage.getInputEndDate("Nov 30, 2024");
        Utils.delay(2);
        kehadiranPage.getSaveButton();
        extentTest.log(LogStatus.PASS,"I select the wrong end date");
    }

    @And("I select the wrong departement from the department dropdown")
    public void i_select_the_wrong_department_from_the_department_dropdown(){
        Utils.delay(2);
        kehadiranPage.setJobDepartment("wrong department");
        extentTest.log(LogStatus.PASS,"I select the wrong departement from the department dropdown");
    }

    @Then("I should see the attendance data not showing any data")
    public void i_should_see_the_attendance_data_not_showing_any_data(){
        Utils.delay(2);
        Assert.assertEquals(kehadiranPage.getTxtInvalid(),"0-0 of 0");
        extentTest.log(LogStatus.PASS,"I should see the attendance data not showing any data");
    }

    @And("I click the export button")
    public void i_click_the_export_button(){
        Utils.delay(2);
        kehadiranPage.getExportButton();
        extentTest.log(LogStatus.PASS,"I click the export button");
    }

    @And("I click sub export button")
    public void i_click_the_sub_export_button(){
        Utils.delay(2);
        kehadiranPage.getExtendExportButton();
        extentTest.log(LogStatus.PASS,"I click sub export button");
    }

    @Then("I should see the error message")
    public void i_should_see_the_error_message(){
        Utils.delay(2);
        Assert.assertEquals(kehadiranPage.getErroTxt(),"Maaf terjadi kesalahan pada server");
        extentTest.log(LogStatus.FAIL,"I should see the error message");
    }

    @And("I select reset button")
    public void i_select_reset_button(){
        Utils.delay(2);
        kehadiranPage.getResetButton();
        extentTest.log(LogStatus.PASS,"I select reset button");
    }

    @Then("I should see the attendance data reset")
    public void i_should_see_the_attendance_data_reset(){
        Utils.delay(2);
        Assert.assertEquals(kehadiranPage.getResetButtonValid(),"Unit");
        extentTest.log(LogStatus.PASS,"I should see the attendance data reset");
    }
    
}
