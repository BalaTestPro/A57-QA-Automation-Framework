Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "sakthibala.sengottiyan@testpro.io"
    And I enter password "te$t$tudent1"
    And I submit
    Then I am logged in
