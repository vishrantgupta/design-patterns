# GANG OF FOUR DESIGN PATTERN

## SINGLETON
This design pattern is useful when you want single instance of object (with in an instance of JVM)  throughout the application. So in "ideal world" the object will be created once and any future request for object will be fulfilled with existing object.

There can be different [ways for implementing singleton design pattern](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples), I like `Bill Pugh Singleton Implementation`

UML diagram:
<pre>
====================================
	ApplicationContext
====================================
  -instance: ApplicationContext
  -ApplicationContext()
  +getInstance() : ApplicationContext
-------------------------------------
</pre>

But to understand all the problems with different version of singleton implementation, take the following example and comments explaining the use.

```

public class ApplicationContext implements Serializable, Cloneable {
	
	// the variable is made volatile so in multi threaded environment
	// all the threads will have same state of this object
	private static volatile ApplicationContext INSTANCE = null;
	
	// Uncomment below code for Eager initilization
	// = new ApplicationContext();
	
	// Uncomment below code block for static block initilization
	/* static {
		INSTANCE = new ApplicationContext();
	} */
	
	// Constructor is declared private
	private ApplicationContext(){}
	
	public static ApplicationContext getInstance() {
		
		// as acquiring a lock is costly process 
		if (INSTANCE == null) {
			
			// Class level lock: required to avoid creation of multiple
			// instance of this class in multi-threaded environment
			// use of synchronized block is preferred instead of synchronized method
			synchronized (ApplicationContext.class) {
				
				// lazy initilization
				if (INSTANCE == null) {
					INSTANCE = new ApplicationContext();
				}
				
			}
			
		}
		
		return INSTANCE;
	}
	
	// deserialization will break singleton design pattern
	// to avoid that, add readResolve method which is called during
	// deserialization
	protected Object readResolve() {
		return INSTANCE;
	}
	
	// cloning will break singleton design pattern
	// to avoid that, override clone method
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
}

```


  
## How you can break singleton class and create multiple objects?

- Using reflection
- Using deserialization

The solution for above two issues are discussed in above `ApplicationContext` singleton example.
