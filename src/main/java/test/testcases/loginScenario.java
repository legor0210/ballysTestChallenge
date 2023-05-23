package test.testcases;

import common.SeleniumBase;
import data.LoginData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class loginScenario extends SeleniumBase {

    LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        loginPage = new LoginPage(driver);
        loginPage.goToSite();
        loginPage.clickSign();
    }

    @Test (description = "Verify Elements on Sign In Modal")
    public void tc1(){
        assertTrue(loginPage.verifySignInModalElements());
    }

    @Test (description = "Verify Validation of Missing Email or Password")
    public void tc2(){
        loginPage.setEmail(LoginData.BLANK_DATA);
        loginPage.clickSignNewsPaper();
        assertTrue(loginPage.verifyMissingEmailPasswordMessage());

        loginPage.setEmail(LoginData.BLANK_DATA);
        loginPage.setPassword(LoginData.PASSWORD_DATA);
        loginPage.clickSignNewsPaper();
        assertTrue(loginPage.verifyMissingEmailPasswordMessage());

        loginPage.setEmail(LoginData.EMAIL_ADDRESS_DATA);
        loginPage.setPassword(LoginData.BLANK_DATA);
        loginPage.clickSignNewsPaper();
        assertTrue(loginPage.verifyMissingEmailPasswordMessage());
    }

    @Test (description = "Verify Validation of Invalid Password")
    public void tc3(){
        loginPage.setEmail(LoginData.EMAIL_ADDRESS_DATA);
        loginPage.setPassword(LoginData.INVALID_PASSWORD_DATA);
        loginPage.clickSignNewsPaper();
        assertTrue(loginPage.verifyInvalidPasswordMessage());
    }

    @Test (description = "Verify if User Successfully Sign In")
    public void tc4(){
        loginPage.setEmail(LoginData.EMAIL_ADDRESS_DATA);
        loginPage.setPassword(LoginData.PASSWORD_DATA);
        loginPage.clickSignNewsPaper();
        assertTrue(loginPage.verifySignInSuccessfullyViaUsername(LoginData.USERNAME_DATA));
    }

}
