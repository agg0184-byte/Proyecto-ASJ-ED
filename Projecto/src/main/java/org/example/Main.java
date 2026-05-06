package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class Main {

    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get(BASE_URL);

            login(driver, VALID_USER, VALID_PASSWORD);
            System.out.println("Successful login!");

            checkInventoryItems(driver);

            CustomerInfo customer = new CustomerInfo("Antonio", "Gomez", "1234", "123 St", "SEV", "ES");
            fillCheckoutForm(customer);

        } catch (Exception e) {
            System.err.println("\n" + "An error occurred during test execution: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static void login(WebDriver driver, String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    private static void checkInventoryItems(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name")));

        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name"));
        printProductIfPresent(items, 0);
        printProductIfPresent(items, 1);
    }

    private static void printProductIfPresent(List<WebElement> items, int index) {
        if (items.size() > index) {
            System.out.println("Product Finded: " + items.get(index).getText());
        } else {
            System.out.println("Not enought products");
        }
    }

    private static void fillCheckoutForm(CustomerInfo customer) {
        System.out.printf("Filling Data: %s %s - ZIP: %s%n", customer.firstName(), customer.lastName(), customer.zipCode());
        System.out.printf("Address: %s %s %s%n", customer.address(), customer.state(), customer.country());
    }


    public record CustomerInfo(String firstName, String lastName, String zipCode, String address, String state, String country) {}
}