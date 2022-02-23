package stepDefinition;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeLoanTestSteps {

	private static WebDriver driver = null;
	@Given("Navigate to home loan calculator")
	public void navigate_to_home_loan_calculator() {

		//Initialize the firefox
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		// Maximize current window
		driver.manage().window().maximize();

		// Navigate to a website
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
				
    	

	}
	

	@Given("Enter the person details in home loan calculator")
	public void enter_the_person_details_in_home_loan_calculator() {
		
	    // Select the Application type as single
		driver.findElement(By.id("application_type_single")).click();
		
		// Enter dependants as Zero
		Select Dependantsop = new Select(driver.findElement(By.xpath(".//*[@title='Number of dependants']")));
		Dependantsop.selectByIndex(0);
		
		// Select the reason for Property you like to buy as "Home to live in"
		driver.findElement(By.id("borrow_type_home")).click();
		
		// Enter your annual income as "$80,000"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q2q1']")).sendKeys("80000");
		
		// Enter your annual other income as "$10,000"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q2q2']")).sendKeys("10000");
		
		// Enter your monthly living expenses as "$500"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q3q1']")).sendKeys("500");
		
		// Enter your current home loan monthly repayments as "$0"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q3q2']")).sendKeys("0");
		
		// Enter your other loan monthly repayments as "$100"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q3q3']")).sendKeys("100");
		
		// Enter your other monthly commitments as "$0"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q3q4']")).sendKeys("0");
		
		// Enter your total credit card limits as "$10,000"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q3q5']")).sendKeys("10000");
	}
	@Then("Verify that borrowing estimate is displayed as {string}")
	public void verify_that_borrowing_estimate_is_displayed_as(String string)  throws InterruptedException {
		
		// Select the calculate button 
		driver.findElement(By.id("btnBorrowCalculater")).click();		
		Thread.sleep(1000);
		
	    // Verify that borrowing estimate is displayed as "$479,000"
		String Actual_borrowing_limit = driver.findElement(By.id("borrowResultTextAmount")).getText();
		
		System.out.println("Actual_borrowing_limit"+Actual_borrowing_limit);
		
		SoftAssertions Assert = new SoftAssertions();
		
		Assert.assertThat(Actual_borrowing_limit).contains("$482,000");
		
		// Close the browser
		driver.quit();

		Assert.assertAll();
		
		
	}

	
	@Given("Click the start over button")
	public void click_the_start_over_button() throws InterruptedException {
	    // click the start over button
		driver.findElement(By.className("start-over")).click();		
		Thread.sleep(1000);
	}
	@Then("Verify that clicking start over button clears the form")
	public void verify_that_clicking_start_over_button_clears_the_form() throws InterruptedException {
		SoftAssertions AP_Assert = new SoftAssertions();
		
		// Read the Application type
		String Actual_Application_Type = driver.findElement(By.xpath(".//*[@for='application_type_single']//parent::li")).getAttribute("class");
		System.out.println("Actual_Application_Type "+Actual_Application_Type);
		AP_Assert.assertThat(Actual_Application_Type).contains("selected");
		
		// Read the no of dependants
		Select Dependantsop = new Select(driver.findElement(By.xpath(".//*[@title='Number of dependants']")));
		WebElement drop = Dependantsop.getFirstSelectedOption();
		String Actual_Dependent = drop.getText();
		System.out.println("Actual_Dependent "+Actual_Dependent);
		AP_Assert.assertThat(Actual_Dependent).contains("0");
		
		
		
		// Read the reason for Property you like to buy
		String Actual_Reason = driver.findElement(By.xpath(".//*[@for='borrow_type_home']//parent::li")).getAttribute("class");
		System.out.println("Actual_Reason "+Actual_Reason);
		AP_Assert.assertThat(Actual_Reason).contains("selected");

		// Read annual income
		String Actual_Annual_Income = driver.findElement(By.xpath(".//*[@aria-labelledby='q2q1']")).getAttribute("value");
		System.out.println("Actual_Annual_Income "+Actual_Annual_Income);
		AP_Assert.assertThat(Actual_Annual_Income).contains("0");

		// Read other annual income	
		String Actual_Annual_Other_Income = driver.findElement(By.xpath(".//*[@aria-labelledby='q2q2']")).getAttribute("value");
		System.out.println("Actual_Annual_Other_Income"+Actual_Annual_Other_Income);
		AP_Assert.assertThat(Actual_Annual_Other_Income).contains("0");

		// Read monthly living expenses
		String Actual_Monthly_Living_Expenses =  driver.findElement(By.xpath(".//*[@aria-labelledby='q3q1']")).getAttribute("value");
		System.out.println("Actual_Monthly_Living_Expenses"+Actual_Monthly_Living_Expenses);
		AP_Assert.assertThat(Actual_Monthly_Living_Expenses).contains("0");

		// Read current home loan monthly repayments
		String Actual_Home_Loan_Monthly_Repayments = driver.findElement(By.xpath(".//*[@aria-labelledby='q3q2']")).getAttribute("value");
		System.out.println("Actual_Home_Loan_Monthly_Repayments"+Actual_Home_Loan_Monthly_Repayments);
		AP_Assert.assertThat(Actual_Home_Loan_Monthly_Repayments).contains("0");

		// Read other loan monthly repayments 
		String Actual_Other_Loan_Monthly_Repayments = driver.findElement(By.xpath(".//*[@aria-labelledby='q3q3']")).getAttribute("value");
		System.out.println("Actual_Other_Loan_Monthly_Repayments"+Actual_Other_Loan_Monthly_Repayments);
		AP_Assert.assertThat(Actual_Other_Loan_Monthly_Repayments).contains("0");

		// Read other monthly commitments
		String Actual_other_monthly_commitments = driver.findElement(By.xpath(".//*[@aria-labelledby='q3q4']")).getAttribute("value");
		System.out.println("Actual_other_monthly_commitments"+Actual_other_monthly_commitments);
		AP_Assert.assertThat(Actual_other_monthly_commitments).contains("0");

		// Read total credit card limit
		String Actual_total_credit_card_limits = driver.findElement(By.xpath(".//*[@aria-labelledby='q3q5']")).getAttribute("value");
		System.out.println("Actual_total_credit_card_limits"+Actual_total_credit_card_limits);
		AP_Assert.assertThat(Actual_total_credit_card_limits).contains("0");
		
		

		// Close the browser
		driver.quit();

		AP_Assert.assertAll();
		
	}

	@Given("Enter the person living expenses as one in home loan calculator and Leave all other fields as zero")
	public void enter_the_person_living_expenses_as_one_in_home_loan_calculator_and_leave_all_other_fields_as_zero() {
		// Enter your monthly living expenses as "$1"
		driver.findElement(By.xpath(".//*[@aria-labelledby='q3q1']")).sendKeys("1");
	}

	
	@Given("Click the {string} button")
	public void click_the_button(String string) throws InterruptedException {
		
		// Select the work out how much i could borrow button
		driver.findElement(By.id("btnBorrowCalculater")).click();
		Thread.sleep(1000);
		
	}
	@Then("Verify that error message is displayed in home loan calculator upon entering value only for living expenses and leaving all other fields as zero")
	public void verify_that_error_message_is_displayed_in_home_loan_calculator_upon_entering_value_only_for_living_expenses_and_leaving_all_other_fields_as_zero() {
		//Verify that error message is displayed in home loan calculator upon entering value only for living expenses and leaving all other fields as zero
		String Actual_error_message = driver.findElement(By.xpath(".//*[@class='borrow__error__text']")).getText();
		System.out.println("Actual_error_message "+Actual_error_message);
		
		SoftAssertions ER_Assert = new SoftAssertions();
		ER_Assert.assertThat(Actual_error_message).contains("Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.");
		
		// Close the browser
		driver.quit();

		ER_Assert.assertAll();
		
	}




}
