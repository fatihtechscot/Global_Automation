package com.automationpractice.utilities;

import com.automationpractice.pages.homePage.CommonPO;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;


public class Utils {

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getSize(String sizeType) {
        CommonPO commonPO = new CommonPO();
        switch (sizeType) {
            case "L":
                commonPO.sizeL.click();
                break;
            case "S":
                commonPO.sizeS.click();
                break;
            case "M":
                commonPO.sizeM.click();
                break;
        }
    }

    public static void getColour(String colourType) {
        CommonPO commonPO = new CommonPO();

        switch (colourType) {
            case "beige":
                commonPO.colorBeige.click();
                break;
            case "orange":
                commonPO.colorOrange.click();
                break;
            case "blue":
                commonPO.colorBlue.click();
                break;
        }
    }

    public static void hoverProductsByText(List<WebElement> products, String productText) {
        for (WebElement w : products) {
            if ((Objects.equals(w.getText(), productText))) {
                hover(w);
                break;
            }
        }
    }

    public static void removeProduct(String productName) {
        List<WebElement> Rows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        for (int i = 1; i <= Rows.size(); i++) {
            String products = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[2]")).getText();
            if (products.contains(productName)) {
                Rows.get(i - 1).findElement(By.cssSelector(".icon-trash")).click();
            }
        }
    }

    public static void addProduct(String productName) {
        List<WebElement> Rows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        for (int i = 1; i <= Rows.size(); i++) {
            String products = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[2]")).getText();
            if (products.contains(productName)) {
                Rows.get(i - 1).findElement(By.cssSelector(".icon-plus")).click();
            }
        }
    }

    public static boolean verifyEachLineTotalPrice() {
        List<WebElement> Rows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));

        for (int i = 1; i <= Rows.size(); i++) {

            String unitPrice = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[4]")).getText().substring(1,6);
            String quantity = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[5]/input")).getAttribute("value");
            String total = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[6]")).getText().substring(1);

            if (Double.parseDouble(total) != Double.parseDouble(unitPrice) * Double.parseDouble(quantity)) {
                return false;
            }
        }
        return true;
    }
}
