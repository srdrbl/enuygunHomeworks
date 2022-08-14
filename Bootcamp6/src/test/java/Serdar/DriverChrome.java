package Serdar;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverChrome extends Drivers {

    // * default constructor for driver
    public DriverChrome() {
        setupDriver();
        this.driver = new ChromeDriver();
    }

    // * constructor with options
    public DriverChrome(String[] args){
        setupDriver();
        this.driver = new ChromeDriver(optionsChrome(args));
    }

    // * set options
    public ChromeOptions optionsChrome(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(args);
        return options;
    }

    // * setup driver and driver path
    @Override
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", FindPath.driverPath(DriverType.CHROME));
    }


}
