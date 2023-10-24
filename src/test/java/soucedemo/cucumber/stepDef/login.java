package soucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Page Login Saucedemo")
    public void page_login_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

    //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[@id='root']//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }


    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click the login button")
    public void clickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user in on dashboard page")
    public void userInOnDashboardPage() {
        //Assert produk setelah login
       driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
//        String produk = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
//        Assert.assertEquals(produk, "Products");

    }

//    @Then("Page Login Saucedemo")
//    public void pageLoginSaucedemo() {
//    String landingPage = driver.findElement(By.xpath("//div[@id='root']//div[@class='login_logo']")).getText();
//        Assert.assertEquals(landingPage,"Swag Labs");
//        driver.close();}

    @And("Input Invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        //Assert error
        String errorLogin = driver.findElement(By.xpath("//div[@id='login_button_container']//form//h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @When("click burger menu")
    public void clickBurgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("click logout")
    public void clickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
        //driver.close();

    }
    //Assertion
    @Then("user on landing page")
    public void userOnLandingPage(){
        String loginPageAssert = driver.findElement(By.xpath("//div[@id='root']//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //driver.close();

    }

    @When("User click the sort menu")
    public void userClickTheSortMenu() {
        driver.findElement(By.xpath("/html//div[@id='header_container']//select[@class='product_sort_container']")).click();
    }
    @And("User selects price low to high")
    public void userSelectsPriceLowToHigh() {
        driver.findElement(By.cssSelector("[value='lohi']")).click();
    }

    @Then("showing the sorted Swag Labs page")
    public void showingTheSortedSwagLabsPage() {
        String lowPrice = driver.findElement(By.cssSelector(".inventory_list .inventory_item:nth-of-type(1) .inventory_item_name")).getText();
        Assert.assertEquals(lowPrice, "Sauce Labs Onesie");
        driver.close();
    }

    @When("click add product to cart")
    public void clickAddProductToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("click the cart icon")
    public void clickTheCartIcon(){
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    @Then("user see detail product in cart page")
    public void userSeeDetailProductInCartPage(){
        String cart = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(cart, "Your Cart");
        //driver.close();
    }





    @When("I input (.*) as username$")
    public void i_input_standard_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @And("I input (.*) as password$")
    public void user_input_secret_sauce_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I verify (.*) login result$")
    public void iVerifyStatusLoginResult(String status) {
        //Assertion
        if (status.equals("succes")) { //jika succes
            String produk = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
            Assert.assertEquals(produk, "Products");
        }else{ //jika failed
            String errorLogin = driver.findElement(By.xpath("//div[@id='login_button_container']//form//h3")).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        }
        //driver.close();
    }


    @When("click checkout")
    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("User see information product page")
    public void userSeeInformationProductPage() {
        String info = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(info, "Checkout: Your Information");
    }

    @When("Input First Name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Nafidhatul");
    }

    @And("Input Last Name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Ula");
    }

    @And("Input postal code form")
    public void inputPostalCodeForm() {
        driver.findElement(By.id("postal-code")).sendKeys("78513");
    }

    @And("click continue")
    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User see checkout overview page")
    public void userSeeCheckoutOverviewPage() {
        String overview = driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText();
        Assert.assertEquals(overview, "Checkout: Overview");
    }

    @And("click finish")
    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("showing Page Checkout complete")
    public void showingPageCheckoutComplete() {
        String complete = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals(complete, "Thank you for your order!");
        driver.close();
    }


    @When("I Input (.*) as firstName$")
    public void i_input_first_name_as_firstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    @And("I Input (.*) as lastName$")
    public void i_input_last_name_as_lastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    @And("I Input (.*) as postalCode$")
    public void i_input_postal_code_as_postalCode(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }
}
