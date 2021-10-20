package com.she.pages;

import com.she.utilities.BrowserUtils;
import com.she.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LandContaminationPage {

    public LandContaminationPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//*[@id='site-wrapper']/section/a")
    public WebElement newRecordBtn;

    @FindBy(xpath = "//button[.='Save & Close']")
    public WebElement saveAndCloseBtn;

    @FindBy(xpath = "//*[@id='SheLandContamination_Description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//*[@id='tabstrip-1']/fieldset[1]/div/ul/li[7]/span/button")
    public WebElement sampleDateCalendarBtn;

    @FindBy(xpath = "//li[@class='buttons_line_close_container']")
    public WebElement buttonsLineContainer;

    public void selectSampleDate(String day, String month, String year) {

        sampleDateCalendarBtn.click();
        WebElement selectMonths = Driver.get().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select selectMonth = new Select(selectMonths);
        selectMonth.selectByVisibleText(month);

        WebElement selectYears = Driver.get().findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select selectYear = new Select(selectYears);
        selectYear.selectByValue(year);

        WebElement pickDays = Driver.get().findElement(By.xpath("//td[.='" + day + "']"));
        pickDays.click();
    }

    public void DescriptionTextField(String text) {

        descriptionField.click();
        descriptionField.sendKeys(text);
    }

    public String getDescriptionText() {
        WebElement descriptionMsg = Driver.get().findElement(By.xpath("//*[@id='site-wrapper']/section/div[3]/div/div[1]/ul/li[5]/a"));
        String txt = descriptionMsg.getText();
        return txt;
    }

    public boolean IsDescriptionMsgDisplayed(String descriptionTxt) {

        WebElement description = Driver.get().findElement(By.xpath("//a[.='" + descriptionTxt + "']"));

        boolean isDisplayed = description.isDisplayed();

        return isDisplayed;
    }


    public void Delete() {
        WebElement cogBtn = Driver.get().findElement(By.xpath("//div[@class='manage']/div/button"));
        WebElement deleteBtn = Driver.get().findElement(By.xpath("//a[@class='deleteDialog']"));

        BrowserUtils.hoverAndClick(cogBtn);

        BrowserUtils.waitFor(2);
        deleteBtn.click();


    }

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement confirmBtn;

}

