package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Hrm {
	WebDriver driver = new FirefoxDriver();
//	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);


	@Given("^OrangeHRM page is opened and login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_to_hrm(String username, String password) throws Throwable {
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	    driver.manage().window().maximize();

	    driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys(username);
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys(password);
		driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();
	}

	// ----------- Start of Job Vacancy  ----------
	
	@When("^navigated to the Recruitment page$")
	public void navigated_to_the_Recruitment_page() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[5]/a/b[contains(text(),'Recruitment')]"))).click();
	}

	@Then("^click on the Vacancies menu item to navigate to the vacancies page$")
	public void Vacancies_menu() throws Throwable {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		driver.findElement(By.xpath("//div[@class='menu']/ul/li[5]/ul/li[2]")).click();
	}

	@Then("^click on the Add button to navigate to the Add Job Vacancy form$")
	public void click_on_the_Add_button_to_navigate_to_the_Add_Job_Vacancy_form() throws Throwable {
		driver.findElement(By.id("btnAdd")).click();
	}
	
	String jobVacancy = "02-ADRDEV";
	String jobtitle = "DevOps Engineer";	
	String hrngmnger = "Ayush Kumar Gupta";
	String noofpos = "04";
	@Then("^Fill out details on Add Job Vacancy form$")
	public void Add_Job_Vacancy_details() throws Throwable {
		Select select = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		select.selectByVisibleText(jobtitle);
		driver.findElement(By.xpath("//input[@id='addJobVacancy_name']")).sendKeys(jobVacancy);
		driver.findElement(By.xpath("//input[@id='addJobVacancy_hiringManager']")).sendKeys(hrngmnger);
		driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys(noofpos);
	}

	@Then("^click the Save button to save the vacancy$")
	public void save_vacancy() throws Throwable {
		driver.findElement(By.xpath("//form[@id='frmAddJobVacancy']/fieldset/p/input[@id='btnSave']")).click();		
	}

	@Then("^verify that vacancy is created$")
	public void verify_vacancy_created() throws Throwable {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
//		WebElement vacancy = driver.findElement(By.xpath("//*[@id='vacancySearch_jobVacancy']"));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='vacancySearch_jobVacancy']"))).isDisplayed();
		Thread.sleep(1500);
		WebElement hiringManager = driver.findElement(By.xpath("//*[@id='vacancySearch_hiringManager']"));
		WebElement status = driver.findElement(By.id("vacancySearch_status"));

		// to overcome stale element error
		for(int i=0; i<=2;i++){
			  try{
					WebElement vacancy = driver.findElement(By.xpath("//*[@id='vacancySearch_jobVacancy']"));
					Select select2 = new Select(vacancy);
					select2.selectByVisibleText(jobVacancy);
			     break;
			  }
			  catch(Exception e){
			     System.out.println(e.getMessage());
			  }
			}		
		Select select3 = new Select(hiringManager);
		select3.selectByVisibleText(hrngmnger);
		Select select4 = new Select(status);
		select4.selectByVisibleText("Active");
		
		driver.findElement(By.id("btnSrch")).click();
		
		String jobVacancyActual = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).getText();
		assertEquals(jobVacancyActual, jobVacancy);
		
	}

// ----------- End of Job Vacancy  ----------
	
// ----------- Start of Add Candidate  ----------
	
	@Then("^click on the Candidates menu item to navigate to the candidates page$")
	public void Candidates_menu() throws Throwable {
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
	}
		
	@Then("^click on the Add button to add candidate information$")
	public void add_candidate_information() throws Throwable {
		driver.findElement(By.id("btnAdd")).click();
	}

	String c_firstName = "Kamta";
	String c_middleName = "Prasad";
	String c_lastName = "Gupta";
	@Then("^fill in the details of the candidate$")
	public void details_of_the_candidate() throws Throwable {
		driver.findElement(By.id("addCandidate_firstName")).sendKeys(c_firstName);
		driver.findElement(By.id("addCandidate_middleName")).sendKeys(c_middleName);
		driver.findElement(By.id("addCandidate_lastName")).sendKeys(c_lastName);
		driver.findElement(By.id("addCandidate_email")).sendKeys("kpg@sdet.com");
		
		Select select = new Select(driver.findElement(By.id("addCandidate_vacancy")));
		select.selectByVisibleText(jobVacancy);
		
	}

	@Then("^upload a resume \\(docx or pdf\\) to the form$")
	public void upload_a_resume() throws Throwable {
		WebElement r = driver.findElement(By.id("addCandidate_resume"));
		r.sendKeys("C:/Users/AshikRahman/Documents/IBM_SDET/BDD/Supporting Files/SDET_Chat_3_August.pdf");
	}

	@Then("^Save Candidate$")
	public void save_candidate() throws Throwable {
		driver.findElement(By.id("btnSave")).click();
	}

	@Then("^navigate back to the Recruitments page to confirm candidate entry$")
	public void confirm_candidate_entry() throws Throwable {
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		String c_name = c_firstName +" "+ c_middleName +" "+ c_lastName;
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(c_name);
		WebElement vacancy = driver.findElement(By.id("candidateSearch_jobVacancy"));
		
		Select select1 = new Select(vacancy);
		select1.selectByVisibleText(jobVacancy);
		
		driver.findElement(By.id("btnSrch")).click();
		
		String candidate = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]/a")).getText();
		assertEquals(candidate, c_name);

	}

// ----------- End of Add Candidate  ----------

// -------- Add Multiple Employee - Start ---------	


	@When("^PIM option is clicked from the menu$")
	public void pim_option_is_clicked_from_the_menu() throws Throwable {
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu']/ul/li[2]"))).click();
	    driver.findElement(By.id("menu_pim_viewPimModule")).click();
	}


	@Then("^click Add button to add a new Employee$")
	public void click_Add_button_to_add_a_new_Employee() throws Throwable {
	    driver.findElement(By.id("btnAdd")).click();
	}



	List<String> candidate = new ArrayList<String>();
	List<String> empId = new ArrayList<String>();
	@Then("^enter details of employee and save$")
	public void enter_details_of_employee(List<String> details) throws Throwable {
		
		for(int i=0;i<details.size();i=i+5) {
		    
		    driver.findElement(By.id("chkLogin")).click();
		    driver.findElement(By.id("firstName")).sendKeys(details.get(i));
		    driver.findElement(By.id("middleName")).sendKeys(details.get(i+1));
		    driver.findElement(By.id("lastName")).sendKeys(details.get(i+2));
		    String list = details.get(i)+" "+details.get(i+1)+" "+details.get(i+2);
		    candidate.add(list);
		    empId.add(driver.findElement(By.id("employeeId")).getAttribute("value"));

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='addEmployeeTbl']/form/fieldset/ol/li[5]/input"))).sendKeys(details.get(i+3));
			driver.findElement(By.xpath("//div[@id='addEmployeeTbl']/form/fieldset/ol/li[6]/input")).sendKeys(details.get(i+4));
			driver.findElement(By.xpath("//div[@id='addEmployeeTbl']/form/fieldset/ol/li[7]/input")).sendKeys(details.get(i+4));

		    driver.findElement(By.id("btnSave")).click();

		    Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1"))).isDisplayed();
		    driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']")).click();
		    
		}		
	}

	
	@Then("^verify that the employees have been created$")
	public void verify_that_the_employees_have_been_created() throws Throwable {
		
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

		for(int i=0;i<empId.size();i++) {
			driver.findElement(By.xpath("//div[@id='employee-information']/div[2]/form/fieldset/ol/li[2]/input")).sendKeys(empId.get(i));
			System.out.println(empId.get(i)+" : "+candidate.get(i));
			driver.findElement(By.xpath("//div[@id='employee-information']/div[2]/form/fieldset/p/input")).click();
			Thread.sleep(2000);
			String fmName = driver.findElement(By.xpath("//div[@id='search-results']/div/form/div[4]/table/tbody/tr/td[3]/a")).getText();
			String lastName = driver.findElement(By.xpath("//div[@id='search-results']/div/form/div[4]/table/tbody/tr/td[4]/a")).getText();
			String fullNameActual = fmName+" "+lastName;
			assertEquals(candidate.get(i),fullNameActual);
			driver.findElement(By.xpath("//div[@id='employee-information']/div[2]/form/fieldset/ol/li[2]/input")).clear();
						
		}
		
		
	}

	
	// -------- Add Multiple Employee - End ---------	
	
	
	
	
	
	@And("^Close the browser$")
	public void Close_the_browser() throws Throwable {
		driver.quit();
	}
	
	
	
}
