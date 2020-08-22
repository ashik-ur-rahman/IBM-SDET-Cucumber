package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Crm {

//	WebDriver driver = new FirefoxDriver();	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	
	@Given("^the Alchemy CRM site is opened$")
	public void the_Alchemy_CRM_site_is_opened() throws Throwable {
	    driver.get("https://alchemy.hguy.co/crm/");
	    driver.manage().window().maximize();
	}

	@When("^login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_with_username_and_password(String username, String password) throws Throwable {
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("username_password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='loginform']//*[@id='bigbutton']")).click();
	}

	List<WebElement> dashlet;
	int count;
	@Then("^count the number of Dashlets on the homepage$")
	public void count_the_number_of_Dashlets_on_the_homepage() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[@class='dashboard']"))).isDisplayed();
		dashlet = driver.findElements(By.xpath("//td[@class='dashlet-title']/h3/span[2]"));
	    count = dashlet.size();
	    
	}

	@Then("^print the number and title of each Dashlet$")
	public void print_the_number_and_title_of_each_Dashlet() throws Throwable {
	    System.out.println("Number of Dashlets : " +count);
	    
	    for (int i = 0; i < dashlet.size(); i++) {
	    	String Dashlets = dashlet.get(i).getText();
	    	System.out.println(Dashlets);
		}
	}

	
//	------ Start of creation of Lead ----	
	
	Actions actions = new Actions(driver);
	@Then("^navigate to Sales, Leads, Create Lead$")
	public void navigate_to_Sales_Leads_Create_Lead() throws Throwable {
	    WebElement Sales = driver.findElement(By.xpath("//div[@id='toolbar']/ul/li[2]/span"));
	    actions.moveToElement(Sales).perform();
	    driver.findElement(By.id("moduleTab_9_Leads")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Create Lead')]"))).click();
	}

	String fullName;
	@Then("^enter First Name \"(.*)\", Last Name \"(.*)\", Country \"(.*)\"$")
	public void create_lead_accounts(String fname, String lname, String country) throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"first_name\"]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"first_name\"]"))).sendKeys(fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		driver.findElement(By.id("primary_address_country")).sendKeys(country);
		fullName = fname +" "+ lname;
	}

	@Then("^click Save$")
	public void click_Save() throws Throwable {
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/input[@title='Save']"))).click();
	    WebElement saveLead = driver.findElement(By.xpath("//div/input[@title='Save']"));
	    JavascriptExecutor jseLead = (JavascriptExecutor)driver;
	    jseLead.executeScript("arguments[0].click()", saveLead);
	}

	@Then("^navigate to the View Leads page to see results$")
	public void navigate_to_the_View_Leads_page_to_see_results() throws Throwable {
		driver.findElement(By.xpath("//div[contains(text(),'View Leads')]")).click();
		String Name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='list-view-rounded-corners']/table/tbody/tr/td[3]/b/a"))).getText();
		System.out.println(Name);
		assertEquals(fullName, Name);
	}	
	
//	------ End of creation of Lead ----		
	
//	------ Start of Scheduling Meeting ----
	

	@Then("^Navigate to Activities -> Meetings -> Schedule a Meeting$")
	public void navigate_to_Activities_Meetings_Schedule_a_Meeting() throws Throwable {
	    WebElement activities = driver.findElement(By.xpath("//div[@id='toolbar']/ul/li[5]/span[2]"));
	    actions.moveToElement(activities).perform();
	    driver.findElement(By.id("moduleTab_9_Meetings")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Schedule Meeting')]"))).click();		
	}
	
	String meeting = "Knowledge Sharing Session";
	@Then("^Enter the details of the meeting$")
	public void enter_the_details_of_the_meeting() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Subject')]//following-sibling::div/input"))).sendKeys(meeting);
		Select startHour = new Select(driver.findElement(By.id("date_start_hours")));
		Select startMins = new Select(driver.findElement(By.id("date_start_minutes")));
		Select endHour = new Select(driver.findElement(By.id("date_end_hours")));
		Select endMins = new Select(driver.findElement(By.id("date_end_minutes")));
		startHour.selectByVisibleText("16");
		startMins.selectByVisibleText("00");
		endHour.selectByVisibleText("17");
		endMins.selectByVisibleText("00");	
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(meeting);
	}

	@Then("^Search for members and add them to the meeting$")
	public void search_for_members_and_add_them_to_the_meeting(List<String> fname) throws Throwable {
		
		for(String name : fname) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='search_first_name']"))).isEnabled();
			driver.findElement(By.xpath("//*[@id='search_first_name']")).sendKeys(name);
			driver.findElement(By.id("invitees_search")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='scheduler']/div[3]/table/tbody/tr[2]/td[5]/input"))).isEnabled();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='scheduler']/div[3]/table/tbody/tr[2]/td[5]/input"))).click();
			driver.findElement(By.xpath("//*[@id='search_first_name']")).clear();	
		}
	}

	@Then("^Save Meeting$")
	public void save_meeting() throws Throwable {
	    WebElement saveMeeting = driver.findElement(By.xpath("//form[@id='EditView']/table/tbody/tr/td/div/input[1]"));
	    JavascriptExecutor jseMeeting = (JavascriptExecutor)driver;
	    jseMeeting.executeScript("arguments[0].click()", saveMeeting);
	}

	@Then("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void navigate_to_View_Meetings_page_and_confirm_creation_of_the_meeting() throws Throwable {
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'View Meetings')]"))).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[4]/b/a"))).isDisplayed();

	    String meetingName = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[4]/b/a")).getText();
	    
	    assertEquals(meetingName,meeting);
	}

//	------ End of Scheduling Meeting ----
	
//	------ Start of Creation of Product ----
	
	@Then("^Navigate to All -> Products-> Create Product$")
	public void navigate_to_All_Products_Create_Product() throws Throwable {
	    WebElement allMenu = driver.findElement(By.xpath("//div[@id='toolbar']/ul/li[7]/span[2]/a"));
	    WebElement productsMenu = driver.findElement(By.xpath("//a[@id='grouptab_5']//following-sibling::ul/li[25]/a[contains(text(),'Products')]"));
	    actions.moveToElement(allMenu).perform();
	    actions.moveToElement(productsMenu).perform();
	    productsMenu.click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Create Product')]"))).click();		

	}
	
	String Product;
	@Then("^enter Product Name \"(.*)\" and Prduct Price \"(.*)\"details of the product$")
	public void enter_details_of_the_product(String pName, String pPrice) throws Throwable {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Product Name:')]//following-sibling::div/input"))).sendKeys(pName);
			driver.findElement(By.xpath("//div[contains(text(),'Price:')]//following-sibling::div/input")).sendKeys(pPrice);
			Product = pName;
	}

	@Then("^save Product$")
	public void save_Product() throws Throwable {
		WebElement saveProduct = driver.findElement(By.xpath("//*[@id='SAVE']"));
		JavascriptExecutor jseProduct = (JavascriptExecutor)driver;
		jseProduct.executeScript("arguments[0].click()",saveProduct);
	}
	

	@Then("^navigate to View Products page to see all products listed$")
	public void View_Products_listed() throws Throwable {
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'View Products')]"))).click();						
	    String name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[3]/b/a"))).getText();

	    assertEquals(name,Product);
	
	}
	
	
//	------ End of Creation of Product ----
	
	
	@And("^Close browser$")
	public void Close_the_browser() throws Throwable {
		driver.quit();
	}	
	
	
	
	
	
}
