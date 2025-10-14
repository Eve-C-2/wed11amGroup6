# USE CASE: Provide the populations of world, continent, region, country, district and city.

## CHARACTERISTIC INFORMATION

### Goal in Context


As a researcher for the company, I want to view the population of categories of locations: world, continent, region, country, district and city, so that I can analyse population data.


### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid population data

### Success End Condition

The system displays a report of the populations of world, continent, region, country, district and city, sorted by population (from largest to smallest)

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data researcher

### Trigger

The researcher runs the method for displaying populations and enters a number N.

## MAIN SUCCESS SCENARIO

1. The researcher runs the method for displaying populations

2. The system checks the database connection.

3. The system constructs an SQL query to retrieve the populations of the location categories.

4. The system executes the SQL query.

5. The system sorts the result/s by population in descending order.

6. The report is successfully generated.

## EXTENSIONS

- Database connection error: Display “Database unavailable” and log the issue.
- SQL execution error: Query failed and display according error
- No matching data found: Display “No data found.” and return to the main menu.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*