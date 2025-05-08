package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BStackDemoTest extends SeleniumTest {

    @Test(priority = 0)
    public void selfHealSetup() throws Exception {

        // Maximizing the browser window
        driver.manage().window().maximize();

        // Open self-heal test page
        driver.get("https://shashankg-gollapally.github.io/Automate_Selfheal_Pages/index.html");

        // Intialized Explicit Webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Interact with dropdown and select option
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-selector")));
        dropdown.click();

        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[@value='old.html']")));
        optionToSelect.click();


        // Interact with input box
        WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#username")));
        inputBox.sendKeys("test123");

        // Set session status on BrowserStack
        ((JavascriptExecutor) driver).executeScript(
                "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": " +
                        "{\"status\":\"passed\", \"reason\": \"Test passed\"}}"
        );
    }

    @Test(priority = 1)
    public void testSelfHealFlow()
    {
        // Maximizing the browser window
        driver.manage().window().maximize();

        // Open self-heal test page
        driver.get("https://shashankg-gollapally.github.io/Automate_Selfheal_Pages/index.html");

        // Intialized Explicit Webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Interact with dropdown and select option
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-selector")));
        dropdown.click();

        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[@value='new.html']")));
        optionToSelect.click();

        // Interact with input box
        WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#username")));
        inputBox.sendKeys("test123");
    }
}
