Feature: Exporting staff data to a spreadsheet
  Scenario: Export staff birthdays as an Excel spreadsheet
    Given the following employees:
    | Name  | Birthday       |
    | Joe   | 10-03-1980    |
    | Jill  | 18-12-1965    |
    | Jack  | 20-12-1975    |
    | Joan  | 20-11-1991    |
    And today is 16-12-2013
    When I export this week's birthday list
    Then I should obtain a spreadsheet containing the following:
    | Name  | Birthday       |
    | Jill  | 18-12-1965    |
    | Jack  | 20-12-1975    |



