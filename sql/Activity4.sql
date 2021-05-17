REM   Script: Activity4
REM   Alter Salesman table

SELECT * FROM salesman;

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

