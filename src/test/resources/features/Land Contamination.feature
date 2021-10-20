@wip
Feature: Land Contamination functions

  Background:
    Given The user in the login page
    When The user enters valid username and password

  Scenario: Create and delete new record for Land Contamination
    Given The user navigates to "Modules" "Environment" "Land Contamination"
    When User clicks New Record button
    And User enters first message in description fields
    And User enters date
    And User click Save & Close button
    When User clicks New Record button
    And User enters second message in description fields
    And User enters date
    And User click Save & Close button
    When User delete first record
    Then Verify the first record has been deleted
    And Verify the second record is still available

