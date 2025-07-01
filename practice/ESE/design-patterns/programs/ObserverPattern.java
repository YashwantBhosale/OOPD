// weather update example
// bunch of observers (essentially devices subscribed to weather service)
// when weather administraters update weather all subscribers/observers are notified and updated
// program reference: geeksforgeeks
import java.util.*;

interface Observer{
	void update(String weather);
}

interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}

class WeatherStation implements Subject {
	private List <Observer> observers;
	private String weather;

	WeatherStation() {
		this.observers = new ArrayList<> ();
	}

	public void setWeather(String weather) {
		this.weather = weather;
		notifyObservers();
	}

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(weather);
		}
	}
}

class PhoneDisplay implements Observer {
	private String weather;

	@Override
	public void update(String weather) {
		this.weather = weather;
		this.display();
	}

	public void display() {
		System.out.println("Weather on phone display " + weather);
	}
}

class TVDisplay implements Observer {
	private String weather;

	public void update(String weather) {
		this.weather = weather;
		this.display();
	}

	public void display() {
		System.out.println("Weather on TV display " + weather);
	}
}

public class ObserverPattern {
	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();

		Observer phoneDisplay = new PhoneDisplay();
		Observer tvDisplay = new TVDisplay();

		station.addObserver(phoneDisplay);
		station.addObserver(tvDisplay);

		station.setWeather("Cloudy");
		System.out.println();
		station.setWeather("Sunny");
		System.out.println();
		station.setWeather("Rainy");
		System.out.println();
	}	
}
