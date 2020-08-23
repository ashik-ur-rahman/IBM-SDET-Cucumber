
@HRM
Feature: HRM Activities

	
  @JobVacancy
  Scenario: Create a job vacancy for "DevOps Engineer"
		Given OrangeHRM page is opened and login with username "orange" and password "orangepassword123"
		When navigated to the Recruitment page
		Then click on the Vacancies menu item to navigate to the vacancies page
		And click on the Add button to navigate to the Add Job Vacancy form
		And Fill out details on Add Job Vacancy form
		And click the Save button to save the vacancy
		And verify that vacancy is created
   And Close the browser

  @Candidate
  Scenario: Add information about a candidate for recruitment
		Given OrangeHRM page is opened and login with username "orange" and password "orangepassword123"
		When navigated to the Recruitment page  
		Then click on the Candidates menu item to navigate to the candidates page
		And click on the Add button to add candidate information
		And fill in the details of the candidate
		And upload a resume (docx or pdf) to the form
		And Save Candidate
		And navigate back to the Recruitments page to confirm candidate entry
		And Close the browser
		
@AddMultipleEmployee
	Scenario: Add multiple employees using an the Examples table
		Given OrangeHRM page is opened and login with username "orange" and password "orangepassword123"
		When PIM option is clicked from the menu
		Then click Add button to add a new Employee
		And enter details of employee and save
				|		V				|	R					| 	Krishna		| krishvr24	| vrkr!$hn@01|
				|		Ayush		|	Kumar			| 	Gupta			| guptaak24	| @kgupt@01  |
				|		Lal			|	Chand			| 	Tripathi	| tripathi24| lctr!p@th01|
				|		R				|	L					| 	Steven		| stevenrl24| rl$t3v3n01 |		
		And verify that the employees have been created
		And Close the browser


		
		
@AddMultipleVacancies
	Scenario Outline: Creating multiple vacancies using data from an external excel spreadsheet
		Given OrangeHRM page is opened and login with username "orange" and password "orangepassword123"
		When navigated to the Recruitment page
		Then click on the Vacancies menu item to navigate to the vacancies page
		And click on the Add button to navigate to the Add Job Vacancy form
		And enter Job Title "<Job Title>",Vacancy Name"<Vacancy name>",Hiring Manager "<Hiring Manager>",Number of Positions "<No of Pos>" 
		And click the Save button to save the vacancy
		And verify that vacancy is created
    And Close the browser			
    
Examples:
		|			Job Title						|Vacancy name	| 	Hiring Manager 	| No of Pos	|	
		|		Android Developer			|		ANDEV09		| 		V R Krishna		| 		04		|
		|Automation Test Engineer	|	AUTSTENG09	| Ayush Kumar Gupta	| 		05		|
		|			Java Developer			|	JAVADEV09		|	Lal Chand tripathi| 		07		|
		|			DevOps Engineer			|	DEVOPSENG09	| 	R L Steven			| 		02		|
		    