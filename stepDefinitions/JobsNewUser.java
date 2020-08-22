package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobsNewUser {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);

	@Given("^Browser is opened$")
	public void browser_is_opened() throws Throwable {
		driver.get("https://alchemy.hguy.co/jobs/wp-login.php");
	    driver.manage().window().maximize();
	}

	// Login with root
	@When("^navigate to login page and login with username \"(.*)\" and password \"(.*)\"$")
	public void navigate_to_login_page_and_log_in(String username, String password) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
	}

	@Then("^Clicked on Users$")
	public void clicked_on_Users() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]"))).click();
	}

	// Creating new user -- Start
	
	String user = "ashik01";
	String email = "ashik01@sdet.com";
	@And("^Create a new user$")
	public void create_a_new_user() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a"))).click();
		driver.findElement(By.id("user_login")).sendKeys(user);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[6]/td/button")).click();
		driver.findElement(By.id("pass1")).sendKeys("P@$$word123^&!");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[8]/td/label/input")).click();
		driver.findElement(By.id("createusersub")).click();
	}

	// verify user is created
	@And("^Verify that user is created$")
	public void verify_that_user_is_created() throws Throwable {
		driver.findElement(By.id("user-search-input")).sendKeys(user);
		driver.findElement(By.id("search-submit")).click();
		WebElement userActual = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr[1]/td[1]/strong/a"));
		String name = userActual.getText();
		assertEquals(user, name);
	}
	// Creating new user -- End

	// --- Search and apply for job ---- Start	
	@Given("^Alchemy Jobs site is opened$")
	public void open_jobs_site() throws Throwable {
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@When("^navigated to Jobs page$")
	public void open_jobs_page() {
		driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
	}

	
	@Then("^type in keywords \"(.*)\" to search for jobs$")
	public void keywords_to_search_for_jobs(String keyword) throws Throwable {
		driver.findElement(By.xpath("//*[@id='search_keywords']")).sendKeys(keyword);
		driver.findElement(By.xpath("//div[@class='search_jobs']/div[4]/input[@type='submit']")).click();
	}

	@And("^filter job type to show only Full Time jobs$")
	public void filter_with_Full_Time_jobs() throws Throwable {
//		WebElement e = driver.findElement(By.xpath("//ul[@class='job_types']"));
//		List<WebElement> webl = driver.findElements(By.xpath("//ul[@class='job_types']"));
//		String size = e.;
		for(int i = 1;i<=5;i++) {
//			String jbtype_label = "//ul[@class='job_types']/li["+i+"]/label";
			String jbtype_Checkbx = "//ul[@class='job_types']/li["+i+"]/label/input";
//			String txt = driver.findElement(By.xpath(jbtype_label)).getText();
//			System.out.println(txt);
			if(i!=2) {
				driver.findElement(By.xpath(jbtype_Checkbx)).click();
			}
			else {
				continue;
			}
		}
		
	}

	@And("^find a job listing and click it to see job details$")
	public void find_a_job_listing_and_click_it_to_see_job_details() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article[@id='post-7']/div/div[@class='job_listings']/ul/li/a/div/h3"))).click();;
	}

	@And("^find the title of the job listing and print it$")
	public void title_of_the_job_listing() throws Throwable {
		String s = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='single_job_listing']/div[2]/p"))).getText();
		if (s == "Automation Test Engineer") {
			System.out.println(s);
		}
	}

	@And("^apply for job$")
	public void apply_for_job() throws Throwable {
		driver.findElement(By.xpath("//div[@class='single_job_listing']/div[3]/input[@value='Apply for job']")).click();
	}

	// --- Search and apply for job ---- End

	// --- Post a Job ---- Start

	@When("^navigated to Post a Job page$")
	public void open_post_a_job_page() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']"))).click();
	}

	@And("^clicked on sign in button on post job page$")
	public void sign_in_on_post_job() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	}
	
	
	@Then("^enter apllication email \"(.*)\"$")
	public void enter_apllication_email(String appemail) throws Throwable {
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("application"))).clear(); 
	  driver.findElement(By.id("application")).sendKeys(appemail); 
	  }
	 

	@And("^enter \"(.*)\" and \"(.*)\"$")
	public void enter_jobtitle_jobtype(String jobtitle, String jobtype) throws Throwable {
		driver.findElement(By.id("job_title")).sendKeys(jobtitle);
		Select drpLocation = new Select(driver.findElement(By.id("job_type")));
		drpLocation.selectByVisibleText(jobtype);
	}
	
	@And("^enter location as \"(.*)\"$")
	public void enter_location(String location) throws Throwable {
		driver.findElement(By.id("job_location")).sendKeys(location);		
	}
	
	@And("^enter description as \"(.*)\"$")
	public void enter_description(String desc) throws Throwable {
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.id("tinymce")).sendKeys(desc);
		driver.switchTo().defaultContent();
	}

	@Then("^click on Preview button$")
	public void preview_submit() throws Throwable {
		driver.findElement(By.xpath("//input[@name='submit_job']")).click();
	}

	@And("^click Submit Listing$")
	public void submit_listing() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("job_preview_submit_button"))).click();
	}
	

	@And("^naviagte to Alchemy Jobs > Job listings$")
	public void navigate_to_job_listings() throws Throwable {
		driver.findElement(By.xpath("//li[@id='wp-admin-bar-site-name']/a[@class='ab-item']")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
	}

	@And("^approve job listing for job title \"(.*)\"$")
	public void post_search_jobs(String jobtitle) throws Throwable {
		driver.findElement(By.xpath("//input[@id='post-search-input']")).sendKeys(jobtitle);
		driver.findElement(By.xpath("//input[@id='search-submit']")).click();
		String job_title = driver.findElement(By.xpath("//tbody[@id='the-list']/tr[1]/td/div/a")).getText();
		System.out.println("job_title:"+job_title+":");
		System.out.println("jobtitle:"+jobtitle+":");
		driver.findElement(By.xpath("//tbody[@id='the-list']/tr[1]/td[9]/div/a")).click();
	}
	
	@And("^opened Jobs page$")
	public void jobs_page() throws Throwable {
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
	}

	@And("^job \"(.*)\" is listed on jobs page$")
	public void job_is_listed_on_jobs_page(String jobtitle) throws Throwable {
		String job = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article[@id='post-7']/div/div[@class='job_listings']/ul/li/a/div/h3"))).getText();
		assertEquals(jobtitle, job);
	}

// --- Post a Job ---- End 	


	@And("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}
