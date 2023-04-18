package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find the username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        //Type the email address to email field element
        usernameField.sendKeys("standard_user");
        //Find the password field element and send password to password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login btn element and click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //Verify the text "PRODUCTS";
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find the username field
        WebElement emailField = driver.findElement(By.id("user-name"));
        //Type the email address to email field element
        emailField.sendKeys("standard_user");
        //Find the password field element and send password to password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login btn element and click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualNumber = number.size();
        int expectedNumber = 6;
        Assert.assertEquals("6 product not displayed", expectedNumber, actualNumber);

    }
    @After
    public void tearDown() {//closing the browser
        driver.close();
    }
}
