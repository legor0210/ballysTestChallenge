package test;

import common.CommandBase;
import org.openqa.selenium.WebDriver;

public  abstract class Page {
    private final WebDriver driver;
    private final CommandBase commandBase;

    protected Page (WebDriver driver){
        this.driver = driver;
        commandBase = new CommandBase(driver);
    }

    public WebDriver d() {
        return driver;
    }

    public CommandBase cmd() {
        return commandBase;
    }

}
