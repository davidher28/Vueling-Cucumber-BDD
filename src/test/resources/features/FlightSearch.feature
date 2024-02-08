Feature: Search a flight using vueling.com

  Narrative:
  In order to search a flight
  As the user of the vueling airline website
  I would like to see multiple flight alternatives after performing a search

  Scenario: Perform a flights search
    Given I have navigated to the vueling website
    When I search a flight with the following characteristics:
      | from    | to           | date          | round_trip | number_of_passengers  |
      | Madrid  | Barcelona    | 2024-06-01    | false      | 1                     |
    Then I get the flight alternatives in the flights list
