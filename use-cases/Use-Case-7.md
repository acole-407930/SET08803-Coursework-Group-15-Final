## Use Case 7: View Population Distribution in Urban and Rural Areas

**Goal in Context:** To allow users to retrieve and analyze population distribution, showing total population, people living in cities (urban population), and people not living in cities (rural population) across continents, regions, and countries.

**Scope:** Population Information System (SQL-based data access and reporting system).

**Level:** Primary Task.

**Preconditions:**

- The database contains accurate and up-to-date population data for each country and city.

- Urban population is identifiable as the sum of populations in cities; rural population is the difference between total and urban population.

- Relationships exist between cities, countries, regions, and continents.

- The user has the necessary permissions to access population reports.

**Success End Condition:**

- The system displays a report with total population, urban population, and rural population grouped by continent, region, and country.

**Failed End Condition:**

- The system fails to retrieve data due to connection issues or missing population data.

- The user is notified that the report cannot be generated.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects the “Population Distribution Report” from the system interface.

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Reports or Population Analysis section.

- The user selects “Population Distribution Report.”

- The system prompts the user to select a scope:continent, region or country.

- The user selects the desired scope.

- The system constructs an SQL query to retrieve:

    - Total population per unit

    - Urban population (sum of all cities in that unit)

    - Rural population (Total – Urban)

- The system executes the query and organizes results by continent, region, and country.

- The report is displayed.

- The user may export the report to CSV, Excel, or PDF.

- The system logs the report request and execution details.
