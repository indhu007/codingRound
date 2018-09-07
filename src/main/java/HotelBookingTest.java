import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    public WebDriver driver;
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
    	
        try {
			setDriverPath();
			HotelBookingTest HotelBooking = PageFactory.initElements(driver, HotelBookingTest.class);  // Initialized the page factory element

			driver.get("https://www.cleartrip.com/");
			HotelBooking.hotelLink.click();

			HotelBooking.localityTextBox.sendKeys("Indiranagar, Bangalore");

			new Select(HotelBooking.travellerSelection).selectByVisibleText("1 room, 2 adults");
			HotelBooking.searchButton.click();

			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            driver = new ChromeDriver();
        }
    }

}
