package Stepdef;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;

public class Loginfunc {
	WebDriver d;
	@Given("If user is on home page")
	public void if_user_is_on_home_page() {
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
		d.get("http://demo.cyclos.org/ui/home");
		assertTrue(d.findElement(By.xpath("//div[text()='Home']")).isDisplayed());
	}

	@When("Click on login link")
	public void click_on_login_link() {
		d.findElement(By.id("login-link")).click();
	}

	@When("Enter valid credentials")
	public void enter_valid_credentials() throws Exception {
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("demo");
		d.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
		d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		Thread.sleep(2000);
	}

	@Then("Verify the logout link")
	public void verify_the_logout_link() throws Exception {
		assertTrue(d.findElement(By.id("logout-trigger")).isDisplayed());
		Thread.sleep(2000);
		d.quit();
	}
}
