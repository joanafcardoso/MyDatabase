DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS company;

CREATE TABLE company (

   id SERIAL PRIMARY KEY ,
   name varchar (60)  NOT NULL UNIQUE,
   postcode varchar (10),
   start_date timestamp without time zone

);

CREATE TABLE employee (

  id SERIAL PRIMARY KEY ,
  firstname character varying (60),
  lastname  character varying (120),
  salary    numeric,
  company_id   SERIAL  REFERENCES company(id)

);


INSERT INTO company ( name, postcode, start_date ) values ( 'acme ltd','1012VC','to_timestamp('12-01-2001','DD-MM-YYYY') );

INSERT INTO company ( name, postcode, start_date ) values ( 'bbc ltd','111XX', '01-01-1991' );

INSERT INTO company ( name, postcode, start_date ) values ( 'paarden rijden b.v','222XX', '12-01-1932' );

INSERT INTO company ( name, postcode, start_date ) values ( 'gaming for fun','1111ZZ', '12-01-2010' );

INSERT INTO company ( name, postcode, start_date ) values ( 'apple inc','8767NN', '12-04-2001' );

INSERT INTO company ( name, postcode, start_date ) values ( 'zirkon ltd','8888BB', '12-01-1976' );