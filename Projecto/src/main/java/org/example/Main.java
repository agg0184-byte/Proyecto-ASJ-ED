package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Main {

    // SMELL 7: Dead Code (This code isn't used)
    public void oldMethodThatIsNotUsedAnymore() {
        System.out.println("This is old logic");
    }

    // SMELL 1: Long Method (Every thing is inside the Main)
    // SMELL 2: Large Class / God Class (The class is too long)

    public static void main(String[] args) throws Exception {
        // SMELL 8: Comments (Obvious comments)
        // Configure the web driver using webdrivermanager
        WebDriverManager.chromedriver().setup();

        WebDriver d = new ChromeDriver(); // SMELL 9: Inconsistent/Poor Naming (Variable 'd')

        try {
            d.get("https://www.saucedemo.com/");
            // SMELL 6: Hardcoded Sleeps (Explicit pauses with Thread.sleep)
            Thread.sleep(2000);

            WebElement u = d.findElement(By.id("user-name")); // SMELL 9: Poor naming 'u'
            u.sendKeys("standard_user");

            // SMELL 4: Magic Strings ("standard_user")
            WebElement p = d.findElement(By.id("password")); // SMELL 9: Poor naming 'p'
            p.sendKeys("secret_sauce");
            // SMELL 6: Hardcoded Sleeps (Explicit pauses with Thread.sleep)
            Thread.sleep(1000);

            WebElement btn1 = d.findElement(By.id("login-button")); // SMELL 9: Poor naming 'btn1'
            btn1.click();

            Thread.sleep(3000);

            System.out.println("Successful login");

            // SMELL 3: Duplicate Code (The logic besides validation and impression is duplicated)

            List<WebElement> items = d.findElements(By.cssSelector(".inventory_item_name"));
            if (items.size() > 0) {
                System.out.println("Product Finded: " + items.get(0).getText());
            } else {
                System.out.println("There is no products");
            }

            if (items.size() > 1) {
                System.out.println("Product Finded: " + items.get(1).getText());
            } else {
                System.out.println("There is no products");
            }

            fillForm(d, "Antonio", "Gomez", "12345", "123 St", "SEV", "ES");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // SMELL 6: Hardcoded Sleeps (Explicit pauses with Thread.sleep)
            Thread.sleep(2000);
            d.quit();
        }
    }

    // SMELL 10: Primitive Obsession (Passing multiple strings instead of one encapsulated object)
    public static void fillForm(WebDriver driver, String a, String b, String c, String address, String state, String country) throws Exception {
        System.out.println("Filling data: " + a + " " + b + " - ZIP: " + c);
        System.out.println("Address: " + address + " " + state + " " + country);

        Thread.sleep(1000);
    }
}