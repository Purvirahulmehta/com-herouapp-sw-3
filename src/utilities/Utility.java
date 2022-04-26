package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by){
        WebElement element=driver.findElement(by);
        element.click();
    }
    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    //This method will send text on element
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    public void switchToAlert(){
        driver.switchTo().alert().accept();
    }
    //This method will accept the alret
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    //This method will select the option by visible text
          public void selectByVisibleTextFromDropDown(By by,String text){
            WebElement dropDown=driver.findElement(by);
            Select select=new Select(driver.findElement(by));
            select.selectByValue(text);

    }
    //Array list
    public List<WebElement> listOfWebElementList(By by){
       return driver.findElements(by);
    }
    //mouse hoover
    public void mousehoover(By by){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }
}

