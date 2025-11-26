## Use Case 5: View All Capital Cities in the World, Continent, or Region Organized by Largest to Smallest Population

**Goal in Context:** To allow users to generate a ranked list of all capital cities across the world or within a selected continent or region, ordered from the largest to smallest population.

**Scope:** Population Information System (SQL-based population reporting and analytics system).

**Level:** Primary Task.

**Preconditions:**

- The SQL database contains accurate and up-to-date information on cities, their population, and an indication of which are capital cities.

- Each city is linked to its corresponding country, region, and continent.

- The user has the required permissions to query and view demographic data.

- The database and reporting interface are accessible.

**Success End Condition:** The system successfully retrieves and displays all capital cities within the selected scope, ranked from largest to smallest population.

**Failed End Condition:**

- The user selects an invalid continent or region.

- The query returns no results.

- System or database connectivity fails.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects the “Capital Cities by Population” report option from the system’s reporting interface.

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Reports or Population Analysis section.

- The user selects “Capital Cities by Population.”

- The system prompts the user to select a geographic scope: World, continent or region.

- The user provides their selection.

- The system constructs the appropriate SQL query using the provided parameters.

- The system executes the query and retrieves all capital cities that match the selection.

- The system orders the results largest to smallest in order of population.

- The system displays the results.

- The user can export the report to Excel, CSV, or PDF for analysis.

- The system logs the report generation details (user, timestamp, parameters).

