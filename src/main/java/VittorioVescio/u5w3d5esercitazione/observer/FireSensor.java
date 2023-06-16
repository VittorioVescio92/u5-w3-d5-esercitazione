package VittorioVescio.u5w3d5esercitazione.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class FireSensor {
	private List<Observer> observers = new ArrayList<>();
	private Random r = new Random();
	private int fireSensorId;
	private int smokeLevel;
	private double latitudine;
	private double longitudine;

	public FireSensor(double latitudine, double longitudine) {
		super();
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		setFireSensorId(r.nextInt(0, 20));
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		notifyObservers();
	}

	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

}
