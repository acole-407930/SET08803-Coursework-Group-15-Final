## Use Case 6: View the Top N Populated Capital

**Goal in Context:** To allow users to retrieve a ranked list of the top N most populated capital cities in the world or within a selected continent or region, where N is a value provided by the user.

**Scope:** Population Information System (SQL-based population reporting and analytics system).

**Level:** Primary Task.

**Preconditions:**

- The SQL database contains accurate population data for all cities and identifies which cities are capitals.

- Relationships between cities, countries, regions, and continents are properly defined.

- The system supports user input for N (the number of results to display).

- The user has the appropriate access privileges to run population queries.

**Success End Condition:** The system displays the top N populated capital cities in the chosen scope, ranked from largest to smallest population.

**Failed End Condition:**

- The user provides an invalid value for N.

- The query returns no matching results.

- A database or system error prevents query execution.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects the “Top N Populated Capital Cities” report option from the reporting interface.

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Reports or Population Data section.

- The user selects “Top N Populated Capital Cities.”

- The system prompts the user to: Enter a numeric value for N and choose a world, continent, or region.

- The user provides their input.

- The system validates the input for correctness.

- The system constructs an SQL query using the user’s parameters.

- The query executes and retrieves data for capital cities matching the selection.

- The results are sorted by population descending and limited to N records.

- The system displays the list of cities showing City Name, Country, Continent, Region, and Population.

- The user may export or download the report.

- The system logs the report parameters and execution details.

