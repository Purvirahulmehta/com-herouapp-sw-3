package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //finding username element
     sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");
         //finding password elemrnt
       sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //finding login button element
  clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        //finding actual message element
        String  actualResult=getTextFromElement(By.xpath("//body/div[2]/div[1]/div[1]/h4[1]"));
        String expectedMessage="Secure Area";
        // //validate actual and expected message
        Assert.assertEquals("Secure Area","Secure Area");
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //finding username element
     sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");
         //finding password element
      sendTextToElement(By.name("password"),"SuperSecretPassword");
         //finding login button element
      clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
         //finding actualmessage element
        String actualResult=getTextFromElement(By.xpath("//div[@id='flash']"));
        String expectedMessage="Your username is invalid!\n" +
                "×";
        //validate actual and expected message
        Assert.assertEquals("unable to navigate", expectedMessage,actualResult);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //finding the username element
       sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");
         //finding the password element
        sendTextToElement(By.name("password"),"SuperSecretPassword");
         //finding login button element
      clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
         //finding the actual message element
         String actualResult=getTextFromElement(By.id("flash"));
        String expectedMessage="Your password is invalid!\n" +
                "×";
        //Validate actual and expected message
        Assert.assertEquals("Unable to login",expectedMessage,actualResult);
    }
}
