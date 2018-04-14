import java.io.Serializable;

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