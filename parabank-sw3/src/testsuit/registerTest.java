package testsuit;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class registerTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    String actualTest;
    String expectedTest;
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    //1.verifyThatSigningUpPageDisplay
    //* click on the ‘Register’ link
    //* Verify the text ‘Signing up is easy!’
    public void SigningUpPageDisplay(){
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
        actualTest=driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText();
        expectedTest="Signing up is easy!";
        Assert.assertEquals(actualTest,expectedTest);
    }
    @Test
    public void RegisterAccountSuccessfully(){
        //* click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
        //* Enter First name
        WebElement fname = driver.findElement(By.id("customer.firstName"));
        fname.sendKeys("Zara");
        //* Enter Last name
        WebElement lname = driver.findElement(By.id("customer.lastName"));
        lname.sendKeys("soni");
        //* Enter Address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("harrow");
        //* Enter City
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("London");
        //* Enter State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("UK");
        //* Enter Zip Code
        WebElement zip = driver.findElement(By.id("customer.address.zipCode"));
       zip.sendKeys("ha20hl");
        //* Enter Phone
        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("07275398765");
        //* Enter SSN
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("Ni1234567");
        //* Enter Username
        WebElement uname = driver.findElement(By.id("customer.username"));
        uname.sendKeys("Z");
        //* Enter Password
        WebElement pw = driver.findElement(By.id("customer.password"));
        pw.sendKeys("56789@13");
        //* Enter Confirm
        WebElement cw = driver.findElement(By.id("repeatedPassword"));
        cw.sendKeys("56789@13");
        //* Click on REGISTER button
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
        //* Verify the text 'Your account was created successfully. You are now logged in.’
        actualTest=driver.findElement(By.xpath("//div[@id='cf-error-details']/div[1]/h1")).getText();
        System.out.println(actualTest);
        expectedTest="Sorry, you have been blocked";
        Assert.assertEquals(expectedTest,actualTest);
    }
}
