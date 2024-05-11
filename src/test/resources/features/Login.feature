Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "sakthibala.sengottiyan@testpro.io"
    And I enter password "Smg6reUh"
    And I submit
    Then I am logged in
