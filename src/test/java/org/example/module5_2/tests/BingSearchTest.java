package org.example.module5_2.tests;

import org.example.module5_2.pages.SearchFieldPage;
import org.example.module5_2.pages.SeleniumPage;
import org.example.module5_2.pages.SiteListPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import static org.example.module5_2.CustomWait.customWait;

public class BingSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        SearchFieldPage searchFieldPage = new SearchFieldPage(driver);
        String input = "Selenium";
        searchFieldPage.click(input, 10);
        SiteListPage siteListPage = new SiteListPage(driver);
        siteListPage.clickSearch(0, 10);
        SeleniumPage seleniumPage = new SeleniumPage(driver);
        customWait(driver, 5).visible(seleniumPage.getTitle());
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/",
                "URL не совпадает");
    }


}
