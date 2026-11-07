package org.example.module5_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {

    @FindBy(xpath = "//h2[contains(text(),'Install Selenium and run your first script')]")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }

    public SeleniumPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
