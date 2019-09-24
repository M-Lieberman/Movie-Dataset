# Movie Dataset Project

This is a sample project to read in a dataset of movies (CSV file) before processing it. The initial test stage is to read in the dataset and transform it into Java objects, including unit tests.

## Dependencies
This project uses Apache Commons CSV to import the file. Some columns contain arrays of JSON data (e.g. keyword). These are parsed and transformed into Java objects using Jackson.
  

 

