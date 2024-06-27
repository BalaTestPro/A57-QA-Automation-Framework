package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;

public class NewPlayListStepDefinition {

    @Given("I login to Koel {string} {string}")
    public void loginToKoel(String email, String password) {
        BaseDefinition.getThreadLocal().get("https://qa.koel.app/");
        LoginPage loginPage = new LoginPage(BaseDefinition.getThreadLocal());
        loginPage.login(email,password);
    }

    @When("I create a playlist")
    public void createPlaylist() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        String playListName = "Test " + homePage.generateRandomName().substring(0,4);
        homePage.createNewPlaylist(playListName);
    }

    @Then("I should see the success alert")
    public void testSuccessAlert() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertTrue(homePage.isSuccessAlertDisplayed(),"New playlist created.");
    }

    @When("I create a playlist {string}")
    public void createPlaylist(String playListName) {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        homePage.createNewPlaylist(playListName);
    }

    @Then("I should see the validation message")
    public void testValidationMessage() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        String expectedErrorValidationMessage = "Please fill out this field.";
        Assert.assertEquals(homePage.getTextPlayListValidationMessage(),expectedErrorValidationMessage,"Validation message is displayed");
    }

    @Then("I should not see the success alert")
    public void testNoSuccessAlert() {
        HomePage homePage = new HomePage(BaseDefinition.getThreadLocal());
        Assert.assertFalse(homePage.isSuccessAlertDisplayed(),"Incorrect PlayListName");
    }
}
