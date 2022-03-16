Feature: User Table functionality

  Scenario: VIP checkbox in User table
    Given I open JDI GitHub site
    And I login as user 'Roman' password 'Jdi1234'
    And I click on Service button in Header
    And I click on 'User Table' button in Service dropdown
    When I select vip checkbox for 'Sergey Ivan'
    Then for 'Sergey Ivan' there is a log row 'Vip: condition changed to true'
