package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportCutiPage {

    private WebDriver driver;

    public ImportCutiPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[3]/div/div/div[2]/p")
    private WebElement btnMenuImport;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div[4]/div[2]/p")
    private WebElement importCuti;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div/div/form/div[2]/div/div[3]/button")
    private WebElement btnDownloadTemplate;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div/div/form/div[2]/div/div[2]/button")
    private  WebElement btnImport;

    @FindBy(xpath = "//*[@id=\"file_excel\"]")
    private WebElement browser;

    @FindBy(xpath = "//div[contains(@class, 'css-c352pn')]")
    private WebElement txtPesan;

    public void setBtnMenuImport(){
        btnMenuImport.click();
    }

    public void setImportCuti(){
        importCuti.click();
    }

    public void setBtnDownloadTemplate(){
        btnDownloadTemplate.click();
    }

    public void setBtnImport(){
        btnImport.click();
    }

    public String getTxtPesan(){
        return txtPesan.getText();
    }

    public void addTemplateCuti(String file) {
        browser.sendKeys("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\Template_Cuti_Hadir.xlsx");
    }

    public void addFileInvalidTemplate(String file){
        browser.sendKeys("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\Tidak_Sesuai_Template.xlsx");
    }

    public void addKosong(String file){
        browser.sendKeys("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\EMPTY.xlsx");
    }

    public void addFileFormatInvalidPDF(String file){
        browser.sendKeys("C:\\Users\\SISI\\IdeaProjects\\juaracoding\\Hadir-APP\\hadir-app-automation-testing\\src\\main\\resources\\file\\Template_Cuti_Hadir.pdf");
    }

}
