# USE CASE: The top N populated cities in a continent where N is provided by the user.
## CHARACTERISTIC INFORMATION
### Goal in Context
As a researcher, I want to view the top N most populated cities in a continent, so that I can analyse population data.

### Scope
Population Reporting System

### Level
Primary task

### Preconditions
The SQL database is connected.

The database contains valid city data.

### Success End Condition
The system displays a list of the top N cities in a continent sorted by population (descending), showing columns:  Name, Country, District, and Population.

### Failed End Condition
No report is produced, the system displays an appropriate message.

### Primary Actor
Researcher

### Trigger
The user runs the method for “Top N Populated Cities in a Continent” and enters a number N.

### MAIN SUCCESS SCENARIO
The researcher runs the method for “Top N Populated Cities in a Continent.”

The system prompts the analyst to enter a number N.

The analyst enters a valid integer N.

The system validates that N > 0 and within an acceptable range.

The system constructs and executes an SQL query to retrieve the top N cities in Continent, ordered by population descending.

The system displays the result with the following columns: Name, Country, District, and Population.

The analyst views the displayed data.

The use case ends successfully.

### EXTENSIONS
- Invalid input (non-integer or negative value):
- Display message “Please enter a valid positive number.”, return to Step 2.
- N too large (greater than total number of cities): Display all available cities.
- Database connection error: Display “Database unavailable” and log the issue.
- SQL query fails: “Error retrieving data” and program terminates.

### SUB-VARIATIONS
None.

### SCHEDULE
DUE DATE: date or release of deployment

any other schedule/staffing information you need