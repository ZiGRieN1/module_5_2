package org.example.module5_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.example.module5_2.CustomWait.customWait;

public class SearchFieldPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id = 'sb_form_q']")
    private WebElement searchField;

    public void click(String str, int wait){
        customWait(driver,wait).visible(searchField);
        searchField.sendKeys(str);
        searchField.submit();
    }

    public SearchFieldPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
