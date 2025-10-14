# USE CASE: Countries of the world by population

## CHARACTERISTIC INFORMATION

### Goal in Context


As a data analyst, I want to view all countries in the world ordered by population (from largest to smallest), so that I can understand global population distribution.


### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid population data

### Success End Condition

A report is displayed showing all countries, sorted by population (from largest to smallest), including the columns Code, Name, Continent, Region, Population, and Capital.

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data analyst

### Trigger

The analyst selects the command “Countries of the world by population.”

## MAIN SUCCESS SCENARIO

1. The analyst selects the command “Countries of the World by Population.”

2. The system checks the database connection.

3. The system constructs an SQL query to retrieve all countries and their capital cities.

4. The system executes the SQL query.

5. The system sorts the result by population in descending order.

6. The system formats the output with columns: Code, Name, Continent, Region, Population, Capital.

7. The system displays the resulting table to the analyst.

8. The analyst reviews the results — the report is successfully generated.

## EXTENSIONS

- Database connection error: Display “Database unavailable” and log the issue.
- SQL execution error: Query failed and display according error
- No matching data found: Display “No data found.” and return to the main menu.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*