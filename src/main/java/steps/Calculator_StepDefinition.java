package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Calculator_Page;
import runner.Test_Runner;
import org.openqa.selenium.*;
import org.testng.Assert;
import helpers.Browser_Helper;

public class Calculator_StepDefinition {

	public WebDriver driver;
	public Calculator_Page _calculator_Page;
	
	public Calculator_StepDefinition()
	{
		this.driver = Browser_Helper.getDriver();
		_calculator_Page = new Calculator_Page();
	}
	
	@Given("the user navigates to the Google home page")
	public void the_user_navigates_to_the_Google_home_page() {		
	    driver.get(Test_Runner.baseUrl);
	}
	
	@Given("the user searches for {string}")
	public void the_user_searches_for(String keyword) throws InterruptedException {
		_calculator_Page.searchGoogle(keyword);
	}
	
	@When("the user enters {string}")
	public void the_user_enters(String number) {
		_calculator_Page.enterNumber(number);
	}
	
	@When("the user selects {string}")
	public void the_user_selects(String operation) {
		_calculator_Page.enterSign(operation);
	}
	
	@When("the user confirms the calculation again")
	@When("the user confirms the calculation")
	public void the_user_confirms_the_calculation()
	{
		_calculator_Page.confirm();
	}
	
	@When("user stops")
	public void user_stops() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	@Then("{string} is displayed in result pane")
	public void is_displayed_in_result_pane(String expectedAnswer) {
		Assert.assertEquals(_calculator_Page.getAnswer(),expectedAnswer, "Incorrect Answer");
	}
	
	@When("the user clears all")
	public void the_user_clears_all()
	{
		_calculator_Page.clearAll();
	}
	
	@When("the user clears entry")
	public void the_user_clears_entry()
	{
		_calculator_Page.clearEntry();
	}
}