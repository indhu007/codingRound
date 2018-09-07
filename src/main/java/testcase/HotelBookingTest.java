package testcase;

import core.framework;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObject.PageObject_HotelBooking;

public class HotelBookingTest extends framework {

	@Test
	public void shouldBeAbleToSearchForHotels() {

		try {

			// Creating a pageobject for hotelbooking page
			PageObject_HotelBooking hotelbookobject = new PageObject_HotelBooking(driver);
			driver.get("https://www.cleartrip.com/");
			Reporter.log("Navigating to clear trip", true);

			hotelbookobject.hotelLink.click();
			Reporter.log("Click on Hotels Link", true);

			hotelbookobject.localityTextBox.sendKeys("Indiranagar, Bangalore");
			Reporter.log("Enter the Location", true);

			new Select(hotelbookobject.travellerSelection).selectByVisibleText("1 room, 2 adults");
			hotelbookobject.searchButton.click();
			Reporter.log("Click on Search Button", true);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
