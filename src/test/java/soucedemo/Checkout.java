package soucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Checkout {
    @Test
    public void succes_Checkout(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[@id='root']//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");


        //membuka halaman login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Assert produk setelah login
        String produk = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(produk, "Products");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String cart = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(cart, "Your Cart");
        driver.findElement(By.id("checkout")).click();

        String info = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");

        driver.findElement(By.id("first-name")).sendKeys("Nafidhatul");
        driver.findElement(By.id("last-name")).sendKeys("Ula");
        driver.findElement(By.id("postal-code")).sendKeys("78513");
        driver.findElement(By.id("continue")).click();

        String overview = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(overview, "Checkout: Overview");
        driver.findElement(By.id("finish")).click();

        String complete = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals(complete, "Thank you for your order!");


        //Assert produk setelah checkout
        String thankyou = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2[@class='complete-header']")).getText();
        Assert.assertEquals(thankyou, "Thank you for your order!");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        //quit
        driver.close();
    }
}
