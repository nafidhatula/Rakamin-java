package soucedemo;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    //login menggunakan fitur Data Drive Test (DDT)
@Test
    public void login_ddt(){
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    WebDriverManager.chromedriver().setup();
    ChromeOptions opt = new ChromeOptions();
    opt.setHeadless(false);

    String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";
    try (CSVReader reader = new CSVReader(new FileReader(csvDir))){
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null){
            String username = nextLine[0];
            String password = nextLine[1];
            String status = nextLine [2];

            driver = new ChromeDriver(opt);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);

            //Pengisian Form
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();

            //Assertion
            if (status.equals("succes")) { //jika succes
                String produk = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
                Assert.assertEquals(produk, "Products");
            }else{ //jika failed
                String errorLogin = driver.findElement(By.xpath("//div[@id='login_button_container']//form//h3")).getText();
                Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
            }
            driver.close();
        }
    }catch (IOException | CsvValidationException e) {
        throw new RuntimeException(e);

    }

    }
}
