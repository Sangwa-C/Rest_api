CREATE DATABASE rest_api;
\c rest_api;

CREATE TABLE USER( id SERIAL PRIMARY KEY,
                    name VARCHAR;
                    title VARCHAR;
                    duty VARCHAR;
                    )

CREATE TABLE News(id SERIAL PRIMARY KEY,
                   heading VARCHAR;
                   body VARCHAR;
                  )

CREATE TABLE department (id SERIAL PRIMARY KEY;
                        DName VARCHAR;
                        DDescription VARCHAR;
                        NEmployees VARCHAR;
                        )

CREATE TABLE user_in_department(id SERIAL PRIMARY KEY ,
                                  usersId INTEGER;
                                  DepId INTEGER;
);

CREATE DATABASE rest_api_test WITH TEMPLATE rest_api;
