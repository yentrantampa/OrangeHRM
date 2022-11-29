Feature: Add & Delete Employee Profiles
  Background:
    Given User is on dashboard

    Scenario: User can select employment status drop down menu
      Given User clicks on PIM button navigation bar
      When User is on PIM page
      And User clicks on employment status drop down menu arrow
      Then User gets a list of employment positions