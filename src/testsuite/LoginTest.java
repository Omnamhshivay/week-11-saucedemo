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
    String baseUrl="https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field element
        WebElement userNameField= driver.findElement(By.id("user-name"));
        //send key in to username field
        userNameField.sendKeys("standard_user");
        //find password field element
        WebElement passwordField= driver.findElement(By.id("password"));
        //send key in to password field
        passwordField.sendKeys("secret_sauce");
        // find login element
        WebElement loginField= driver.findElement(By.id("login-button"));
        loginField.click();
        // verify the requirement
        String expectedMessage="PRODUCTS";
        WebElement actualMessageElement= driver.findElement(By.className("title"));
        String actualMessage=actualMessageElement.getText();
        Assert.assertEquals("Product",expectedMessage,actualMessage);
    }
@Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
    //find username field element
    WebElement userNameField= driver.findElement(By.id("user-name"));
    //send key in to username field
    userNameField.sendKeys("standard_user");
    //find password field element
    WebElement passwordField= driver.findElement(By.id("password"));
    //send key in to password field
    passwordField.sendKeys("secret_sauce");
    // find login element
    WebElement loginField= driver.findElement(By.id("login-button"));
    loginField.click();
    // verify the requirement
    List<WebElement>number= driver.findElements(By.xpath("//div[@class='inventory_item']"));
    int actualnumber=number.size();
    int expectednumber= 6;
    Assert.assertEquals("6 product not displayed",expectednumber,actualnumber);

}
@After
    public void close(){
        driver.close();
}

}
