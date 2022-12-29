# mini-project-tms
A repository for the Team Management System

## Steps

We have followed an approach to configure the user specific details in a separate file with the suffix `-user` for the `.properties` to configure the Database and Email (for SMTP Credentials). 

> As this file should NOT be tracked for the obvious reasons, we have added a rule in the `.gitignore` file to ignore such files. 

Thus, you are requested to ensure you have the following files in your classpath, alongside the main files `dbconfig.properties` and `emailconfig.properties` which still hold certain common (user agnostic) configurable values. 

> Note: Also, if these files are not present, the login page (welcome page) of the application will throw an error stating that the *Application is NOT yet ready. Plese contact Admin".

* dbconfig-user.properties
* emailconfig-user.properties

## DBConfig Properties - `dbconfig-user.properties`

```properties
# DB Config file to store the properties for TMS application

## JDBC Credentials
## ----------------

jdbc.user.name=<DB_USER>
jdbc.user.pass=<DB_PWD>
```

## EmailConfig Properties - `emailconfig-user.properties`

```properties
# SMTP Config file to store the properties for TMS application

## SMTP Credentials
## ----------------

smtp.user.name=<SMTP_USER_EMAIL>
smtp.user.pass=<SMTP_USER_PWD>

email.user.from=<FROM_EMAIL>
email.user.to=<TO_EMAL>
```
