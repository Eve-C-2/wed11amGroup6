# USE CASE: <number> <the name should be the goal as a short active verb phrase>

## CHARACTERISTIC INFORMATION

### Goal in Context

As a data analyst, I want to view the top N most populated countries in a chosen continent, so that I can identify which countries dominate that continent demographically.

### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid country data.

### Success End Condition

The system displays a list of the top N countries within selected continent sorted by population (descending), showing columns: Code, Name, Continent, Region, Population, and Capital.

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data analyst

### Trigger

The user selects “Top N Populated Countries within a Continent M ” and enters a number N and name of continent M.

## MAIN SUCCESS SCENARIO

1. The analyst chooses the option “Top N Populated Countries within the Continent M.”

2. The system prompts the analyst to enter a name of continent M.

3. The analyst enters a valid string M.

4. The system validates that M is not empty and corresponds to one of the regions in the system.

5. The system prompts the analyst to enter a number N.

6. The analyst enters a valid integer N.

7. The system validates that N > 0 and within an acceptable range.

8. The system constructs and executes an SQL query to retrieve the top N countries, ordered by population descending.

9. The system displays the result with the following columns: Code, Name, Continent, Region, Population, Capital.

10. The analyst views the displayed data.

11. The use case ends successfully.


## EXTENSIONS

3. **Invalid input (non-string or wrong name):** Display message “Please enter a correct name.”, return to Step 2.

7. **Invalid input (non-integer or negative value):** Display message “Please enter a valid positive number.”, return to Step 6.

7. **N too large (greater than total number of countries within selected continent):** Display all available countries with a note “Only X countries found on this continent.” 

8. **Database connection error:** Display “Database unavailable” and log the issue.

8. **SQL query fails:** Display “Error retrieving data” and terminate the use case.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*