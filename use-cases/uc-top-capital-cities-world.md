# USE CASE: The top N populated capital cities in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context


As a researcher, I want to view the top N most populated capital cities in the world, so that I can analyse population data.


### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid capital city data

### Success End Condition

The system displays a report of the top N capital cities in the world, sorted by population (from largest to smallest), displaying the information: Name, Country, District, and Population.

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data researcher

### Trigger

The researcher runs the method for “Top N Capital cities in the world" and enters a number N.

## MAIN SUCCESS SCENARIO

1.	The researcher runs the method for “Top N Capital cities in the world"

2.	The system prompts the analyst to enter a number N.

3.	The analyst enters a valid integer N.

4.	The system validates that N > 0 and within an acceptable range.

5.	The system constructs and executes an SQL query to retrieve the top N capital cities in world, ordered by population descending.

6.	The system displays the result with the following columns: Name, Country, District, and Population.

7.	The analyst views the displayed data.

8.	The use case ends successfully.

## EXTENSIONS

- Database connection error: Display “Database unavailable” and log the issue.
- SQL execution error: Query failed and display according error
- No matching data found: Display “No data found.” and return to the main menu.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: *date or release of deployment*

*any other schedule/staffing information you need*