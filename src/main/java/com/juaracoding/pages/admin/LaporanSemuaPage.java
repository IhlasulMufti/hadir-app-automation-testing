package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaporanSemuaPage {
    private WebDriver driver;

    public LaporanSemuaPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza'])[1]")
    private WebElement laporanMenuBar;
    @FindBy(xpath = "(//p[@class= 'MuiTypography-root MuiTypography-body1 css-aqx7sf'])[3]")
    private WebElement laporanSemuaList;
    @FindBy (xpath = "//p[@class= 'MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement txtSemua;
    @FindBy(xpath = "//input [@id= 'search']")
    private WebElement inputSearch;
    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement btnSearch;
    @FindBy(xpath= "(//button[contains(@class, 'MuiButtonBase-root MuiButton-root MuiButton-text')])[2]")
    private WebElement btnReset;
    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-1k0lhp1')]")
    private WebElement btnFilterBy;
    @FindBy(xpath = "//input[@id= 'job_departement']")
    private WebElement inputUnit;
    @FindBy(xpath = "//ul[@class='MuiAutocomplete-listbox css-6sh6i8']")
    private WebElement listUnit;
    @FindBy(xpath = "//button[contains(@class, 'sizeMedium MuiButton-containedSizeMedium css-4075ia')]")
    private WebElement btnTerapkan;
    @FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-sizeMedium css-q9cuy5')])[1]")
    private WebElement btnStartDatePicker;
    @FindBy(xpath = "//input[@placeholder= 'Early']")
    private WebElement inputStartDate; //08 Nov 2024
    @FindBy(xpath = "//input[@placeholder= 'Continuous']")
    private WebElement inputEndDate; // 11 Nov 2024
    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-4075ia')]")
    private WebElement btnDatePickerSave;
    @FindBy(xpath = "(//h5[@class='MuiTypography-root MuiTypography-h5 css-60zgsh'])[2]")
    private WebElement txtTabelNamaKaryawan;
    @FindBy(xpath = "//h6[text()='testerjuara']")
    private WebElement txtNamaKaryawan; //testerjuara
    @FindBy(xpath = "//span[@class='rdrWarning']")
    private WebElement txtWarningDate;
    
    public void setLaporanMenuBar(){
        laporanMenuBar.click();
    }

    public void setLaporanSemuaList(){
        laporanSemuaList.click();
    }

    public String getTxtSemua(){
        return txtSemua.getText();
    }

    public void setInputSearch(String name){
        this.inputSearch.sendKeys(name);
    }

    public void setBtnSearch(){
        btnSearch.click();
    }

    public void setBtnReset(){
        btnReset.click();
    }

    public void setBtnFilterBy(){
        btnFilterBy.click();
    }

    public void setInputUnit(String departemen){
        this.inputUnit.sendKeys(departemen);
        Utils.delay(3);
        listUnit.click();
    }

    public void setBtnTerapkan(){
        btnTerapkan.click();
    }

    public void setBtnDatePicker(){
        btnStartDatePicker.click();
    }

    public void setInputStartDate(String startDate){
        inputStartDate.click();
        inputStartDate.clear();
        inputStartDate.sendKeys(startDate);
    }

    public void setInputEndDate(String endDate){
        inputEndDate.click();
        inputEndDate.clear();
        inputEndDate.sendKeys(endDate);
    }

    public void setBtnDatePickerSave(){
        btnDatePickerSave.click();
    }

    public String getTxtTabelNameKaryawan(){
        return txtTabelNamaKaryawan.getText();
    }

    public String getTxtNamaKaryawan(){
        return txtNamaKaryawan.getText();
    }

    public String getTxtWarningDate(){
        return txtWarningDate.getText();
    }

    public void setInputDateClear(){
        inputStartDate.clear();
    }

    public void setEndDateClear(){
        inputEndDate.clear();
    }





}
