Feature: Listing scheduled flights

  Scenario: Listing scheduled flights from a given destination
    Given I want to know the flights out of SYD
    When I request the International flights
    Then I should see the following flights:
    | flightNumber | Departure | Destination | time  |
    | FH-223       | SYD       | LAX         | 06:00 |
    | FH-305       | MEL       | SFO         | 07:15 |
    | FH-234       | SYD       | LHR         | 09:25 |
    | FH-403       | SYD       | DBX         | 14:05 |
