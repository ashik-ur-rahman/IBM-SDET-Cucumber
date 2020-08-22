
@SuiteCRM
Feature: CRM Activities


  @CountDashlets
  Scenario: Count and print the dashlets on homepage
    Given the Alchemy CRM site is opened
    When login with username "admin" and password "pa$$w0rd"
    Then count the number of Dashlets on the homepage
    And print the number and title of each Dashlet
    And Close browser

  @CreateLeads
  Scenario: Create leads using parameterization
    Given the Alchemy CRM site is opened
    When login with username "admin" and password "pa$$w0rd"
		Then navigate to Sales, Leads, Create Lead
		And enter First Name "Nishat", Last Name "Tasneem", Country "India"
		And click Save
		And navigate to the View Leads page to see results
		And Close browser

	@ScheduleMeeting
	Scenario: Schedule a meeting and invite members
    Given the Alchemy CRM site is opened
    When login with username "admin" and password "pa$$w0rd"
		Then Navigate to Activities -> Meetings -> Schedule a Meeting
		And Enter the details of the meeting
		And Search for members and add them to the meeting
			|	Maizah		|
			|	Nishat		|
		And Save Meeting
		And Navigate to View Meetings page and confirm creation of the meeting
		And Close browser			
		
	@CreateProduct	
	Scenario Outline: Creating a Product
    Given the Alchemy CRM site is opened
    When login with username "admin" and password "pa$$w0rd"
		Then Navigate to All -> Products-> Create Product
		And enter Product Name "<Product Name>" and Prduct Price "<Product Price>"details of the product
		And save Product
		And navigate to View Products page to see all products listed
		And Close browser			
						
Examples:
			|	Product Name	|	Product Price	|
			|		Time Sheet1	|			2500			|


