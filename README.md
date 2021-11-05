# SPRING BOOT CHALLENGE
## _Api rest task manager_

This back end application is a challenge about the creation of a task manager in Java.

## Features

- Swagger-ui interface
- Api rest Crud
- Code with unit testing

## Tech:
- Java 8
- Maven 3.8.3
- Spring Boot v2.5.6
- Swagge2 3.0.0
- Jackson 2.13.0
- Junit

## Installation

Clone and resolve/install maven dependencies
```sh
git clone https://github.com/Sevalas/spring-challenge.git
cd spring-challenge
mvn install
```
To execute application, in parent the directory
```sh
mvn spring-boot:run
```

## Usage

The deployament default host is http://localhost:8080/.
While the application is running, we can use five different endpoints:
- [POST]{{host}}/task-manager/add-task
- [GET]{{host}}/task-manager/get-task-list
- [GET]{{host}}/task-manager/get-task/{task-id}
- [PUT]{{host}}/task-manager/update-task/{task-id}
- [DELETE]{{host}}/task-manage/delete-task/{task-id}

✨**With Swagger we can use the doccumentation ui throug this url**✨
[{{host}}/swagger-ui.html](http://localhost:8080/swagger-ui.html)

The Interface of a task in this application is:
- String id
- String reporterName
- String assigneeName
- String creationDate
- String updateDate
- String title
- String description
- String status

Example of json body request to add or update a task:
```sh
{
  "reporterName": "Sevalas",
  "assigneeName": "GitUser",
  "creationDate": "Fri Nov 05 11:57:10 CLST 2021",
  "updateDate": "Fri Nov 05 11:57:10 CLST 2021",
  "title": "Clone and Use the task manager Application",
  "description": "Follow the README instructions, deploy and test the application",
  "status": "Open"
}
```
## Considerations

This application have only runtime persistence, no db connections, however, a constant tasks list are initialize with the application for the testings reason.

## Thanks for use this application, All feedback is highly appreciated

Sebastian Valencia Lasprilla, Application developer