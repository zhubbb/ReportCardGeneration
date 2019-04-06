To Config:
go to Config folder and edit Config/config.csv
fill the table with input file path and output file path
e.g Course is the input file path for course data(courses.csv)


The project is build but if you want to rebuild:
the ant build file is auto generated , might need to modify it
-build the project with ant or whatever, the main file is src\Controller\ReportGenerator.java
-open and edit build.properties 
-set jdk.home.9.0 = xxxx to correct java home path
-then run ant in the directory with cmd : ant

To run:
change dir to current folder
cmd to run the project after build:
java -classpath out\production\ReportCardGeneration Controller.ReportGenerator

To view report:
The report will be generated to the output folder mentioned in the config.csv

Invalid input data will be ignored.
other Exception( e.g id is not found) will be thrown and terminate the project.
there is no other exception handling unfortunately.

Incomplete course will be shown on the report but it is not counted toward avg score.
if No score can be shown , the avg score will be 0.

For simplicity, no log will be produced.