package EnuygunPages;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class HomePage extends BasePage{

    String baseUrl;

    // * page constructor
    public HomePage(){
        this.baseUrl = "https://www.enuygun.com";
    }


    By flightSearch = By.id("OriginInput");

    By listFlightSearch = By.xpath("//*/ul[@role='listbox']/li");


}
