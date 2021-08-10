@AlphaCode @StoryCode
  Feature: Code Endpoint
    As a user I would like ...

    @CountryCode @Regression
  Scenario: search by code returns one result
      Given I have the "alpha" endpoint available
      When I do a search by country code "RO"
      Then  I have 1 results returned