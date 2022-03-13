Feature: Different Elements Page functionality

  Scenario: Different Elements Page test
    Given I open JDI GitHub site
    And I login as user 'Roman' password 'Jdi1234'
    When I click on "Service" button in Header
    And I click on "Different Elements" page button in Service dropdown
    Then "Different Elements" page should be opened
    When I select checkboxes 'Water, Wind'
    And select radio Selen
    And select in dropdown Yellow
#    Then Water, Wind should be checked
#    And Selen should be checked
#    And Yellow should be selected
    And for checkbox 'Water' there is a log row 'Water: condition changed to true'
    And for checkbox 'Wind' there is a log row 'Wind: condition changed to true'
    And for radio button 'Selen' there is a log row 'metal: value changed to Selen'
    And for dropdown 'Yellow' there is a log row 'Colors: value changed to Yellow'