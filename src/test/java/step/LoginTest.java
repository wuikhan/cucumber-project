package step;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginTest extends BaseClass{
	
	@Given("^I open the browser$")
	public void i_open_the_browser() {
		
		String osname = System.getProperty("os.name");
		System.out.println(osname);
		
		if(osname.equalsIgnoreCase("Windows 10")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/driver/mac/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
	}

	@Given("^I visit the application$") // ken is working on this
	public void i_visit_the_application() {
		driver.get("https://login.salesforce.com");
	}

	@Given("^I enter valid username$") 
	public void i_enter_valid_username() {
		driver.findElement(By.id("username")).sendKeys("test.user@gmail.com.test");
	}

	@Given("^I enter valid password$")
	public void i_enter_valid_password() {
		driver.findElement(By.id("password")).sendKeys("Welcome2");
	}

	@When("^I click the login button$")
	public void i_click_the_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("^I should see the dashboard$")
	public void i_should_see_the_dashboard() {
		boolean homePage = driver.findElement(By.xpath("//a[@title='Home Tab - Selected']")).isDisplayed();
		Assert.assertTrue(homePage);
	}
	
	@Then("^I quit the browser$")
	public void i_quit_the_browser() throws Throwable {
	    driver.quit();
	}

}
