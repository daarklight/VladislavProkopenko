Feature: Exercise1Test

  Scenario: Test of Different Elements Page
    Given I open JDI GitHub site
    And I login using proper username 'Roman' and password 'Jdi1234'
    And I open Different Elements Page
    When I select Water and Wind checkboxes
    And I select Selen radiobutton
    And I select 'Yellow' from dropdown
    Then Displayed log rows are consistent with selected checkboxes, radiobutton and dropdown
      |Colors: value changed to Yellow  |
      |metal: value changed to Selen    |
      |Wind: condition changed to true  |
      |Water: condition changed to true |