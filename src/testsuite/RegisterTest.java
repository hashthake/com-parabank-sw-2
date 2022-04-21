package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Find element for register and click regiser button
        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();
        // Expected message to be displayed
        String expectedMessage = "Signing up is easy!";
        // Actual message elements
        WebElement actualMessageElement = driver.findElement(By.className("title"));
        String actualMessage = actualMessageElement.getText();
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        // Find element for register and click on register button
        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();
        //Enter first name in firstname field
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Hardik12");
        //Enter last name in lastname field
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Thaker12");
        //Enter address in address field
        WebElement custAddress = driver.findElement(By.id("customer.address.street"));
        custAddress.sendKeys("20, Cordin view");
        //Enter cityname in cityname field
        WebElement custCity = driver.findElement(By.id("customer.address.city"));
        custCity.sendKeys("Ahmedabad");
        //Enter state name in state field
        WebElement custState = driver.findElement(By.id("customer.address.state"));
        custState.sendKeys("Gujarat");
        //Enter postcode in pastcode field
        WebElement custZipCode = driver.findElement(By.id("customer.address.zipCode"));
        custZipCode.sendKeys("380015");
        //Enter phonenumber in phonenumber field
        WebElement custPhoneNumber = driver.findElement(By.id("customer.phoneNumber"));
        custPhoneNumber.sendKeys("9825098250");
        //Enter ssn number in ssn number field
        WebElement custSsn = driver.findElement(By.id("customer.ssn"));
        custSsn.sendKeys("1234");
        // chooose username by entering username
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("Hard12345");
        //select password by entering password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("Thaker1234");
        //Repeat entered password
        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("Thaker1234");
            //below xpath i created, its passing the test but give error on actual site page
      //  WebElement submit = driver.findElement(By.xpath("//input[@class='button']"));
        WebElement submit = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        submit.click();
        //expected message to be displayed
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        //find element for actual message
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        //validated expected and actual message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
