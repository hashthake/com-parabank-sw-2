package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter details for username
        WebElement userName = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"));
        userName.sendKeys("H123");
        //Enter details for password
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("T123");
        //Click on login button
        WebElement logIn = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logIn.click();

        //Review expected message with actual message
        String expectedMessage = "Accounts Overview";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actalMessage = actualMessageElement.getText();
        //Validate expected message and actual message
        Assert.assertEquals(expectedMessage, actalMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter details for username
        WebElement userName = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"));
        userName.sendKeys("hardik123");
        //Enter details for password
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("thaker123");
        //Click on login button
        WebElement logIn = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logIn.click();

        //Review expected message with actual message
        String expectedMessage = "The username and password could not be verified.";
        //Webelement for actual message
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actalMessage = actualMessageElement.getText();
        //Validate expected message and actual message
        Assert.assertEquals(expectedMessage, actalMessage);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter details for username
        WebElement userName = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"));
        userName.sendKeys("H123");
        //Enter details for password
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("T123");
        //Click on login button
        WebElement logIn = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logIn.click();
        //Click on logout button
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOut.click();

        //After logout verify message "Customer Login" on home page
        String expectedMessage = "Customer Login";
        //Webelement for actual message
        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        //Validate expected and actual message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
