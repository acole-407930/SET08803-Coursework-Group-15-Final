## Use Case 3: View All Cities by Population

**Goal in Context:** To provide users with a flexible report showing all cities organized by largest to smallest population, filtered by world, continent, region, country, or district as specified by the user.

**Scope:** Population Information System (SQL-based data access and reporting system).

**Level:** Primary Task.

**Preconditions:**

- The system must be connected to the database.

- The user must have permission to access population data.

- The system must allow the user to select the geographic level (world, continent, region, country, or district).

**Success End Condition:**
- The system displays a list of cities sorted by population largest to smallest, filtered according to the user’s selected level.
- The user can view, filter, or export the results.

**Failed End Condition:**

- The system fails to retrieve data (due to invalid selection, missing data, or a database connection error).

- An appropriate error message is displayed.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects the “City Population Report” and chooses a geographic level (World, Continent, Region, Country, or District).

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Reports section.

- The user selects “City Population Report.”

- The system prompts the user to choose a level of detail.

    - World (all cities globally)

    - Continent (cities within a selected continent)

    - Region (cities within a selected region)

    - Country (cities within a specific country)

    - District (cities within a specific district)

- The user selects.

- The system constructs the appropriate SQL query based on the user’s input.

- The system executes the query, retrieving the relevant cities and their populations.

- The system orders the results by largest to smallest.
