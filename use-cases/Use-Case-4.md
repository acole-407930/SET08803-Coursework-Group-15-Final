## Use Case 4: View the Top N Populated Cities

**Goal in Context:** To allow users to retrieve a ranked list of the top N most populated cities across the world or within a selected continent, region, country, or district, where N is a number provided by the user.

**Scope:** Population Information System (SQL-based reporting and analytics system).

**Level:** Primary Task.

**Preconditions:**

- The SQL database must contain accurate city population data and valid relationships among cities, districts, countries, regions, and continents.

- The user must have access rights to query and view population reports.

- The system must allow user input for N.

- The user must select one or more filtering levels (World, Continent, Region, Country, District).

**Success End Condition:** The system returns and displays the top N most populated cities according to the selected level, in descending order of population.

**Failed End Condition:**
- Invalid input for N.

- Database connection failure or missing data.

- The system displays an appropriate error message.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects the “Top N Populated Cities” option from the reporting dashboard and provides input for N and an optional location filter.

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Reports section.

- The user selects “Top N Populated Cities.”

- The system prompts the user to enter a value for N.

- Select the scope: World, Continent, Region, Country, or District.

- The user inputs their choices.

- The system constructs an SQL query dynamically using the user’s selections.

- The system executes the query to retrieve the top N cities by population.

- The system orders the results by population (descending) and limits the output to N records.

- The system displays the results in a table showing City Name, District, Country, and Population.

- The user may export or print the results.

- The system logs the query execution details.
