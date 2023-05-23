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

    public static final String KEYWORD_SEARCH_RESULT_LABEL ="//div[@id='SearchResults']/div[1]/h1/span[2]";

    //********************* test.Page Methods **********************//

    public void clickSearchIcon() {
        cmd().click(SEARCH_ICON_BUTTON);
    }

    public void setKeyword(String keyword) {
        cmd().waitElement(KEYWORD_TEXTFIELD);
        cmd().sleep(3);
        cmd().writeText(KEYWORD_TEXTFIELD,keyword);
    }

    public boolean verifySearchKeywordResult(String searchData) {
        cmd().waitElement(By.xpath(KEYWORD_SEARCH_RESULT_LABEL));
        String actualResult = cmd().getText("xpath",KEYWORD_SEARCH_RESULT_LABEL).trim();
        return actualResult.equalsIgnoreCase(searchData);
    }


}
