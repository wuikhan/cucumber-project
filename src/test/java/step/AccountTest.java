package step;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class AccountTest extends BaseClass {

	@Then("^I click the \"([^\"]*)\" tab$")
	public void I_click_the_tab(String menu) {
		driver.findElement(By.xpath("//a[@title='" + menu + " Tab']")).click();
	}

	@Then("^I click the \"([^\"]*)\" button$")
	public void I_click_the_button(String buttonName) {
		driver.findElement(By.xpath("//input[@title='" + buttonName + "']")).click();
	}

	@Then("^I enter \"([^\"]*)\" in the account name field$")
	public void I_enter_in_the_account_name_field(String accName) {
		driver.findElement(By.id("acc2")).sendKeys(accName);
	}

	@Then("^I create and save the Account$")
	public void I_create_and_save_the_Account(DataTable accountDetail) throws Throwable {
		List<Map<String, String>> data = accountDetail.asMaps(String.class, String.class);
		for (Map<String, String> value : data) {
			driver.findElement(By.linkText("Accounts")).click();
			driver.findElement(By.xpath("//input[@name='new']")).click();
			driver.findElement(By.id("acc2")).sendKeys(value.get("Account Name"));
			driver.findElement(By.id("acc5")).sendKeys(value.get("Account Number"));
			driver.findElement(By.id("acc23")).sendKeys(value.get("Account Site"));

			WebElement activeDropDown = driver.findElement(By.id("00N2E00000D7LOy"));
			Select selActive = new Select(activeDropDown);
			selActive.selectByVisibleText(value.get("Active"));

			driver.findElement(By.id("acc8")).sendKeys(value.get("Annual Revenue"));

			WebElement accountSourceDropDown = driver.findElement(By.id("AccountSource"));
			Select selAccSource = new Select(accountSourceDropDown);
			selAccSource.selectByVisibleText(value.get("Account Source"));

			driver.findElement(By.xpath("//input[@name='save']")).click();
		}
	}

	@Then("^I should see the following values for the \"([^\"]*)\" field$")
	public void I_should_see_the_following_values_for_the_field(String field, DataTable values) throws Throwable {
		WebElement dropDown = driver.findElement(By.id(field));
		Select sel = new Select(dropDown);
		List<WebElement> opt = sel.getOptions();

		List<String> value = values.asList(String.class);

		for (int i = 0; i < value.size(); i++) {
			Assert.assertEquals(value.get(i), opt.get(i).getText());
		}
	}
}
