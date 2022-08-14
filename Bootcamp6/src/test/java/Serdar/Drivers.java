package Serdar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Drivers {

    // * webdriver variable for all drivers
    public WebDriver driver;
    public WebDriverWait wait;

    public Drivers(){

    }

    // * this method for opening url
    // * All driver class using this method
    // ! add try catch
    public void open(String url){
        this.driver.get(url);
    }

    // * click method
    public void clickById(String id){
        this.driver.findElement(By.id(id)).click();
    }
    // * It is used by overwriting inside driver classes.
    public abstract void setupDriver();

    // ! add try catch
    public WebElement getElement(By elementName){
        return driver.findElement(elementName);
    }

    public List<WebElement> getElements(By elementName){
        return driver.findElements(elementName);
    }
}
