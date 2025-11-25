## Use Case 8: View Population at Different Geographic Levels

**Goal in Context:** To allow users to retrieve population counts for world, continent, region, country, district, and city.

**Scope:** Population Information System (SQL-based reporting and analytics system).

**Level:** Primary Task.

**Preconditions:**

- The SQL database contains accurate population data for all geographic levels.

- Tables exist for City, District, Country, Region, and Continent, with relationships properly defined.

- Users have permission to access population reports.

**Success End Condition:** The system successfully displays the population for the selected geographic level.

**Failed End Condition:**

- The system cannot retrieve population data due to missing data or database connection errors.

- An appropriate error message is displayed.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects “Population Report by Geographic Level” from the system interface.

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Reports section.

- The user selects “Population Report by Geographic Level.”

- The system prompts the user to select a level: World, continent, region, country, district or city.

- The user selects the desired level .

- The system constructs the appropriate SQL query to retrieve population data for the selected level.

- The system executes the query.

- The system displays the population results.

- The user may export or print the report for further analysis.

- The system logs the query execution details for auditing purposes.