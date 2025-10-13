# USE CASE: <number> <the name should be the goal as a short active verb phrase>

## CHARACTERISTIC INFORMATION

### Goal in Context

As a researcher, I want to view all countries within a specific continent ordered by population (from largest to smallest), so that I can compare population distribution across continents.

### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid country data.

### Success End Condition

A report is displayed showing all countries within a specific continent, sorted by population (from largest to smallest), including the columns Code, Name, Continent, Region, Population, and Capital.

### Failed End Condition

No report is produced.

### Primary Actor

Researcher

### Trigger

The researcher selects the command “Countries of the continent (selected by user) by population.”

## MAIN SUCCESS SCENARIO

1. The researcher selects the command “Countries of the Continent by Population.”

2. The system checks the database connection.

3. The system constructs an SQL query to retrieve all countries within selected continent and their capital cities.

4. The system executes the SQL query.

5. The system sorts the result by population in descending order.

6. The system formats the output with columns: Code, Name, Continent, Region, Population, Capital.

7. The system displays the resulting table to the analyst.

8. The analyst reviews the results — the report is successfully generated.

## EXTENSIONS

2. **Database connection error:** Display message “Database unavailable.” Log the issue and terminate the use case.
4. **SQL execution error:** Display message “Query failed.” Log the issue and terminate the use case.
6. **No matching data found:** Display “No data found.” and return to the main menu.
6. **Invalid or missing population values:** Replace with 0 or skip rows; display a warning if applicable.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*