package alpha;


import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Logger;

public class Demo {
	

private static Logger log = (Logger) LogManager.getLogger(Demo.class.getName());


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("I am debugging");
		log.info("object is present");
		log.error("objest is not present");
		log.fatal("this is fatal");
	}

}
