# USE CASE: <number> <the name should be the goal as a short active verb phrase>

## CHARACTERISTIC INFORMATION

### Goal in Context

As a data analyst, I want to enter a number N and view the top N most populated countries in the world, so that I can focus on the largest populations globally.

### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid population data.

### Success End Condition

The system displays a list of the top N countries sorted by population (descending), showing columns: Code, Name, Continent, Region, Population, and Capital.

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data analyst

### Trigger

The user selects “Top N Populated Countries in the World” and enters a number N.

## MAIN SUCCESS SCENARIO

1. The analyst chooses the option “Top N Populated Countries in the World.”

2. The system prompts the analyst to enter a number N.

3. The analyst enters a valid integer N.

4. The system validates that N > 0 and within an acceptable range.

5. The system constructs and executes an SQL query to retrieve the top N countries, ordered by population descending.

6. The system displays the result with the following columns: Code, Name, Continent, Region, Population, Capital.

7. The analyst views the displayed data.

8. The use case ends successfully.

## EXTENSIONS

4. **Invalid input (non-integer or negative value)**: Display message “Please enter a valid positive number.”, return to Step 2.
4. **N too large (greater than total number of countries):** Display all available countries with a note “Only X countries found.”
5. **Database connection error**: Display “Database unavailable” and log the issue.
5. **SQL query fails**: Display “Error retrieving data” and terminate the use case.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*