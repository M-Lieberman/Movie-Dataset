# Movie Dataset Project

This is a test project to read in a dataset of movies (CSV file) before processing it. The initial stage is to read in the dataset and transform it into Java objects, including unit tests.

## Dependencies
This project uses Apache Commons CSV to import the file. Some columns contain arrays of JSON data (e.g. keyword). These are parsed and transformed into Java objects using Jackson.

## What Next
The plans are to :
  - Build a web front-end to view the data
  - Add search/filtering
  - Create visualisations (e.g. chart of films released per movie genre by release year)
  


 

