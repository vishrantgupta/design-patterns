# GANG OF FOUR DESIGN PATTERN

## SINGLETON
This design pattern is useful when you want single instance of object (with in an instance of JVM)  throughout the application. So in "ideal world" the object will be created once and any future request for object will be fulfilled with existing object.

UML diagram:
-====================================
		ApplicationContext
-====================================
  -instance: ApplicationContext
  -ApplicationContext()
  +getInstance() : ApplicationContext
-------------------------------------

### Eager initialization
This reduces the time required while requesting object for the first time.

public class ApplicationContext {

	// declaring a static member variable
	private static ApplicationContext CONTEXT = new ApplicationContext();
	
	// restrict object creation with constructor
	private ApplicationContext(){}
	
	public ApplicationContext getInstance() {
		return CONTEXT;
	}

}
  
How you can break singleton class and create multiple objects?
