# USE CASE: All the cities in a country organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context


As a researcher, I want to view all cities in a selected country ordered by population, so that I can understand which cities have the most people in that country.


### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid population data

### Success End Condition

A report is displayed showing all cities in country, sorted by population (from largest to smallest), displaying the information: Name, Country, District, and Population.

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data researcher

### Trigger

The researcher runs the method for “Cities in a country by population.”

## MAIN SUCCESS SCENARIO

1. The researcher runs the method “Cities in a country by population.”

2. The system checks the database connection.

3. The system constructs an SQL query to retrieve all cities in country and their information

4. The system executes the SQL query.

5. The system sorts the result by population in descending order.

6. The system formats the output with columns: Name, Country, District, and Population.

7. The report is successfully generated.

## EXTENSIONS

- Database connection error: Display “Database unavailable” and log the issue.
- SQL execution error: Query failed and display according error
- No matching data found: Display “No data found.” and return to the main menu.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*