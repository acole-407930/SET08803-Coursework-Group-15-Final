## Use Case 2: View the Top N Populated Countries

**Goal in Context:** To allow users to view a ranked list of the top N most populated countries in the world, continent or region where N is specified by the user. This helps users quickly identify the largest countries by population without having to view the entire dataset.

**Scope:** Population Information System (SQL-based reporting and analytics system).

**Level:** Primary Task.

**Preconditions:**

- The SQL database must be available and contain up-to-date population data for all countries.

- The user must have permission to access global population data.

- The system interface must allow the user to input or select a value for N (the number of top countries to display).

**Success End Condition:** The system displays a ranked list of the top N populated countries in the world, continent or region.

**Failed End Condition:**

- The system cannot retrieve or display data.

- The user is notified that the query could not be completed.

**Primary Actor:** Data Analyst or any authorized user who needs population statistics.

**Trigger:** The user selects the “Top N Populated Countries” report option and provides a value for N.

**Main Success Scenario:**

- The user logs into the Population Information System.

- The user navigates to the Population Reports section.

- The user selects “Top N Populated Countries and filters by world, continent or region” from the available reports.

- The system prompts the user to enter a value for N.

- The user enters the desired number N.

- The system validates the input and constructs a query to retrieve the top N countries by population.

- The system executes the SQL query.

- The ranked list of the top N populated countries is displayed on-screen.

- The user may export the results to CSV, Excel, or PDF for reporting purposes.

- The system logs the report generation event for audit purposes.