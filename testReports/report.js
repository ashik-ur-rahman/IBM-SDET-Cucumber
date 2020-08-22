$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CRM.feature");
formatter.feature({
  "line": 3,
  "name": "CRM Activities",
  "description": "",
  "id": "crm-activities",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@SuiteCRM"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Count and print the dashlets on homepage",
  "description": "",
  "id": "crm-activities;count-and-print-the-dashlets-on-homepage",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@CountDashlets"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "the Alchemy CRM site is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "login with username \"admin\" and password \"pa$$w0rd\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "count the number of Dashlets on the homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "print the number and title of each Dashlet",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Crm.the_Alchemy_CRM_site_is_opened()"
});
formatter.result({
  "duration": 10281950800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 21
    },
    {
      "val": "pa$$w0rd",
      "offset": 42
    }
  ],
  "location": "Crm.login_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 3829100600,
  "status": "passed"
});
formatter.match({
  "location": "Crm.count_the_number_of_Dashlets_on_the_homepage()"
});
formatter.result({
  "duration": 606028600,
  "status": "passed"
});
formatter.match({
  "location": "Crm.print_the_number_and_title_of_each_Dashlet()"
});
formatter.result({
  "duration": 86900,
  "status": "passed"
});
formatter.match({
  "location": "Crm.Close_the_browser()"
});
formatter.result({
  "duration": 652954800,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Create leads using parameterization",
  "description": "",
  "id": "crm-activities;create-leads-using-parameterization",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@CreateLeads"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "the Alchemy CRM site is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "login with username \"admin\" and password \"pa$$w0rd\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "navigate to Sales, Leads, Create Lead",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "enter First Name \"Nishat\", Last Name \"Tasneem\", Country \"India\"",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "click Save",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "navigate to the View Leads page to see results",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Crm.the_Alchemy_CRM_site_is_opened()"
});
formatter.result({
  "duration": 9254966600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 21
    },
    {
      "val": "pa$$w0rd",
      "offset": 42
    }
  ],
  "location": "Crm.login_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 3711809800,
  "status": "passed"
});
formatter.match({
  "location": "Crm.navigate_to_Sales_Leads_Create_Lead()"
});
formatter.result({
  "duration": 4124831000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nishat",
      "offset": 18
    },
    {
      "val": "Tasneem",
      "offset": 38
    },
    {
      "val": "India",
      "offset": 57
    }
  ],
  "location": "Crm.create_lead_accounts(String,String,String)"
});
formatter.result({
  "duration": 1434705000,
  "status": "passed"
});
formatter.match({
  "location": "Crm.click_Save()"
});
formatter.result({
  "duration": 1841219500,
  "status": "passed"
});
formatter.match({
  "location": "Crm.navigate_to_the_View_Leads_page_to_see_results()"
});
formatter.result({
  "duration": 1623276900,
  "status": "passed"
});
formatter.match({
  "location": "Crm.Close_the_browser()"
});
formatter.result({
  "duration": 637084000,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Schedule a meeting and invite members",
  "description": "",
  "id": "crm-activities;schedule-a-meeting-and-invite-members",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@ScheduleMeeting"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "the Alchemy CRM site is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "login with username \"admin\" and password \"pa$$w0rd\"",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Navigate to Activities -\u003e Meetings -\u003e Schedule a Meeting",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Enter the details of the meeting",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Search for members and add them to the meeting",
  "rows": [
    {
      "cells": [
        "Maizah"
      ],
      "line": 31
    },
    {
      "cells": [
        "Nishat"
      ],
      "line": 32
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Save Meeting",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "Navigate to View Meetings page and confirm creation of the meeting",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Crm.the_Alchemy_CRM_site_is_opened()"
});
formatter.result({
  "duration": 11401964300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 21
    },
    {
      "val": "pa$$w0rd",
      "offset": 42
    }
  ],
  "location": "Crm.login_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 4271877800,
  "status": "passed"
});
formatter.match({
  "location": "Crm.navigate_to_Activities_Meetings_Schedule_a_Meeting()"
});
formatter.result({
  "duration": 4270553800,
  "status": "passed"
});
formatter.match({
  "location": "Crm.enter_the_details_of_the_meeting()"
});
formatter.result({
  "duration": 2769033400,
  "status": "passed"
});
formatter.match({
  "location": "Crm.search_for_members_and_add_them_to_the_meeting(String\u003e)"
});
formatter.result({
  "duration": 1010889400,
  "status": "passed"
});
formatter.match({
  "location": "Crm.save_meeting()"
});
formatter.result({
  "duration": 1486551200,
  "status": "passed"
});
formatter.match({
  "location": "Crm.navigate_to_View_Meetings_page_and_confirm_creation_of_the_meeting()"
});
formatter.result({
  "duration": 2080181600,
  "status": "passed"
});
formatter.match({
  "location": "Crm.Close_the_browser()"
});
formatter.result({
  "duration": 669256500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 38,
  "name": "Creating a Product",
  "description": "",
  "id": "crm-activities;creating-a-product",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 37,
      "name": "@CreateProduct"
    }
  ]
});
formatter.step({
  "line": 39,
  "name": "the Alchemy CRM site is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "login with username \"admin\" and password \"pa$$w0rd\"",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "Navigate to All -\u003e Products-\u003e Create Product",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "enter Product Name \"\u003cProduct Name\u003e\" and Prduct Price \"\u003cProduct Price\u003e\"details of the product",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "save Product",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "navigate to View Products page to see all products listed",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Close browser",
  "keyword": "And "
});
formatter.examples({
  "line": 47,
  "name": "",
  "description": "",
  "id": "crm-activities;creating-a-product;",
  "rows": [
    {
      "cells": [
        "Product Name",
        "Product Price"
      ],
      "line": 48,
      "id": "crm-activities;creating-a-product;;1"
    },
    {
      "cells": [
        "Time Sheet1",
        "2500"
      ],
      "line": 49,
      "id": "crm-activities;creating-a-product;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 49,
  "name": "Creating a Product",
  "description": "",
  "id": "crm-activities;creating-a-product;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@SuiteCRM"
    },
    {
      "line": 37,
      "name": "@CreateProduct"
    }
  ]
});
formatter.step({
  "line": 39,
  "name": "the Alchemy CRM site is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "login with username \"admin\" and password \"pa$$w0rd\"",
  "keyword": "When "
});
formatter.step({
  "line": 41,
  "name": "Navigate to All -\u003e Products-\u003e Create Product",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "enter Product Name \"Time Sheet1\" and Prduct Price \"2500\"details of the product",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "save Product",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "navigate to View Products page to see all products listed",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "Close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Crm.the_Alchemy_CRM_site_is_opened()"
});
formatter.result({
  "duration": 10276553500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 21
    },
    {
      "val": "pa$$w0rd",
      "offset": 42
    }
  ],
  "location": "Crm.login_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 3707484000,
  "status": "passed"
});
formatter.match({
  "location": "Crm.navigate_to_All_Products_Create_Product()"
});
formatter.result({
  "duration": 3743553700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Time Sheet1",
      "offset": 20
    },
    {
      "val": "2500",
      "offset": 51
    }
  ],
  "location": "Crm.enter_details_of_the_product(String,String)"
});
formatter.result({
  "duration": 1170296000,
  "status": "passed"
});
formatter.match({
  "location": "Crm.save_Product()"
});
formatter.result({
  "duration": 1396621700,
  "status": "passed"
});
formatter.match({
  "location": "Crm.View_Products_listed()"
});
formatter.result({
  "duration": 2515098700,
  "status": "passed"
});
formatter.match({
  "location": "Crm.Close_the_browser()"
});
formatter.result({
  "duration": 677643200,
  "status": "passed"
});
});