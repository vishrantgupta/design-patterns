### What is a design pattern?
Design patterns are the solution of well known industry problem, design patterns can also be formalized as best practices a programmer or a developer should follow. Its a way of effectively arranging objects in memory for greater reuse.

#### Design pattern category

- Gang of four Patterns:

	-- Creational patterns
	-- Structural patterns
	-- Behavioral pattern
	-- Concurrency patterns
	
- J2EE Patterns
Patterns in a multi-tiered application, a tier is a logical separation of responsibility. Each tier is given a unique responsibility in a software system, and in ideal world there is no dependency or minimal dependency between each layer.

	-- Client Tier
		Application client, browser
		
	-- Presentation tier
		This tier contains all the presentation logic
		JSP, Servlets, etc
		
		- Intercepting filter
		- Front controller
		- Context objects
		- Application controller
		- View Helper
		- Composite View
		- Service to worker
		- Dispatcher View
		
	
	-- Business tier
		This tier provides business service required by the application clients
		EJB, Webservices
		
		- Business delegate
		- Service Locator
		- Session Facade
		- Application Service
		- Business Object
		- Composite Entity
		- Transfer Object
		- Transfer Object Assembler
		- Value List Handler
	
	-- Integration tier
		This tier is responsible for communicating with external resources
		JMS, JDBC
		
		- Data Access Object (DAO)
		- Service Activator
		- Domain Store
		- Web Service Broker
	
	-- Resource tier
		Database, filesystem

