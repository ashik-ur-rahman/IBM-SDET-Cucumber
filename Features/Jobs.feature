
@job_board
Feature: Job Board

@CreateUser
  Scenario: Create a new user
    Given Browser is opened 
    When navigate to login page and login with username "root" and password "pa$$w0rd" 
    Then Clicked on Users
    And Create a new user
    And Verify that user is created
    And close the browser


@FindJobs
	Scenario: Searching for jobs and applying to them using XPath
    Given Alchemy Jobs site is opened 
    When navigated to Jobs page
    Then type in keywords "Automation Test Engineer" to search for jobs
		And filter job type to show only Full Time jobs
		And find a job listing and click it to see job details
		And find the title of the job listing and print it
		And apply for job
		And close the browser

@PostJobsFeaturefile
	Scenario: Post a job using details passed from the Feature file
    Given Alchemy Jobs site is opened 
    When navigated to Post a Job page
    And clicked on sign in button on post job page
    When navigate to login page and login with username "root" and password "pa$$w0rd"     
    Then enter apllication email "ashik.rahman@sdet.com"
    And enter "Automation Test Engineer" and "Full Time"
    And enter location as "Kolkata"
    And enter description as "Automation Test Engineer"
    Then click on Preview button
		And click Submit Listing		
    And naviagte to Alchemy Jobs > Job listings
    And approve job listing for job title "Automation Test Engineer"
    When opened Jobs page
		Then type in keywords "Automation Test Engineer" to search for jobs
    And job "Automation Test Engineer" is listed on jobs page

@PostJobsExample
	Scenario Outline: Post a job using a Scenario Outline and Examples table
    Given Alchemy Jobs site is opened 
    When navigated to Post a Job page
    And clicked on sign in button on post job page
    When navigate to login page and login with username "root" and password "pa$$w0rd"     
    Then enter apllication email "<Application email>"
    And enter "<Job Title>" and "<Job Type>"
    And enter location as "<Location>"
    And enter description as "<Description>"
    Then click on Preview button
		And click Submit Listing		
    And naviagte to Alchemy Jobs > Job listings
    And approve job listing for job title "<Job Title>"
    When opened Jobs page
		Then type in keywords "<Job Title>" to search for jobs
    And job "<Job Title>" is listed on jobs page
    
    
Examples:
		|			Application email		|			Job Title						| Job Type | Location	|			Description					|	
		|		ashik.rahman1@sdet.com	|Automation Test Engineer	|Full Time |	Kolkata	|Automation Test Engineer	|	
    
    