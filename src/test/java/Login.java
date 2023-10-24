import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
    @Test // tag untuk running

    public void open_browser(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println(title);
        driver.close();

    }

    @Test // tag untuk running

    public void get_title(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        //apply driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);
        String username_button = "user-name";

        WebElement ele1 = driver.findElement(By.id("user-name"));
        WebElement ele2 = driver.findElement(By.id("user-name"));

        //get Form

        ele1.click();
        ele1.sendKeys("email.com");
        ele1.getText();


        driver.close();
        ele2.isDisplayed();
        ele2.click();
    }

}
