Feature: Exercise3Test

  Scenario: Test of log row on User Table Page
    Given I open JDI GitHub site
    And I login using proper username 'Roman' and password 'Jdi1234'
    And I login as user 'ROMAN IOVLEV'
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then I log row has 'Vip: condition changed to true' text in log section
