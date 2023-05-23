package test.testcases;

import common.SeleniumBase;
import data.LoginData;
import data.SearchData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.HomePage;
import test.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class searchScenario extends SeleniumBase {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.goToSite();
        loginPage.clickSign();
        loginPage.SignInTestAccount(LoginData.USERNAME_DATA);

    }

    @Test (description = "Verify if User Successfully Sign In")
    public void tc1(){
        homePage.setKeyword(SearchData.MICHAEL_JORDAN);
        homePage.clickSearchIcon();
        assertTrue(homePage.verifySearchPageTitle(SearchData.MICHAEL_JORDAN));
    }

}
