package org.example.module5_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import static org.example.module5_2.CustomWait.customWait;

public class SiteListPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='tpmeta']/div/cite")
    private List<WebElement> sites;

    public void clickSearch(int num, int wait) {
        customWait(driver,wait).staleness(sites.get(num));
        sites.get(num).click();
        ArrayList tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) driver.switchTo().window(tabs.get(1).toString());
    }

    public SiteListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
