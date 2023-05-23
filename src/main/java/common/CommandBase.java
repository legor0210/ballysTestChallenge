package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class CommandBase {

    public WebDriver driver;
    public WebElement element;

    private static final int RETRY_COUNT = 5;

    public CommandBase(WebDriver driver) {
        this.driver = driver;
    }

    //click method
    public void click (By elementBy) {
        waitElement(elementBy);
        driver.findElement(elementBy).click();
    }

    public void waitElement (By elementBy) {
       element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //writeText
    public void writeText (By elementBy, String text) {
        driver.findElement(elementBy).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE),"");
        driver.findElement(elementBy).sendKeys(text);
    }

    public boolean isVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            // Useful if the element is not really on the page.
            LOG.info("Element is not yet or not in page");
            return false;
        }
    }

    public String getText(String identifier, String locator) {
        int attempts = 0;
        while (attempts < RETRY_COUNT) {
            try {
                String textValue = "";
                if (identifier.equalsIgnoreCase("id")) {
                    textValue = driver.findElement(By.id(locator)).getText();
                } else if (identifier.equalsIgnoreCase("name")) {
                    textValue = driver.findElement(By.name(locator)).getText();
                } else if (identifier.equalsIgnoreCase("xpath")) {
                    textValue = driver.findElement(By.xpath(locator)).getText();
                } else if (identifier.equalsIgnoreCase("cssSelector")) {
                    textValue = driver.findElement(By.cssSelector(locator)).getText();
                } else if (identifier.equalsIgnoreCase("className")) {
                    textValue = driver.findElement(By.className(locator)).getText();
                }
                return textValue;
            } catch (NoSuchElementException e) {
                return null;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return null;
    }

    // seconds
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("An error has occurred " + e);
        }
    }

}
