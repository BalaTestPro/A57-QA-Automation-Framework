import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.ProfilePage;
public class LogoutTests extends BaseTest{

    @Test (priority = 1)
    public void checkLogoutNextToProfile() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login using Email and Password
        loginPage.login("sakthibala.sengottiyan@testpro.io","te$t$tudent1");

        //Check if Log Out button is next to profile button
        Assert.assertTrue(homePage.isLogOutNextToProfile());

    }

    @Test (priority = 2)
    public void verifyLogOut() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login using Email and Password
        loginPage.login("sakthibala.sengottiyan@testpro.io","te$t$tudent1");

        //Log Out
        homePage.logOut();

        //Verify the user is successfully logged out
        Assert.assertTrue(loginPage.isEmailFieldVisible());

    }

    @Test (priority = 3)
    public void checkLoginPageAfterLogOut() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login using Email and Password
        loginPage.login("sakthibala.sengottiyan@testpro.io","te$t$tudent1");

        //Log Out
        homePage.logOut();

        //Verify if the user is successfully logged out
        Assert.assertTrue(loginPage.isEmailFieldVisible());

    }

    @Test (priority = 4)
    public void verifyLogOutAfterUpdatingEmail() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        //Login using Email and Password
        loginPage.login("sakthibala.sengottiyan+2@testpro.io","te$t$tudent2");

        //Click Profile
        homePage.clickProfile();

        //Update Email and Save
        profilePage.updateEmail("te$t$tudent2","sakthibala.sengottiyan+1@testpro.io");

        //Log Out
        homePage.logOut();

        //Verify if the user is successfully logged out
        Assert.assertTrue(loginPage.isEmailFieldVisible());

    }

    @Test (priority = 5)
    public void verifyLogOutAfterUpdatingPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        //Login using Email and Password
        loginPage.login("sakthibala.sengottiyan+1@testpro.io","te$t$tudent2");

        //Click Profile
        homePage.clickProfile();

        //Update Password and Save
        profilePage.updatePassword("te$t$tudent2","te$t$tudent1");

        //Log Out
        homePage.logOut();

        //Verify if the user is successfully logged out
        Assert.assertTrue(loginPage.isEmailFieldVisible());

    }

    @Test (priority = 6)
    public void verifyLogOutAfterUpdatingEmailAndPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        //Login using Email and Password
        loginPage.login("sakthibala.sengottiyan+1@testpro.io","te$t$tudent1");

        //Click Profile
        homePage.clickProfile();

        //Update Email and Password and Save
        profilePage.updateEmailPassword("te$t$tudent1","sakthibala.sengottiyan+2@testpro.io","te$t$tudent2");

        //Log Out
        homePage.logOut();

        //Verify if the user is successfully logged out
        Assert.assertTrue(loginPage.isEmailFieldVisible());

    }

}

