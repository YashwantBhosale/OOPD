import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Logger{
	private static Logger instance;

	private Logger() {}

	public static Logger getInstance() {
		if(instance == null) {
			instance = new Logger();
		}
		return instance;
	}
	
	public static void printCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        System.out.println("Current time: " + formattedTime);
    }

	public void log(String message) {
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		System.out.println(formattedTime + " : " + message);	
	}
}

public class Singleton {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Main: Starting application...");

        performCalculation();
        fetchData();
        processData();

        logger.log("Main: Application finished.");
    }

    public static void performCalculation() {
        Logger logger = Logger.getInstance();
        logger.log("performCalculation: Performing some calculations...");
    }

    public static void fetchData() {
        Logger logger = Logger.getInstance();
        logger.log("fetchData: Fetching data from external source...");
    }

    public static void processData() {
        Logger logger = Logger.getInstance();
        logger.log("processData: Processing fetched data...");
    }
}

