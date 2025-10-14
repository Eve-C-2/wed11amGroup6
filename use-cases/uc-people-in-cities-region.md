# USE CASE: The population of people, people living in cities, and people not living in cities in each region.

## CHARACTERISTIC INFORMATION

### Goal in Context


As a researcher, I want to view the population of people, people living in cities, and people not living in cities in each region, so that I can analyse population data.


### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid population data

### Success End Condition

A report is displayed showing people, people living in cities, and people not living in cities in each region, displaying the information:
- The name of the region.
- The total population of the region.
- The total population of the region living in cities (including a %).
- The total population of the region not living in cities (including a %).

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data researcher

### Trigger

The researcher runs the method for "people in cities in region".

## MAIN SUCCESS SCENARIO

1. The researcher runs the method "people in cities in region".

2. The system checks the database connection.

3. The system constructs an SQL query to retrieve all people, living in cities, and not living in cities in the region.

4. The system executes the SQL query.

5. The system formats the output as: Name of region, population of region, people living in cities + %, and people not living in cities + %.

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
