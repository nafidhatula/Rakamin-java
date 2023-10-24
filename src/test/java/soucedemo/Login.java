package soucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void succes_login_case(){
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

        //quit
        driver.close();
    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[@id='root']//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");


        //membuka halaman login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password yang salah
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();

        //Assert error
        String errorLogin = driver.findElement(By.xpath("//div[@id='login_button_container']//form//h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");

        //quit
        driver.close();
    }

}
