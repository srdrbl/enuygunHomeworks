package Serdar;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverEdge extends Drivers{

    // * default constructor for driver
    public DriverEdge() {
        setupDriver();
        this.driver = new EdgeDriver();
    }

    // * constructor with options
    public DriverEdge(String[] args){
        setupDriver();
        this.driver = new EdgeDriver(optionsEdge(args));
    }

    // * set options
    public EdgeOptions optionsEdge(String[] args){
        EdgeOptions options = new EdgeOptions();
        options.addArguments(args);
        return options;
    }

    // * setup driver and driver path
    @Override
    public void setupDriver(){
        System.setProperty("webdriver.edge.driver", FindPath.driverPath(DriverType.EDGE));
    }


}
