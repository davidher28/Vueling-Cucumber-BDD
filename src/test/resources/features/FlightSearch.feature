Feature: Search a flight using vueling.com

  Narrative:
  Looking for a domestic flight
  As the user of the vueling website
  I would like to see the available flights after clicking search

  Scenario: Perform a flights search
    Given I have navigated to the vueling website
    When I search a flight with the following characteristics:
      | from    | to           | date          | returnDate | numberOfPassengers |
      | Madrid  | Barcelona    | 01/06/2024    |            | 1                  |
    Then I get the available flights in the flight results list
