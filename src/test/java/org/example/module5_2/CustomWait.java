package org.example.module5_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CustomWait {
    private WebDriverWait wait;
    private final int secondsToWait;
    private final Logger LOG = LoggerFactory.getLogger(CustomWait.class);

    public static CustomWait customWait(WebDriver driver, int seconds) {
        return new CustomWait(driver, seconds);
    }

    public CustomWait(WebDriver driver, int seconds) {
        secondsToWait = seconds;
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }


    public WebElement clickable(WebElement el) {
        LOG.info("Ждём " + secondsToWait + " секунд и элемент станет кликабельным: " + el);
        return wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public WebElement visible(WebElement el) {
        LOG.info("Ждём " + secondsToWait + " секунд и элемент станет видимым: " + el);
        return wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void staleness(WebElement el) {
        LOG.info("Ждём устаревания элемента " + secondsToWait + " секунд: " + el.toString());
        wait.until(ExpectedConditions.stalenessOf(el));
    }
}
