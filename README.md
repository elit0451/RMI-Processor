# RMI Data Processor
The following application illustrates the use of RPC/RMI technology.


## RMI Stud Admin Project :floppy_disk:
A school needs to collect data about their newly accepted students - name, email address, etc :page_with_curl:. Imagine that the information about the second semester students is already present in a SQL database <img src="https://camo.githubusercontent.com/76416961f2288c7bfeca0bf4f62748fb8ee273a0/68747470733a2f2f696d6167652e666c617469636f6e2e636f6d2f69636f6e732f7376672f3134382f3134383832352e737667" height="20" align="center">, while the same kind of data about the new students is still in a text document :card_index:.

</br>

## Getting Started
In order to run our Server application, make sure you add a dependency to this [h2.jar](
http://repo2.maven.org/maven2/com/h2database/h2/1.4.199/h2-1.4.199.jar) file.

</br>

---
### RMI Server application
Our [Server]() shares services, which enable a client to **open**, **read**, and **process** two types of data sources:
- a text file, either [.txt](./Students.txt) or [.csv](./Students.csv)
- SQL database

_NB_:exclamation: You can change the input text file absolute path in [Client.java](). If you'd prefer to see the results from the Database, uncomment [the line]() and comment the text file input one.

</br>

> Database script used for setting up
```sql
CREATE TABLE STUDENT(
    Name VARCHAR(50),
    Email VARCHAR(50),
    Birthday VARCHAR(50),
    StartDate VARCHAR(50)
);

INSERT INTO STUDENT
VALUES ('John', 'jj@cphbusiness.dk', '12.03.1998', '28.01.2019'),
       ('Anna', 'aa@cphbusiness.dk', '07.08.1996', '28.01.2019'),
       ('Tom', 'tt@cphbusiness.dk', '23.05.1997', '28.01.2019');
```

</br>

---
### RMI Client application
The [Client]() application, on the other hand, can connect to the server and take use of the remote services.

</br>

___
> #### Assignment made by:   
`David Alves 👨🏻‍💻 ` :octocat: [Github](https://github.com/davi7725) <br />
`Elitsa Marinovska 👩🏻‍💻 ` :octocat: [Github](https://github.com/elit0451) <br />
> Attending "System Integration" course of Software Development bachelor's degree
