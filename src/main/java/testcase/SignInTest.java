package testcase;

import com.sun.javafx.PlatformUtil;
import core.framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends framework {


    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        try {
			driver.get("https://www.cleartrip.com/");

			waitFor(2000);

			driver.findElement(By.linkText("Your trips")).click();
			driver.findElement(By.id("SignIn")).click();
			driver.switchTo().frame("modal_window"); //Switch to the IFrame of modal window
			
			driver.findElement(By.id("signInButton")).click();

			String errors1 = driver.findElement(By.id("errors1")).getText();
			Assert.assertTrue(errors1.contains("There were errors in your submission"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



}
