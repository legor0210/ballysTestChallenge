package test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.Page;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final By KEYWORD_TEXTFIELD = By.xpath("//input[@id='keyword-input']");

    public static final By SEARCH_ICON_BUTTON = By.xpath("//button[@title='Search']");

    //********************* test.Page Methods **********************//

    public void clickSearchIcon() {
        cmd().click(SEARCH_ICON_BUTTON);
    }

    public void setKeyword(String keyword) {
        cmd().waitElement(KEYWORD_TEXTFIELD);
        cmd().sleep(3);
        cmd().writeText(KEYWORD_TEXTFIELD,keyword);
    }

    public boolean verifySearchPageTitle(String searchData) {
        cmd().waitElement(By.xpath(String.format("//head/title[text()='%s  - Newspapers.com search']" , searchData)));
        return cmd().isVisible(By.xpath(String.format("//head/title[text()='%s  - Newspapers.com search']" , searchData)));
    }


}
