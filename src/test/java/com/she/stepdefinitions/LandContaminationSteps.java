package com.she.stepdefinitions;

import com.she.pages.HomePage;
import com.she.pages.LandContaminationPage;
import com.she.pages.LoginPage;
import com.she.utilities.BrowserUtils;
import com.she.utilities.ConfigurationReader;
import com.she.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LandContaminationSteps {

    LandContaminationPage landContamination = new LandContaminationPage();

    @Given("The user in the login page")
    public void the_user_in_the_login_page() {
        String url = ConfigurationReader.get("url");

        Driver.get().get(url);

    }

    @When("The user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        LoginPage loginPage = new LoginPage();

        loginPage.login();
    }

    @Given("The user navigates to {string} {string} {string}")
    public void the_user_navigates_to(String modules, String page1, String page2) {
        HomePage homePage = new HomePage();
        homePage.NavigateModules(modules, page1, page2);

        landContamination.DeleteAll();
        BrowserUtils.waitFor(3);

        landContamination.confirmBtn.click();
    }

    @When("User clicks New Record button")
    public void user_clicks_New_Record_button() {


        landContamination.newRecordBtn.click();
    }

    @When("User enters first message in description fields")
    public void user_enters_first_message_in_description_fields() {
        landContamination.buttonsLineContainer.click();
        BrowserUtils.waitFor(3);
        landContamination.DescriptionTextField("First Test");
    }

    @When("User enters date")
    public void user_enters_date() {
        landContamination.selectSampleDate("1", "Jan", "2020");

        landContamination.buttonsLineContainer.click();

    }

    @When("User click Save & Close button")
    public void user_click_Save_Close_button() {

        BrowserUtils.waitFor(3);
        landContamination.saveAndCloseBtn.click();
    }

    @When("User enters second message in description fields")
    public void user_enters_second_message_in_description_fields() {
        landContamination.buttonsLineContainer.click();
        BrowserUtils.waitFor(3);
        landContamination.DescriptionTextField("Second Test");
    }

    @When("User delete first record")
    public void user_delete_first_record() {
        BrowserUtils.waitFor(3);

        landContamination.Delete();
        BrowserUtils.waitFor(3);
        landContamination.confirmBtn.click();


    }

    @Then("Verify the first record has been deleted")
    public void verify_the_first_record_has_been_deleted() {
        String actualMsg = landContamination.getDescriptionText();
        Assert.assertTrue(!actualMsg.equals("First Test"));
    }

    @Then("Verify the second record is still available")
    public void verify_the_second_record_is_still_available() {
        boolean isSelectedMsgDisplayed;
        isSelectedMsgDisplayed = landContamination.IsDescriptionMsgDisplayed("Second Test");
        Assert.assertTrue(isSelectedMsgDisplayed);
    }


}
