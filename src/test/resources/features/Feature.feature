@Tags
Feature: Feature name - Search by country name functionality
  As a user
  I want to be able to search into the api
  So I can find the required country


  Prereq: Make sure you have Cucumber plugin for Java installed in Intellij

  1. Create first scenario
  Search for the country Romania and verify that only 1 item is returned
  2. Continue with the first scenario
  Add new steps to verify that the country codes are correct.
  3. Verify the first two steps for other countries: Italy, Germany
  4. Remove repetitive step Given in all the scenarios
  5. Verify that a partial name search is working (new scenario) - search with man value and expect 6 results returned
  6. Create new feature file for testing the search by code functionality.
	- Reuse where possible the steps from the first feature file. 

  Background:
    Given I have the "name" endpoint available

  Scenario: Search by country code returns just one result
    When I do a search by country with name "Romania"
    Then I have 1 result returned
    And I have first country code "RO"
    And I have the second country code "ROU"

    When I do a search by country with name "Italy"
    Then I have 1 result returned
    And I have first country code "IT"
    And I have the second country code "ITA"

  Scenario Outline: Search by country code returns just one result
    When I do a search by country with name "<countryName>"
    Then I have <numberOfResults> result returned
    And I have first country code "<firstCountryCode>"
    And I have the second country code "<secondCountryCode>"
    Examples:
      | countryName | numberOfResults | firstCountryCode | secondCountryCode |
      | Romania     | 1               | RO               | ROU               |
      | Italy       | 1               | IT               | ITA               |
      | Germany     | 1               | DE               | DEU               |

  Scenario: Search by partial name
    When I do a search by country with name "man"
    Then I have 6 results returned