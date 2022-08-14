package TestWebScenarios;

import Api.EnuygunApi;
import EnuygunPages.HomePage;
import Serdar.DriverChrome;
import com.mashape.unirest.http.exceptions.UnirestException;
import model.Root;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchScenarios {

    HomePage homePage;
    DriverChrome driverChrome;
    String keyWord = "ada";
    Root root;

    @BeforeClass
    public void setup(){
        String[] options ={"--start-maximized"
                ,"--disable-notifications"};

        homePage = new HomePage();
        root = new Root();
        driverChrome = new DriverChrome(options);
    }

    @Test(priority = 1)
    public void openEnuygun(){
        driverChrome.open(homePage.getBaseUrl());
    }

    @Test(priority = 2)
    public void searchForKeyword(){

        driverChrome.getElement(homePage.getFlightSearch()).click();

        String tagName = driverChrome.getElement(homePage.getFlightSearch()).getTagName();
        Assert.assertEquals("input", tagName);

        driverChrome.getElement(homePage.getFlightSearch()).sendKeys(keyWord);

        String tagName2 = driverChrome.getElement(homePage.getFlightSearch()).getAttribute("value");
        Assert.assertEquals(keyWord, tagName2);

    }

    @Test(priority = 3)
    public void checkListForSearch() throws UnirestException, IOException{
        List<String> searchFlightLists;

        searchFlightLists = driverChrome.getElements(homePage.getListFlightSearch())
                .stream().map(e->e.getText()).collect(Collectors.toList());

        EnuygunApi api = new EnuygunApi();
        Root[] roots = api.flightTiketFromListByRest("ada");
        List<String> rootsString = root.convertToRootList(roots);

        for (int i = 0; i<rootsString.size(); i++){
            Assert.assertEquals(rootsString.get(i), searchFlightLists.get(i));
        }
    }
}
