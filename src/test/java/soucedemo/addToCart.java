package soucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class addToCart {
    @Test
    public void succes_addToCart(){
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

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        String cart = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(cart, "Your Cart");

        //quit
        driver.close();
    }
}
