## Use Case 1: View Global Population

**Goal in Context:** To allow users to view all countries in the world, continent or region, and organised by the largest to smallest population.

**Scope:** Population Information System (SQL-based data access and reporting system).

**Level:** Primary Task.

**Preconditions:**

- The SQL database must be available and contain up-to-date data on countries, populations, continents, and regions.

- The user must have permission to access population reports.

- Tables such as Country, Region, and Continent (or their equivalents) exist and have valid relationships.

**Success End Condition:** The user successfully views or exports a list of all countries grouped by continent and region, sorted by population (descending).

**Failed End Condition:** The report cannot be generated due to missing data or a failed database connection, and the system displays an appropriate error message.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects “Global Population Report” or runs a query to view all countries ordered by population size.

**Main Success Scenario:**

- The user logs into the Population Information System.

- From the reporting menu, the user selects “Global Population Report.”

- The system sends an SQL query to retrieve population data for all countries, continents or regions based on a filter,

- The system groups the results by largest to smallest population.

- The system displays the report on screen.

- The user may export the results to CSV, Excel, or PDF.

- The system logs the report access for audit tracking.
