# Installation

1. Fork and copy this project  
2. Install PostgreSQL or like id did - run postgres image with Docker by following command:    
docker run --name image-naem -p 5432:5432 -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=db_name -d -v ${pwd}:/folder-name postgres:13.3  
3. Change data in application.properties file to connect db  
4. Run application  

## Usage

Test data will be created by DataInitializerService at the start of programm. There are following departaments:  
```
1. History, Biology - with lectors  
2. Science - empty department  
```
When application runs you could pass in console following commands:
```
1. Who is head of department {department_name}
2. Show {department_name} statistics
3. Show the average salary for the department {department_name}
4. Show count of employee for {department_name}
5. Global search by {template}
6. exit - to stop the programm
```
