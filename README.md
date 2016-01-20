
# Plain servlets and jdbc Todo app example 

This project needs an postgresql database installed http://www.postgresql.org/download/.

## Create todos table

To run this you should install a GUI for interacting with the database 
https://dbheroapp.com/gui-database-client-for-mysql-postgresql-windows

CREATE DATABASE todos;

CREATE TABLE todos(
    id SERIAL PRIMARY KEY,
    name TEXT,
    done BOOLEAN
);

## Then compile and run:

```
gradle run
```

Then just visit localhost:8000


