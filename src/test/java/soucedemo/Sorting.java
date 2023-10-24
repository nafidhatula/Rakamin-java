package soucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sorting {
    @Test
    public void succes_sorting(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

        driver.findElement(By.xpath("/html//div[@id='header_container']//select[@class='product_sort_container']")).click();
        driver.findElement(By.cssSelector("[value='lohi']")).click();



        //quit
        driver.close();

    }
}
