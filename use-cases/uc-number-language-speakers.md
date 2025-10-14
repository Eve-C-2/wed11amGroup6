# USE CASE: Provide the number of people who speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest, including the percentage of the world population.

## CHARACTERISTIC INFORMATION

### Goal in Context


As a researcher for the company, I want to view the number and percentage of world population of people who speak Chinese, English, Hindi, Spanish an/or Arabic, so that I can analyse population data.


### Scope

Population Reporting System

### Level

Primary task

### Preconditions

The SQL database is connected.

The database contains valid population data

### Success End Condition

The system displays a report of totals of people who speak Chinese, English, Hindi, Spanish and Arabic, sorted greatest amount of speakers to smallest. This also prints the percentage of world population for each category.

### Failed End Condition

No report is produced, the system displays an appropriate message.

### Primary Actor

Data researcher

### Trigger

The researcher runs the method for displaying language speakers and their totals+percentages.

## MAIN SUCCESS SCENARIO

1. The researcher runs the method for displaying language speakers and their totals+percentages.

2. The system checks the database connection.

3. The system constructs an SQL query to retrieve the language speakers and their totals+percentages.

4. The system executes the SQL query.

5. The system sorts the result/s by highest number of speakers to lowest.

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