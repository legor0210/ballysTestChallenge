package test.pages;


import data.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.Page;

public class LoginPage extends Page {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public static final String BASEURL = "https://www.newspapers.com/";

    public static final By SIGN_IN_LINK = By.xpath("//a[@id='signinlink']");
    public static final By EMAIL_TEXTFIELD = By.xpath("//input[@id='username']");
    public static final By PASSWORD_TEXTFIELD = By.xpath("//input[@id='password']");

    public static final By SIGN_IN_NEWSPAPER_BUTTON = By.xpath("//button[@class='btn icon-news btn-si ncom-btn btn-primary icon-n']");

    public static final By VALIDATION_MISSING_MESSAGE = By.xpath("  //div[text()='Missing email or password']");
    public static final By VALIDATION_INVALID_MESSAGE = By.xpath("  //div[text()='There is a problem with your email/password. ']");

    //********************* test.Page Methods **********************//
    //Go to Site

    public void goToSite() {
        d().get(BASEURL);
    }

    public void clickSign() {
        cmd().click(SIGN_IN_LINK);
    }

    public boolean verifyInvalidPasswordMessage() {
        cmd().waitElement(VALIDATION_INVALID_MESSAGE);
        return cmd().isVisible(VALIDATION_INVALID_MESSAGE);
    }
    public void setEmail(String email) {
        cmd().waitElement(EMAIL_TEXTFIELD);
        cmd().writeText(EMAIL_TEXTFIELD,email);
    }

    public void setPassword(String password) {
        cmd().waitElement(PASSWORD_TEXTFIELD);
        cmd().writeText(PASSWORD_TEXTFIELD,password);
    }

    public void SignInTestAccount(String userName) {
        setEmail(LoginData.EMAIL_ADDRESS_DATA);
        setPassword(LoginData.PASSWORD_DATA);
        clickSignNewsPaper();
        cmd().waitElement(By.xpath(String.format("//strong[@title='%s']" , userName)));
    }

    public void clickSignNewsPaper() {
        cmd().click(SIGN_IN_NEWSPAPER_BUTTON);
    }

    public boolean verifySignInModalElements() {
        cmd().waitElement(EMAIL_TEXTFIELD);
        return cmd().isVisible(EMAIL_TEXTFIELD) && cmd().isVisible(PASSWORD_TEXTFIELD) && cmd().isVisible(SIGN_IN_NEWSPAPER_BUTTON);
    }

    public boolean verifyMissingEmailPasswordMessage() {
        cmd().waitElement(VALIDATION_MISSING_MESSAGE);
       return cmd().isVisible(VALIDATION_MISSING_MESSAGE);
    }

    public boolean verifySignInSuccessfullyViaUsername(String userName) {
        cmd().waitElement(By.xpath(String.format("//strong[@title='%s']" , userName)));
        return cmd().isVisible(By.xpath(String.format("//strong[@title='%s']" , userName)));
    }


}
