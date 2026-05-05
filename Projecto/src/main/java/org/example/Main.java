package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Main {


    public void oldMethodThatIsNotUsedAnymore() {
        System.out.println("This is old logic");
    }

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver d = new ChromeDriver(); // SMELL 9: Inconsistent/Poor Naming (Variable 'd')

        try {
            d.get("https://www.saucedemo.com/");

            Thread.sleep(2000);

            WebElement u = d.findElement(By.id("user-name")); // SMELL 9: Poor naming 'u'
            u.sendKeys("standard_user");

            WebElement p = d.findElement(By.id("password")); // SMELL 9: Poor naming 'p'
            p.sendKeys("secret_sauce");

            Thread.sleep(1000);

            WebElement btn1 = d.findElement(By.id("login-button")); // SMELL 9: Poor naming 'btn1'
            btn1.click();

            Thread.sleep(3000);

            System.out.println("Login exitoso!");

            List<WebElement> items = d.findElements(By.cssSelector(".inventory_item_name"));
            if (items.size() > 0) {
                System.out.println("Producto encontrado: " + items.get(0).getText());
            } else {
                System.out.println("No hay productos");
            }

            if (items.size() > 1) {
                System.out.println("Producto encontrado: " + items.get(1).getText());
            } else {
                System.out.println("No hay productos");
            }

            fillForm(d, "John", "Doe", "12345", "123 Main St", "NY", "USA");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            d.quit();
        }
    }

    public static void fillForm(WebDriver driver, String a, String b, String c, String address, String state, String country) throws Exception {
        System.out.println("Filling data: " + a + " " + b + " - ZIP: " + c);
        System.out.println("Address: " + address + " " + state + " " + country);

        Thread.sleep(1000);
    }
}