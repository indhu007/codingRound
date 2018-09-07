package testcase;

import com.sun.javafx.PlatformUtil;
import core.framework;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Reporter;

import java.util.List;

public class FlightBookingTest extends framework {

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		driver.get("https://www.cleartrip.com/");
		Reporter.log("Navigating to clear trip", true);

		waitFor(2000);

		driver.findElement(By.id("OneWay")).click();
		Reporter.log("Select One Way trip", true);

		driver.findElement(By.id("FromTag")).clear();
		Reporter.log("Clear From place", true);
		driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
		Reporter.log("Enter From place", true);

		// wait for the auto complete options to appear for the origin

		waitFor(4000);
		try {
			List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
			originOptions.get(0).click();
			Reporter.log("Select the first place", true);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not Loaded" + e);
		} catch (IndexOutOfBoundsException ae) {
			System.out.println("Element is not Loaded" + ae);
		}

		driver.findElement(By.id("ToTag")).clear(); // modified the xpath as xpath is case-sensitive
		Reporter.log("Clear To place", true);
		driver.findElement(By.id("ToTag")).sendKeys("Delhi");
		Reporter.log("Enter To place", true);

		waitFor(4000);
		// select the first item from the destination auto complete list
		try {
			List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
			destinationOptions.get(0).click();
			Reporter.log("Select the first place", true);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not Loaded" + e);
		} catch (IndexOutOfBoundsException ae) {
			System.out.println("Element is not Loaded" + ae);
		}

		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
		Reporter.log("Select date of travel", true);

		// all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();
		Reporter.log("Click on the Search button", true);

		waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));
		Reporter.log("Assert the landing page", true);

	}

}
