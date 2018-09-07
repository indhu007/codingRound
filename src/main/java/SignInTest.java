import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver;

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	

        try {
			setDriverPath();

			driver.get("https://www.cleartrip.com/");
			waitFor(2000);

			driver.findElement(By.linkText("Your trips")).click();
			driver.findElement(By.id("SignIn")).click();
			driver.switchTo().frame("modal_window"); //Switch to the IFrame of modal window
			
			driver.findElement(By.id("signInButton")).click();

			String errors1 = driver.findElement(By.id("errors1")).getText();
			Assert.assertTrue(errors1.contains("There were errors in your submission"));
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indhu\\git\\codingRound\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            driver = new ChromeDriver();
        }
    }


}
