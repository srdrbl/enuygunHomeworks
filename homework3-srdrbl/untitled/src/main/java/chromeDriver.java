import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Path;
import java.nio.file.Paths;

public class chromeDriver {
    public static void main(String[] args) {

        Path resourceDirectory = Paths.get("src", "main", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        //driver path given
        System.setProperty("webdriver.chrome.driver", "D:\\java uygulamaları\\chrome\\src\\main\\resources\\Binary\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        // chrome profile path given
        String profilePath = "C:\\Users\\srdrb\\AppData\\Local\\Google\\Chrome\\User Data";
        options.addArguments("user-data-dir=" + profilePath);
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        //specified which site will be opened
        String url = "https://www.enuygun.com/";
        //site opened
        driver.get(url);
    }
}