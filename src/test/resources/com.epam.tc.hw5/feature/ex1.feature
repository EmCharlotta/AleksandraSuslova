Feature: Different Elements Page functionality

  Scenario: Different Elements Page test
    Given I open JDI GitHub site
    Then Browser title is 'Home Page'
    When I login as user 'Roman' password 'Jdi1234'
   Then User name in the left-top side of screen is 'ROMAN IOVLEV'
    Given I click on Service button in Header
    And I click on 'Different Elements' button in Service dropdown
    When I select checkboxes '0, 2'
    Then for 'Water' there is a log row 'Water: condition changed to true'
    And for 'Wind' there is a log row 'Wind: condition changed to true'
    When I select radio '3'
    Then for 'Selen' there is a log row 'metal: value changed to Selen'
    When I select in dropdown 'Yellow'
    Then for 'Yellow' there is a log row 'Colors: value changed to Yellow'