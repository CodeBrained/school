# Module 10 - Database

July 2023

## Objectives

* Add database support to your word occurrences application.
* Add a schema called 'word occurrences'. Add a table called 'word'. Then, as you parse the document, add new words that are not already in the database.
* EX. insert into wordOccurrences.word (word) values ('the');
* EX. insert into wordOccurrences..word (word) values ('test');
* EX. insert into wordOccurrences..word (word) values ('this');
* EX. insert into wordOccurrences..word (word) values ('a');
* EX. select * from wordOccurrences..word
* Add JDBC support to your Java project (http://tutorials.jenkov.com/jdbc/index.html)
* In your word occurrence application, instead of storing the frequencies in the array, store/read them from the database
* This is a very simple database. The idea is to get it working.

## Resources

### Reading

* [MySQL and Java JDBC - Tutorial](https://www.vogella.com/tutorials/MySQLJava/article.html)
* [MySQL JDBC Tutorial](www.mysqltutorial.org/mysql-jdbc-tutorial/)
* [MySQL Java](https://zetcode.com/db/mysqljava/)
* [Java Database Connectivity with MySQL](https://www.javatpoint.com/example-to-connect-to-the-mysql-database)
* [JDBC - Sample, Example Code](https://www.tutorialspoint.com/jdbc/jdbc-sample-code)

### Videos

* [Introduction to MySQL Workbench](https://www.youtube.com/watch?v=RSHevYMwCVw)
* [Java- MySQL Connection (Create Table, Insert, Select)](https://www.youtube.com/watch?v=KRhv4iPgzHE)
* [Connect to MySQL Using IntelliJ IDEA 2021 (Community Edition) and Database Navigator Plugin](https://www.youtube.com/watch?v=V2bGKzvMQyc&feature=youtu.be)
* [Java-MySQL Select](https://www.youtube.com/watch?v=HE6ZHSuHcu0)