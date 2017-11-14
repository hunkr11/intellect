# intellect
restful crud operation using spring boot
Requirements to run the Application:

1. Postgre sql
2. Java 8

To run the Application:
1. Change the db configuration in /intellectcurd/src/main/resources/application.properties
2. Create a Database name 'intellect'
3. open the application in any IDE, and run the main File in '/intellectcurd/src/main/java/com/intellect/intellectcurd/IntellectcurdApplication.java'
4. once the server is up, import 'Siva Api.postman_collection.json' into POSTMAN
5. When clicking on the send, you will see the output in the console.
6. To see the update in the postgres, use the following commands,

	*  \c intellect;
	*  select * from employee;
