Feature: Login feature

  Background:
    Given I login to Koel "sakthibala.sengottiyan@testpro.io" "te$t$tudent1"
#    This step sets up the initial state of the test by logging into Koel

  Scenario: Create Playlist
    When I create a playlist
    Then I should see the success alert

  Scenario: Create playlist with empty name
    When I create a playlist ""
    Then I should see the validation message

  Scenario: Create playlist with existing name
    When I create a playlist "Test1"
    Then I should not see the success alert

  Scenario: Create playlist with less than 3 characters
    When I create a playlist "ab"
    Then I should not see the success alert

  Scenario: Create playlist with more than 10 characters
    When I create a playlist "Test1234567"
    Then I should not see the success alert