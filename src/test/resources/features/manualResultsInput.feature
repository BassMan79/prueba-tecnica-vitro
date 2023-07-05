@Regression
Feature: Manual results input module scenarios

  Scenario Outline: Search and validate data found in raw data
    Given I log in with <identifier> identifier <username> username and <password> password
    And I check login is correct
    When I go to raw data page
    And I enter search criteria
    Then I check that two rows appear
    When I go to home page
    And I open a results widget
    And I check that result widget appear
    Then I logout


    Examples:
      | identifier | username | password |
      | 3994       | test     | interqc  |
