package com.she.pages;

import com.she.utilities.BrowserUtils;
import com.she.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.get(), this);
    }

    public void NavigateModules(String modules, String page1, String page2) {
        WebElement modulesDropdown = Driver.get().findElement(By.xpath("//a[.='" + modules + "']"));
        WebElement dropDownPage1 = Driver.get().findElement(By.xpath("//a[.='" + page1 + "']"));
        WebElement dropDownPage2 = Driver.get().findElement(By.xpath("//a[.='" + page2 + "']"));
        modulesDropdown.click();
        BrowserUtils.hover(dropDownPage1);
        BrowserUtils.hoverAndClick(dropDownPage2);

    }
}
