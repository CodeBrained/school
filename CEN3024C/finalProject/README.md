# Final Project
July 2023

## Objective
Compile all word occurences assignments into one complete project.

## Sections
* Important
* Source control
* Documentation/JavaDoc
* Creating a UI
* Unit Testing
* Databases
* Deployment

### Important
* The file only works with the required jsoup .jar.
* The file also needs javafx installed to load the GUI.

### Source Control
In order to implement source control I used github. The Final Project file on github doesn't have as many commits because I added the files from the modules. The history of the source control is listed within each respective module for each lesson.

### Documentation/JavaDoc
My documentation for methods was created with JavaDoc. To fully implement JavaDoc I wrote a JavaDoc comment for every method in my `word parser` and my `main` .java files.

### Creating a UI
To create the UI I used `JavaFX`. I created a simple UI that can allow the user to view the full poem and generate a list of the 20 most frequent words in the poem. Both windows have a back button to allow for travel between the windows without restarting the program.

### Unit Testing
In order to implement Unit Testing I created a class named WordParserTest. The files can be seen by opening the allclasses.html file created by generating javadocs. 

### Databases
I struggled with this section the most. I was able to create a connection with the MySQL DB and send information. I was only able to send random variables and not the actual poems contents.

I ran into an issue where I couldn't access the data. I tried reading it from the txt file into a linkedlist, map, and a simple arrray. None of them could access the data. In the future I need to remake my project so that I don't have to store the data in so many different data types throughout the process.

### Deployment
I was able to deploy this using the command line on my computer. 

## References

### Reading
* [How to Select Database in MySQL Workbench?](https://www.foxinfotech.org/2019/03/how-to-select-database-in-mysql-workbench.html)

* [Run/Execute a Query in MySQL Workbench](https://www.foxinfotech.org/how-to-run-query-in-mysql-workbench)

* [MySQL - Tutorial](https://www.vogella.com/tutorials/MySQL/article.html)

#### Stack Overflow
* [unknown database in jdbc](https://stackoverflow.com/questions/15832044/unknown-database-in-jdbc)
* [Reading and displaying data from a .txt file](https://stackoverflow.com/questions/731365/reading-and-displaying-data-from-a-txt-file)
