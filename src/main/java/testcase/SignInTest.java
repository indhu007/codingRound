package testcase;

import com.sun.javafx.PlatformUtil;
import core.framework;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SignInTest extends framework {


    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        try {
			driver.get("https://www.cleartrip.com/");
			Reporter.log("Navigating to clear trip", true);

			waitFor(2000);

			driver.findElement(By.linkText("Your trips")).click();
			Reporter.log("Click on Your trips", true);
			driver.findElement(By.id("SignIn")).click();
			Reporter.log("Click the sign-in button", true);
			driver.switchTo().frame("modal_window"); //Switch to the IFrame of modal window
			Reporter.log("Switch to IFrame", true);
			
			driver.findElement(By.id("signInButton")).click();
			Reporter.log("Click on Sign In", true);

			String errors1 = driver.findElement(By.id("errors1")).getText();
			Assert.assertTrue(errors1.contains("There were errors in your submission"));
			Reporter.log("Assert the error", true);

		} catch (NoSuchElementException e) {
			
			System.out.println("Element is not Loaded" + e);
		}
    }



}
