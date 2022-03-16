Feature: User Table Page functionality

  Scenario:User Table Page test
    Given I open JDI GitHub site
    And I login as user 'Roman' password 'Jdi1234'
    And I click on Service button in Header
    And I click on 'User Table' button in Service dropdown
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    And droplist should contain values in column Type for user Roman
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |
