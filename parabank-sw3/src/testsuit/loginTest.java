package testsuit;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    //2.verifyTheErrorMessage
    //* Enter invalid username
    //* Enter invalid password
    //* Click on Login button
    //* Verify the error message ‘The username and password could not be verified.’
    public void verifyTheErrorMessage(){
        WebElement uName= driver.findElement(By.name("username"));
        uName.sendKeys("zara");
        WebElement pW=driver.findElement(By.name("password"));
        pW.sendKeys("123@123@123");
        driver.findElement(By.xpath("//form[@name='login']/div[3]/input")).click();
        String actualText = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expectedText = "An internal error has occurred and has been logged.";
        Assert.assertEquals(actualText,expectedText);

    }
}
